package cn.itcast.jk.notifyurl;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.itcast.jk.controller.BaseController;
import cn.itcast.jk.dao.TradeDao;
import cn.itcast.jk.dao.TradeDetailDao;
import cn.itcast.jk.domain.Student;
import cn.itcast.jk.domain.Trade;
import cn.itcast.jk.domain.TradeDetail;
import cn.itcast.jk.service.StudentService;
import cn.itcast.jk.service.WXPayService;

/**
 * @Description:
 * @Author: nutony
 * @Company: http://java.itcast.cn
 * @CreateDate: 2014年10月9日
 */
@Service
public class NotifyController extends BaseController {
    @Resource
    TradeDao tradeDao;
    @Resource
    TradeDetailDao tradeDetailDao;
    @Resource
    WXPayService wXPayService;
    @Resource
    StudentService studentService;

    // 查看
    @RequestMapping("/basicinfo/weixinpay/notify.action")
    public void wxPayNotify() {
        Map<String, Object> map = new HashMap<>();
        // 所有未同步订单
        map.put("state", 7);
        List<Trade> list = tradeDao.find(map);
        if (list != null) {
            for (Trade t : list) {
                Map<String, String> orderResult = wXPayService
                        .QueryOrderByOut_Trade_No(t.getOutTradeNo());
                // 支付成功
                if (orderResult != null) {
                    t.setBankType(orderResult.get("bank_type"));
                    t.setTransactionId(orderResult.get("transaction_id"));
                    t.setFeeType(orderResult.get("fee_type"));
                    t.setDeviceInfo(orderResult.get("device_info"));
                    t.setTradeType(orderResult.get("trade_type"));
                    t.setTimeEnd(orderResult.get("time_end"));
                    t.setCashFee(Double.parseDouble(orderResult.get("cash_fee")
                            .trim()));
                    t.setState(0);
                    tradeDao.update(t);
                    Map<String, Object> paraMap = new HashMap<String, Object>();
                    paraMap.put("tradeId", t.getId());
                    List<TradeDetail> list2 = tradeDetailDao.find(paraMap);
                    if (list2 != null) {
                        for (TradeDetail td : list2) {
                            td.setTradeState(0);
                            tradeDetailDao.update(td);
                        }
                    }
                } else {
                    if (t.getCategory() == 1) {
                        // 回滚账户金额
                        Student student = studentService.get(t
                                .getPayUserOpenid());
                        String temp = new DecimalFormat("######0.00")
                                .format(student.getXianjin() - t.getTotalFee());
                        student.setXianjin(Double.parseDouble(temp));
                        studentService.update(student);

                    }
                    tradeDao.deleteById(t.getId());
                    Map<String, Object> paraMap = new HashMap<String, Object>();
                    paraMap.put("tradeId", t.getId());
                    List<TradeDetail> list2 = tradeDetailDao.find(paraMap);
                    if (list2 != null) {
                        for (TradeDetail td : list2) {
                            tradeDetailDao.deleteById(td.getId());
                        }
                    }
                }
            }
        }

    }

}

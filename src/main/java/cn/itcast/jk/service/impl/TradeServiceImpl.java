package cn.itcast.jk.service.impl;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.itcast.jk.dao.TradeDao;
import cn.itcast.jk.dao.TradeDetailDao;
import cn.itcast.jk.domain.Trade;
import cn.itcast.jk.domain.TradeDetail;
import cn.itcast.jk.pagination.Page;
import cn.itcast.jk.service.TradeService;
import cn.itcast.jk.service.WXPayService;
import cn.itcast.jk.vo.TradeVO;

/**
 * @Description:
 * @Author: nutony
 * @Company: http://java.itcast.cn
 * @CreateDate: 2014年10月9日
 */
@Service
public class TradeServiceImpl implements TradeService {
    @Resource
    TradeDao tradeDao;
    @Resource
    TradeDetailDao tradeDetailDao;
    @Resource
    WXPayService wXPayService;

    @Override
    public List<Trade> findPage(Page<?> page) {
        return null;
    }

    @Override
    public List<Trade> find(Map<?, ?> paraMap) {
        return tradeFilter(tradeDao.find(paraMap));
    }

    // 更新数据库
    private List<Trade> tradeFilter(List<Trade> list) {
        Iterator<Trade> it = list.iterator();
        while (it.hasNext()) {
            if (tradeFilterOne(it.next())) {
                it.remove();
            }
        }
        if (list.size() == 0) {
            return null;
        }
        return list;
    }

    // 更新数据库，返回true，要删除Trade
    private boolean tradeFilterOne(Trade t) {
        if (t.getWeixinmoney() > 0 && t.getTransactionId() == null) {
            Map<String, String> orderResult = wXPayService
                    .QueryOrderByOut_Trade_No(t.getOutTradeNo());
            if (orderResult != null) {
                t.setBankType(orderResult.get("bank_type"));
                t.setTransactionId(orderResult.get("transaction_id"));
                t.setFeeType(orderResult.get("fee_type"));
                t.setDeviceInfo(orderResult.get("device_info"));
                t.setTradeType(orderResult.get("trade_type"));
                t.setTimeEnd(orderResult.get("time_end"));
                t.setCashFee(Double.parseDouble(orderResult.get("cash_fee")
                        .trim()));
                tradeDao.update(t);
                return false;
            } else {
                tradeDao.deleteById(t.getId());
                Map<String, Object> paraMap = new HashMap<String, Object>();
                paraMap.put("tradeId", t.getId());
                List<TradeDetail> list = tradeDetailDao.find(paraMap);
                if (list != null) {
                    for (TradeDetail td : list) {
                        tradeDetailDao.deleteById(td.getId());
                    }
                }
                return true;
            }
        }
        return false;
    }



    public Trade get(Serializable id) {
        Trade t = tradeDao.get(id);
        if (tradeFilterOne(t)) {
            return null;
        }
        return t;
    }

    public void insert(Trade trade) {
        // trade.setId(UUID.randomUUID().toString()); //设置UUID
        trade.setState(0); // 默认启用状态
        tradeDao.insert(trade);
    }

    public void update(Trade trade) {
        tradeDao.update(trade);
    }

    public void deleteById(Serializable id) {
        tradeDao.deleteById(id);
    }

    public void delete(Serializable[] ids) {
        tradeDao.delete(ids);
    }

    public void start(Serializable[] ids) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("state", 1); // 1启用
        map.put("ids", ids);

        tradeDao.updateState(map);
    }

    public void stop(Serializable[] ids) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("state", 0); // 0停用
        map.put("ids", ids);

        tradeDao.updateState(map);
    }

    public List<Trade> getTradeList() {
        Map<String, Object> paraMap = new HashMap<String, Object>();
        paraMap.put("state", 1); // 1启用，代表只查询启用的类别
        tradeDao.find(paraMap);
        return null;
    }

    @Override
    public TradeVO view(String tradeId) {
        return tradeFilterMore(tradeId);
    }

    private TradeVO tradeFilterMore(String tradeId) {
        TradeVO t = tradeDao.view(tradeId);
        if (t.getWeixinmoney() > 0 && t.getTransactionId() == null) {
            Map<String, String> orderResult = wXPayService
                    .QueryOrderByOut_Trade_No(t.getOutTradeNo());
            if (orderResult != null) {
                Trade tr = new Trade();
                tr.setId(t.getId());
                tr.setOutTradeNo(t.getOutTradeNo());
                tr.setPayUserId(t.getPayUserId());
                tr.setPayUserName(t.getPayUserName());
                tr.setPayUserOpenid(t.getPayUserOpenid());
                tr.setBankType(orderResult.get("bank_type"));
                tr.setTransactionId(orderResult.get("transaction_id"));
                tr.setFeeType(orderResult.get("fee_type"));
                tr.setDeviceInfo(orderResult.get("device_info"));
                tr.setTradeType(orderResult.get("trade_type"));
                tr.setTimeEnd(orderResult.get("time_end"));
                tr.setCashFee(Double.parseDouble(orderResult.get("cash_fee")
                        .trim()) / 100);
                tr.setCategory(t.getCategory());
                tr.setTotalFee(t.getTotalFee());
                tr.setFmoney(t.getTotalFee());
                tr.setWeixinmoney(t.getWeixinmoney());
                tr.setCountmoney(t.getCountmoney());
                tr.setXianjinPay(t.getXianjinPay());
                tr.setState(Integer.parseInt(t.getState()));
                tr.setAreaId(t.getAreaId());
                tr.setAreaName(t.getAreaName());
                tr.setName(t.getName());
                tradeDao.update(tr);
                t = tradeDao.view(tradeId);
            } else {
                tradeDao.deleteById(t.getId());
                Map<String, Object> paraMap = new HashMap<String, Object>();
                paraMap.put("tradeId", t.getId());
                List<TradeDetail> list = tradeDetailDao.find(paraMap);
                if (list != null) {
                    for (TradeDetail td : list) {
                        tradeDetailDao.deleteById(td.getId());
                    }
                }
                t = null;
            }
        }
        return t;
    }

    @Override
    public void updateState(Map<?, ?> paraMap) {
        tradeDao.updateState(paraMap);
    }

}

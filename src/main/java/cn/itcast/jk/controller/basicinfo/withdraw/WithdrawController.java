package cn.itcast.jk.controller.basicinfo.withdraw;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.wxpay.sdk.WXPayUtil;
import cn.itcast.jk.controller.BaseController;
import cn.itcast.jk.domain.UrRo;
import cn.itcast.jk.domain.Withdraw;
import cn.itcast.jk.params.TransfersParams;
import cn.itcast.jk.service.StudentService;
import cn.itcast.jk.service.WXPayService;
import cn.itcast.jk.service.WithdrawService;
import cn.itcast.jk.vo.SysUserVO;
import cn.itcast.qg.wxpay.MyWxPayConfig;

/**
 * @Description:
 * @Author: nutony
 * @Company: http://java.itcast.cn
 * @CreateDate: 2014年10月9日
 */
@Controller
public class WithdrawController extends BaseController {
    @Resource
    WithdrawService withdrawService;
    @Resource
    WXPayService wxPayService;
    @Resource
    StudentService studentService;

    // 列表
    @RequestMapping("/basicinfo/withdraw/list.action")
    public String list(HttpServletRequest request, Model model, String state) {
        SysUserVO sys = (SysUserVO) request.getSession().getAttribute(
                "sysUserVO");
        Map<String, String> map = new HashMap<>();

        for (UrRo r : sys.getRoles()) {
            if (r.getSroleId().equals("21"))//
            {
                if (state == null) {
                    map.put("state", "0");
                } else {
                    map.put("state", state);

                }
                map.put("areaId", sys.getAreaId() + "");

                List<Withdraw> dataList = withdrawService.find(map);
                model.addAttribute("dataList", dataList); // 将数据传递到页面

                return "/basicinfo/withdraw/jWithdrawListf.jsp"; // 转向页面

            } else if (r.getSroleId().equals("22"))//
            {
                if (state == null) {
                    map.put("state", "1");
                } else {
                    map.put("state", state);

                }
                List<Withdraw> dataList = withdrawService.find(map);
                model.addAttribute("dataList", dataList); // 将数据传递到页面

                return "/basicinfo/withdraw/jWithdrawListz.jsp"; // 转向页面

            }
        }

        // 将数据传递到页面

        return "/baseinfo/error.jsp";

    }

    // 查看
    @RequestMapping("/basicinfo/withdraw/toview.action")
    public String toview(String id, Model model) {
        Withdraw obj = withdrawService.get(id);
        model.addAttribute("obj", obj);

        return "/basicinfo/withdraw/jWithdrawView.jsp";
    }

    /**
     * 提现
     *
     * @param id
     * @return
     */
    @RequestMapping("/basicinfo/withdraw/getmoneysure.action")
    public String getmoneysure(HttpServletRequest request, String id,
                               int state, Model model) {
        // openid
        if (state == 1) {
            SysUserVO sysUserVO = (SysUserVO) request.getSession()
                    .getAttribute("sysUserVO");

            Withdraw withdraw = withdrawService.get(id);
            withdraw.setDealUserId(sysUserVO.getId());
            withdraw.setDealUserName(sysUserVO.getName());
            withdraw.setDealOpenId(sysUserVO.getOpenid());
            withdraw.setDealTime(new Date());
            withdraw.setState(1);
            withdrawService.update(withdraw);

            return "redirect:/basicinfo/withdraw/list.action?state=1";

        } else if (state == 2) {
            Withdraw withdraw = withdrawService.get(id);
            int money = (int) (withdraw.getMoney() * 100);
            TransfersParams params = new TransfersParams();
            params.setAmount(money + "");
            params.setCheck_name("FORCE_CHECK");
            params.setDesc("青果账户提现");
            params.setNonce_str(WXPayUtil.generateNonceStr());
            params.setOpenid(withdraw.getUserOpenId());
            params.setPartner_trade_no(withdraw.getId());
            params.setRe_user_name(withdraw.getUserName());
            params.setSpbill_create_ip(MyWxPayConfig.IP);
            String result = wxPayService.transfers(params);

            // 跳过微信
            /*
			 * withdraw.setDealUserId(sysUserVO.getId());
			 * withdraw.setDealUserName(sysUserVO.getName());
			 * withdraw.setDealOpenId(sysUserVO.getOpenid());
			 * withdraw.setDealTime(new Date()); withdraw.setState(1);
			 * withdrawService.update(withdraw); return
			 * "redirect:/basicinfo/withdraw/list.action?state=1";
			 */

            if (null != result) {
                int index = result.indexOf("return_code");
                String return_code = result.substring(index + 21,
                        result.indexOf("return_code", index + 20) - 5);
                if (return_code.equals("SUCCESS")) {
                    index = result.indexOf("result_code");
                    String result_code = result.substring(index + 21,
                            result.indexOf("result_code", index + 20) - 5);
                    if (result_code.equals("SUCCESS")) {
                        index = result.indexOf("payment_no");
                        String payment_no = result.substring(index + 20,
                                result.indexOf("payment_no", index + 20) - 5);
                        index = result.indexOf("payment_time");
                        String payment_time = result.substring(index + 22,
                                result.indexOf("payment_time", index + 20) - 5);

                        withdraw.setPaymentNo(payment_no);
                        withdraw.setPaymentTime(payment_time);
                        // 处理人信息
                        withdraw.setState(2);
                        withdrawService.update(withdraw);
                        model.addAttribute("message", withdraw.getUserName()
                                + "退款成功");
                        model.addAttribute("url",
                                "/basicinfo/withdraw/list.action?state=1");
                    } else {
                        //提现状态设为未通过，提示用户未通过，需要走人工
                        Withdraw unCheckedWithdraw = new Withdraw();
                        unCheckedWithdraw.setState(3);
                        withdrawService.update(unCheckedWithdraw);
                        index = result.indexOf("err_code");
                        String err_code = result.substring(index + 18,
                                result.indexOf("err_code", index + 20) - 5);
                        System.out.println("err_code:" + err_code);
                        System.out.println("return_code:" + return_code);
                        System.out.println(result);

                        if (err_code.equals("AMOUNT_LIMIT")) {
                            System.out.println("付款金额不能小于最低限额");
                            model.addAttribute("message", "付款金额不能小于最低限额\n" + result);
                            model.addAttribute("url",
                                    "/basicinfo/withdraw/list.action?state=2");
                        } else if (err_code.equals("PARAM_ERROR")) {
                            System.out.println("参数错误");
                            System.out.println(result);
                            model.addAttribute("message", "参数错误\n" + result);
                            model.addAttribute("url",
                                    "/basicinfo/withdraw/list.action?state=2");
                        } else if (err_code.equals("NOTENOUGH")) {
                            System.out.println("余额不足");
                            model.addAttribute("message", "余额不足\n" + result);
                            model.addAttribute("url",
                                    "/basicinfo/withdraw/list.action?state=2");
                        } else if (err_code.equals("SEND_FAILED")) {
                            System.out.println("付款错误 付款失败，请换单号重试 ");
                            model.addAttribute("message", "付款错误 付款失败，请换单号重试\n" + result);
                            model.addAttribute("url",
                                    "/basicinfo/withdraw/list.action?state=2");
                        } else if (err_code.equals("NAME_MISMATCH")) {
                            System.out.println("姓名校验出错");
                            model.addAttribute("message", "姓名校验出错\n" + result);
                            model.addAttribute("url",
                                    "/basicinfo/withdraw/list.action?state=2");
                        } else if (err_code.equals("MONEY_LIMIT")) {
                            System.out.println("已经达到今日付款总额上限/已达到付款给此用户额度上限");
                            model.addAttribute("message",
                                    "已经达到今日付款总额上限/已达到付款给此用户额度上限\n" + result);
                            model.addAttribute("url",
                                    "/basicinfo/withdraw/list.action?state=2");
                        } else if (err_code.equals("CA_ERROR")) {
                            System.out.println("证书出错");
                            model.addAttribute("message", "证书出错\n" + result);
                            model.addAttribute("url",
                                    "/basicinfo/withdraw/list.action?state=2");
                        } else if (err_code.equals("V2_ACCOUNT_SIMPLE_BAN")) {
                            System.out.println("无法给非实名用户付款");
                            model.addAttribute("message", "无法给非实名用户付款\n" + result);
                            model.addAttribute("url",
                                    "/basicinfo/withdraw/list.action?state=2");
                        } else if (err_code.equals("SYSTEMERROR")) {
                            System.out
                                    .println("系统错误，请重试 请使用原单号以及原请求参数重试，否则可能造成重复支付等资金风险 ");
                            model.addAttribute("message",
                                    "系统错误，请重试 请使用原单号以及原请求参数重试，否则可能造成重复支付等资金风险\n"
                                            + result);
                            model.addAttribute("url",
                                    "/basicinfo/withdraw/list.action?state=2");
                        } else {
                            System.out.println(result);
                            model.addAttribute("message", result);
                            model.addAttribute("url",
                                    "/basicinfo/withdraw/list.action?state=2");
                        }
                    }
                    return "/basicinfo/withdraw/jWithdrawMes.jsp";
                }

                return "redirect:/basicinfo/withdraw/list.action?state=2";

            }
            return null;
        }
        return null;
    }
}
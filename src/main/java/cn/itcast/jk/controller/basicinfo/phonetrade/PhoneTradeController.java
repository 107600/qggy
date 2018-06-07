package cn.itcast.jk.controller.basicinfo.phonetrade;

import java.io.UnsupportedEncodingException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import cn.itcast.jk.dao.TradeDao;
import cn.itcast.jk.dao.TradeDetailDao;
import cn.itcast.jk.service.*;
import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.itcast.jk.controller.BaseController;
import cn.itcast.jk.domain.Course;
import cn.itcast.jk.domain.JsonDateValueProcessor;
import cn.itcast.jk.domain.Student;
import cn.itcast.jk.domain.Trade;
import cn.itcast.jk.domain.TradeDetail;
import cn.itcast.jk.vo.TradeVO;
import cn.itcast.qg.wxpay.CodeUtils;
import cn.itcast.qg.wxpay.JsApiPay;
import cn.itcast.qg.wxpay.MyWxPayConfig;
import cn.itcast.util.OrderUtil;

import com.github.wxpay.sdk.WXPay;
import com.github.wxpay.sdk.WXPayConstants;
import com.github.wxpay.sdk.WXPayUtil;

/**
 * @Description:
 * @Author: nutony
 * @Company: http://java.itcast.cn
 * @CreateDate: 2014年10月9日
 */
@Controller
public class PhoneTradeController extends BaseController {
    @Resource
    TradeService tradeService;
    @Resource
    StudentService studentService;
    @Resource
    CourseService courseService;
    @Resource
    TradeDetailService tradedetailService;
    @Resource
    TradeDao tradeDao;
    @Resource
    WXPayService wXPayService;
    @Resource
    TradeDetailDao tradeDetailDao;

    private static final Log log = LogFactory.getLog(PhoneTradeController.class);

    // 列表
    @RequestMapping("/phone/user/basicinfo/trade/list.action")
    public @ResponseBody
    String list(HttpSession session, int state) {
        Student s = (Student) session.getAttribute("user");

        Map<String, String> map = new HashMap<>();
        map.put("payUserId", s.getId());
        if (state >= 0) {
            map.put("state", state + "");
        }
        map.put("category", "0");
        List<Trade> dataList = tradeService.find(map);

        JsonConfig config = new JsonConfig();
        config.setIgnoreDefaultExcludes(false);
        config.registerJsonValueProcessor(java.util.Date.class,
                new JsonDateValueProcessor());
        JSONArray jsonObject = JSONArray.fromObject(dataList, config);
        // System.out.println(jsonObject.toString());
        return jsonObject.toString();
    }

    // 个人充值查询
    @RequestMapping("/phone/user/basicinfo/trade/listrecharge.action")
    public @ResponseBody
    String listrecharge(HttpSession session, int category) {
        Student s = (Student) session.getAttribute("user");

        Map<String, String> map = new HashMap<>();
        map.put("payUserId", s.getId());
        map.put("category", category + "");
        List<Trade> dataList = tradeService.find(map);
        JsonConfig config = new JsonConfig();
        config.setIgnoreDefaultExcludes(false);
        config.registerJsonValueProcessor(java.util.Date.class,
                new JsonDateValueProcessor());
        JSONArray jsonObject = JSONArray.fromObject(dataList, config);

        return jsonObject.toString();
    }

    // 个人充值查询
    @RequestMapping("/phone/user/basicinfo/trade/listrechargeone.action")
    public @ResponseBody
    String listrechargeone(HttpSession session, String id) {

        Trade dataList = tradeService.get(id);
        JsonConfig config = new JsonConfig();
        config.setIgnoreDefaultExcludes(false);
        config.registerJsonValueProcessor(java.util.Date.class,
                new JsonDateValueProcessor());
        JSONArray jsonObject = JSONArray.fromObject(dataList, config);

        return jsonObject.toString();
    }

    @RequestMapping("/phone/public/basicinfo/trade/czsucess.action")
    public String czsucess(HttpSession session, String id, Model model) {
        Trade dataList = tradeService.get(id);
//        //Student student = (Student) session.getAttribute("user");
//        Student student = studentService.get(((Student)session.getAttribute("user")).getUserOpenid());
//        DecimalFormat df = new DecimalFormat("######0.00");
//        // 更新课程余额
//
//        String xianjin = df.format(student.getXianjin()
//                - dataList.getTotalFee());
//        model.addAttribute("xianjin", xianjin);
        model.addAttribute("trade", dataList);

        return "/basicinfo/trade/czsucess.jsp";
    }

    @RequestMapping("/phone/user/basicinfo/trade/tocreate.action")
    public String tocreate(Model model, int id, HttpSession session) {

        Course course = courseService.get(id);
        model.addAttribute("course", course);
        Student s = (Student) session.getAttribute("user");

        if (s.getAvailableAssets() > course.getCoursePrice()) {
            model.addAttribute("xianjinpay", 0.00);
            model.addAttribute("coursepay", course.getCoursePrice());
            model.addAttribute("wxpay", 0.00);
        } else {
            model.addAttribute("coursepay", s.getAvailableAssets());
            if (s.getAvailableAssets() + s.getXianjin() > course
                    .getCoursePrice()) {
                model.addAttribute("wxpay", 0.00);
                model.addAttribute("xianjinpay", Double
                        .parseDouble(new DecimalFormat("######0.00")
                                .format(course.getCoursePrice()
                                        - s.getAvailableAssets())));

            } else {
                model.addAttribute("xianjinpay", s.getXianjin());

                model.addAttribute("wxpay", Double
                        .parseDouble(new DecimalFormat("######0.00")
                                .format(course.getCoursePrice()
                                        - s.getAvailableAssets()
                                        - s.getXianjin())));
            }
        }

        return "/basicinfo/trade/order.jsp";

    }

    // 充值生成预订单
    @RequestMapping(value = "/phone/user/basicinfo/trade/czprepay.action", method = RequestMethod.GET)
    public String czpaypre(double money, HttpSession session, Model model) {

        JsApiPay jspay = new JsApiPay();
        jspay.setTradeid(OrderUtil.getOrderNo());
        jspay.setTotalfee(money);
        jspay.setCountmoney(0);
        jspay.setWeixinmoney(money);
        jspay.setXianjin(0);
        String out_trade_no = WXPayUtil.generateNonceStr();
        String body = "账户充值 ";
        jspay.setOuttradeno(out_trade_no);
        jspay.setBody(body);

        Map<String, String> unifiedOrderParams = new HashMap<String, String>();
        unifiedOrderParams.put("appid", MyWxPayConfig.APPID);
        unifiedOrderParams.put("mch_id", MyWxPayConfig.MCHID);
        unifiedOrderParams.put("device_info", "WEB");
        unifiedOrderParams.put("body", body);
        unifiedOrderParams.put("trade_type", "JSAPI");
        unifiedOrderParams.put("nonce_str", WXPayUtil.generateNonceStr());
        unifiedOrderParams.put("out_trade_no", out_trade_no);
        unifiedOrderParams.put("notify_url", MyWxPayConfig.WXNOTIFY_URL);
        System.out.println(jspay.getWeixinmoney() * 100);
        unifiedOrderParams.put("total_fee",
                (int) (jspay.getWeixinmoney() * 100) + "");
        unifiedOrderParams.put("openid",
                ((Student) session.getAttribute("user")).getUserOpenid());

        Map<String, String> jsApiParams = null;
        String wxJsApiParam = null;
        try {
            unifiedOrderParams.put("sign", WXPayUtil.generateSignature(
                    unifiedOrderParams, MyWxPayConfig.KEY));
            // System.out.println(WXPayUtil.mapToXml(unifiedOrderParams));
            Map<String, String> unifiedOrderResult;

            unifiedOrderResult = new WXPay(new MyWxPayConfig())
                    .unifiedOrder(unifiedOrderParams);

            String prepay_id = unifiedOrderResult.get("prepay_id");
            System.out.println("prepay_Id" + prepay_id + "++++++++++++++");

            jspay.setPrepayid(prepay_id);
            jsApiParams = new HashMap<String, String>();
            jsApiParams.put("appId", MyWxPayConfig.APPID);
            jsApiParams
                    .put("timeStamp", System.currentTimeMillis() / 1000 + "");
            jsApiParams.put("package", "prepay_id=" + prepay_id);
            jsApiParams.put("nonceStr", WXPayUtil.generateNonceStr());
            jsApiParams.put("signType", WXPayConstants.MD5);

            jsApiParams
                    .put("paySign", WXPayUtil.generateSignature(jsApiParams,
                            MyWxPayConfig.KEY));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        wxJsApiParam = CodeUtils.mapToJson(jsApiParams);

        session.setAttribute("czjspay", jspay);
        System.out.println(wxJsApiParam);
        model.addAttribute("wxJsApiParam", wxJsApiParam);
        model.addAttribute("money", money);

        Student student = (Student) session.getAttribute("user");
        DecimalFormat df = new DecimalFormat("######0.00");
        // 更新课程余额
        String xianjin = df.format(student.getXianjin() + money);
        model.addAttribute("xianjin", xianjin);

        return "/basicinfo/trade/czpaymoney.jsp";

    }

    // 生成预订单,isweixin为1，表示为微信内置浏览器
    @RequestMapping(value = "/phone/user/basicinfo/trade/paypreorder.action", method = RequestMethod.POST)
    public String paypre(String[] userName, String[] phoneNumber, Model model,
                         String id, int amount, String remark, int isweixin,
                         HttpServletRequest request, HttpSession session)
            throws UnsupportedEncodingException {

        List<Student> list = new ArrayList<Student>();
        System.out.println(userName.length + "比较" + amount);
        Student user = (Student) session.getAttribute("user");
        if (userName.length == amount || (userName.length == 0 && amount == 1)) {
            System.out.println("包含用户自己");
            Student student = new Student();

            student.setUserName(user.getUserName());
            student.setPhoneNumber(user.getPhoneNumber());
            student.setWeiXin(user.getWeiXin());
            System.out.println(student.toString());
            list.add(student);
        }
        for (int i = 0; i < userName.length - 1; i++) {
            System.out.println(userName[i]);
            Student student = new Student();
            student.setUserName(userName[i]);
            student.setPhoneNumber(phoneNumber[i]);

            list.add(student);
        }
        Course cd = courseService.get(id);
        double sum = cd.getCoursePrice() * amount;
        System.out.println("sum" + sum);
        JsApiPay jspay = new JsApiPay();
        jspay.setTradeid(OrderUtil.getOrderNo());
        jspay.setTotalfee(sum);
        if (sum <= user.getAvailableAssets()) {
            jspay.setCountmoney(sum);
            jspay.setWeixinmoney(0.00);
            jspay.setXianjin(0.00);
        } else {
            if (sum <= user.getAvailableAssets() + user.getXianjin()) {
                jspay.setCountmoney(user.getAvailableAssets());
                jspay.setWeixinmoney(0.00);
                jspay.setXianjin(Double.parseDouble(new DecimalFormat(
                        "######0.00").format(sum - user.getAvailableAssets())));
                System.out.println("xianjin" + jspay.getXianjin());
            } else {
                jspay.setCountmoney(user.getAvailableAssets());
                jspay.setXianjin(user.getXianjin());
                jspay.setWeixinmoney(Double.parseDouble(new DecimalFormat(
                        "######0.00").format(sum - user.getAvailableAssets()
                        - user.getXianjin())));

            }
        }
        System.out.println("asdasd" + jspay.getCountmoney());
        jspay.setStudentlist(list);
        System.out.println("remark" + remark + "-----------------------");
        jspay.setRemark(remark);

        String out_trade_no = WXPayUtil.generateNonceStr();
        String body = cd.getCourseName();
        jspay.setOuttradeno(out_trade_no);
        jspay.setCourseid(cd.getId());
        jspay.setAmount(amount);
        jspay.setPrice(cd.getCoursePrice());
        jspay.setBody(body);

        // jspay.setTotalfee(totalfee);
        // 统一下单参数
        if (jspay.getWeixinmoney() > 0) {

            model.addAttribute("course", cd);
            if (isweixin == 1) {
                // 微信内置浏览器
                String wxJsApiParam = null;
                Map<String, String> unifiedOrderParams = new HashMap<String, String>();
                unifiedOrderParams.put("appid", MyWxPayConfig.APPID);
                unifiedOrderParams.put("mch_id", MyWxPayConfig.MCHID);
                unifiedOrderParams.put("device_info", "WEB");
                unifiedOrderParams.put("body", body);
                unifiedOrderParams.put("trade_type", "JSAPI");
                unifiedOrderParams.put("nonce_str",
                        WXPayUtil.generateNonceStr());
                unifiedOrderParams.put("out_trade_no", out_trade_no);
                unifiedOrderParams.put("notify_url", MyWxPayConfig.WXNOTIFY_URL);
                unifiedOrderParams.put("total_fee",
                        (int) (jspay.getWeixinmoney() * 100) + "");
                unifiedOrderParams.put("openid", ((Student) session
                        .getAttribute("user")).getUserOpenid());
                Map<String, String> jsApiParams = null;
                try {
                    unifiedOrderParams.put("sign", WXPayUtil.generateSignature(
                            unifiedOrderParams, MyWxPayConfig.KEY));
                    // System.out.println(WXPayUtil.mapToXml(unifiedOrderParams));
                    Map<String, String> unifiedOrderResult;

                    unifiedOrderResult = new WXPay(new MyWxPayConfig())
                            .unifiedOrder(unifiedOrderParams);
                    System.out.println(WXPayUtil.mapToXml(unifiedOrderResult));
                    String prepay_id = unifiedOrderResult.get("prepay_id");
                    System.out.println("prepay_Id:\t\t" + prepay_id
                            + "++++++++");

                    jspay.setPrepayid(prepay_id);
                    jsApiParams = new HashMap<String, String>();
                    jsApiParams.put("appId", MyWxPayConfig.APPID);
                    jsApiParams.put("timeStamp", System.currentTimeMillis()
                            / 1000 + "");
                    jsApiParams.put("package", "prepay_id=" + prepay_id);
                    jsApiParams.put("nonceStr", WXPayUtil.generateNonceStr());
                    jsApiParams.put("signType", WXPayConstants.MD5);
                    jsApiParams.put("paySign", WXPayUtil.generateSignature(
                            jsApiParams, MyWxPayConfig.KEY));
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }

                wxJsApiParam = CodeUtils.mapToJson(jsApiParams);
                System.out.println(wxJsApiParam.toString());
                session.setAttribute("jspay", jspay);
                model.addAttribute("wxJsApiParam", wxJsApiParam);
                model.addAttribute("jspay", jspay);
                // model.addAttribute("notifyUrl", MyWxPayConfig.NOTIFY_URL);

                return "/basicinfo/trade/paymoney.jsp";
            } else {

                // 第三方浏览器,https://pay.weixin.qq.com/wiki/doc/api/H5.php?chapter=9_20&index=1
                Map<String, String> unifiedOrderParams = new HashMap<String, String>();
                unifiedOrderParams.put("appid", MyWxPayConfig.APPID);
                unifiedOrderParams.put("mch_id", MyWxPayConfig.MCHID);
                unifiedOrderParams.put("device_info", "WEB");
                unifiedOrderParams.put("body", body);
                unifiedOrderParams.put("trade_type", "MWEB");
                unifiedOrderParams.put("nonce_str",
                        WXPayUtil.generateNonceStr());
                unifiedOrderParams.put("out_trade_no", out_trade_no);
                unifiedOrderParams.put("notify_url", MyWxPayConfig.NOTIFY_URL);
                unifiedOrderParams.put("total_fee",
                        (int) (jspay.getWeixinmoney() * 100) + "");
                unifiedOrderParams.put("openid", ((Student) session
                        .getAttribute("user")).getUserOpenid());
                unifiedOrderParams.put("spbill_create_ip",
                        request.getRemoteAddr());
                unifiedOrderParams.put("scene_info",
                        "{\"h5_info\": {\"type\":\"Wap\",\"wap_url\": \""
                                + MyWxPayConfig.WAP_URL + "\",\"wap_name\": \""
                                + MyWxPayConfig.WAP_NAME + "\"}}");

                try {
                    unifiedOrderParams.put("sign", WXPayUtil.generateSignature(
                            unifiedOrderParams, MyWxPayConfig.KEY));
                    System.out.println(WXPayUtil.mapToXml(unifiedOrderParams));
                    Map<String, String> unifiedOrderResult;

                    unifiedOrderResult = new WXPay(new MyWxPayConfig())
                            .unifiedOrder(unifiedOrderParams);
                    System.out.println(WXPayUtil.mapToXml(unifiedOrderResult));
                    String prepay_id = unifiedOrderResult.get("prepay_id");
                    String mweb_url = unifiedOrderResult.get("mweb_url");
                    System.out.println("mweb_url:\t\t" + mweb_url + "--------");
                    jspay.setPrepayid(prepay_id);

                    session.setAttribute("mweb_url", mweb_url);
                    model.addAttribute("mweb_url", mweb_url);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }

                session.setAttribute("jspay", jspay);
                model.addAttribute("jspay", jspay);
                return "/basicinfo/trade/apppaymoney.jsp";
            }

        } else {
            System.out.println("不产生微信支付");
            model.addAttribute("course", cd);

            model.addAttribute("jspay", jspay);
            session.setAttribute("jspay", jspay);
            model.addAttribute("wxJsApiParam", "noweixintrade");

            return "/basicinfo/trade/paymoney.jsp";
        }

    }

    // 查看
    @RequestMapping("/phone/user/basicinfo/trade/toview.action")
    public @ResponseBody
    String toview(String id) {
        System.out.println(id + "000000000000");
        TradeVO obj = tradeService.view(id);
        JsonConfig config = new JsonConfig();
        config.setIgnoreDefaultExcludes(false);
        config.registerJsonValueProcessor(java.util.Date.class,
                new JsonDateValueProcessor());
        JSONArray jsonObject = JSONArray.fromObject(obj, config);

        return jsonObject.toString();
    }

    // 查看
    @RequestMapping("/phone/public/basicinfo/trade/fenxiang.action")
    public String fenxiang(String id, Model model, HttpSession session) {

        TradeVO obj = tradeService.view(id);
        Student student = (Student) session.getAttribute("user");
        System.out.println(student);
        if (student != null
                && obj.getTradedetails().size() == 1
                && obj.getTradedetails().get(0).getUserId()
                .equals(student.getId())) {
            System.out.println("bunengfenxiang");
            return "redirect:/phone/user/myorder.action";
        } else {
            System.out.println("fenxiang");
            model.addAttribute("obj", obj);

            return "/basicinfo/trade/ordersuccess.jsp";
        }
    }

    // 无论是微信支付还是内部账户支付，都做插入，唯一的区别就是微信支付的详细数据会在之后的查询时与微信交互更新数据或者删除（失败删除）
    // 使用paypreorder.action中生成jspay设置的tradeid作为数据表中的tradeid，失败时作为回滚依据（如果回滚失败就真失败了）
    @RequestMapping(value = "/phone/user/basicinfo/trade/orderinsert.action")
    public @ResponseBody
    String orderinsert(HttpServletRequest request) {
        JsApiPay jspay = (JsApiPay) request.getSession().getAttribute("jspay");
        Trade trade = new Trade();
        trade.setCategory(0);
        trade.setTotalFee(jspay.getTotalfee());
        trade.setFmoney(jspay.getTotalfee());
        trade.setWeixinmoney(jspay.getWeixinmoney());
        trade.setCountmoney(jspay.getCountmoney());
        trade.setXianjinPay(jspay.getXianjin());

        Student s = (Student) request.getSession().getAttribute("user");

        // 微信金额大于0
        log.info(jspay.getWeixinmoney()+"==============");
        if (jspay.getWeixinmoney() > 0.00) {
            // 未同步状态
            trade.setState(7);
            log.info("微信支付");
        } else {
            //不產生微信支付
            trade.setState(0);
            String temp = new DecimalFormat("######0.00").format(s
                    .getAvailableAssets() - jspay.getCountmoney());
            s.setAvailableAssets(Double.parseDouble(temp));
            String xinjin = new DecimalFormat("######0.00").format(s.getXianjin()
                    - jspay.getXianjin());
            s.setXianjin(Double.parseDouble(xinjin));
            // 更新session中user
            request.getSession().setAttribute("user", s);
            System.out.println(s.getUserName() + "In orderinsert.action");
            studentService.update(s);
            log.info("不產生微信支付");
        }
        trade.setPayTime(new Date());
        trade.setOutTradeNo(jspay.getOuttradeno());
        trade.setId(jspay.getTradeid());
        trade.setPayUserId(s.getId());
        trade.setPayUserName(s.getUserName());
        trade.setPayUserOpenid(s.getUserOpenid());
        Course course = courseService.get(jspay.getCourseid());
        trade.setAreaId(course.getAreaId());
        trade.setAreaName(course.getAreaName());
        trade.setName(course.getCourseName());
        log.info("state"+trade.getState());
        tradeService.insert(trade);
        for (int i = 0; i < jspay.getStudentlist().size(); i++) {
            Map<String, String> paraMap = new HashMap<String, String>();
            paraMap.put("phoneNumber", jspay.getStudentlist().get(i)
                    .getPhoneNumber());
            paraMap.put("userName", jspay.getStudentlist().get(i).getUserName());

            List<Student> ss = studentService.find(paraMap);
            if (ss != null && ss.size() > 0) {
                TradeDetail detail = new TradeDetail();
                detail.setCourseId(jspay.getCourseid() + "");
                detail.setId(OrderUtil.getOrderNo());
                detail.setTradeId(trade.getId());
                detail.setUserId(ss.get(0).getId());
                detail.setUserName(ss.get(0).getUserName());
                detail.setCourseName(course.getCourseName());
                detail.setUserPhone(ss.get(0).getPhoneNumber());

                detail.setAreaId(course.getAreaId());
                detail.setAreaName(course.getAreaName());
                detail.setClassprice(course.getCoursePrice());
                detail.setCourseCover(course.getCourseCover());
                // 微信金额大于0
                if (jspay.getWeixinmoney() > 0.00) {
                    // 未同步状态
                    detail.setTradeState(7);
                } else {
                    detail.setTradeState(0);
                }
                tradedetailService.insert(detail);

            } else {
                Student sd = jspay.getStudentlist().get(i);
                sd.setId(OrderUtil.getOrderNo());
                sd.setState(1);

                studentService.insert(sd);
                TradeDetail detail = new TradeDetail();
                detail.setCourseId(jspay.getCourseid() + "");
                detail.setId(OrderUtil.getOrderNo());
                detail.setTradeId(trade.getId());
                detail.setUserId(sd.getId());
                detail.setUserName(sd.getUserName());
                detail.setUserPhone(sd.getPhoneNumber());
                detail.setCourseName(course.getCourseName());
                detail.setAreaId(course.getAreaId());
                detail.setAreaName(course.getAreaName());
                detail.setClassprice(course.getCoursePrice());
                detail.setCourseCover(course.getCourseCover());
                // 微信金额大于0
                if (jspay.getWeixinmoney() > 0.00) {
                    // 未同步状态
                    detail.setTradeState(7);
                } else {
                    detail.setTradeState(0);
                }
                tradedetailService.insert(detail);

            }

        }

        request.getSession().removeAttribute("jspay");
        JSONArray jsonObject = JSONArray.fromObject(trade);
        return jsonObject.toString();

    }

    // 下单付款
    @RequestMapping(value = "/phone/user/basicinfo/trade/czinsert.action", method = RequestMethod.GET)
    public @ResponseBody
    String czinsert(HttpServletRequest request) {
        JsApiPay jspay = (JsApiPay) request.getSession()
                .getAttribute("czjspay");

        Trade trade = new Trade();
        trade.setCategory(1);
        trade.setTotalFee(jspay.getTotalfee());
        trade.setFmoney(jspay.getTotalfee());
        trade.setWeixinmoney(jspay.getWeixinmoney());
        trade.setCountmoney(jspay.getCountmoney());
        trade.setXianjinPay(jspay.getXianjin());
        // 未同步状态
        trade.setState(7);
        request.getSession().setAttribute("sync", 1);

        trade.setPayTime(new Date());
        trade.setOutTradeNo(jspay.getOuttradeno());

        trade.setId(jspay.getTradeid());
        Student s = (Student) request.getSession().getAttribute("user");
        System.out.println(s.getUserName() + "In czinsert.action");

        trade.setPayUserId(s.getId());
        trade.setPayUserName(s.getUserName());
        trade.setPayUserOpenid(s.getUserOpenid());

        trade.setAreaId(s.getAreaId());
        trade.setAreaName(s.getAreaName());
        trade.setName("充值");
        tradeService.insert(trade);

        request.getSession().removeAttribute("czjspay");
        JSONArray jsonObject = JSONArray.fromObject(trade);
        return jsonObject.toString();

    }

    // 只能回滚内部账户支付，因为微信支付失败时，微信负责回滚给用户，微信支付失败的详细数据会在之后的查询时填充完成或删除
    @RequestMapping(value = "/phone/user/basicinfo/trade/rollbackinsert.action", method = RequestMethod.GET)
    public @ResponseBody
    String rollbackinsert(HttpServletRequest request) {
        Student s = (Student) request.getSession().getAttribute("user");
        JsApiPay jspay = (JsApiPay) request.getSession()
                .getAttribute("czjspay");

        Map<String, String> params = new HashMap<String, String>();
        params.put("id", s.getId());
        Student datas = (Student) studentService.find(params);

        if (datas.getAvailableAssets() != s.getAvailableAssets()
                || datas.getXianjin() != s.getXianjin()) {
            // 数据库已插入，session未更新
            request.getSession().setAttribute("user", s);
            TradeVO tradevo = tradeService.view(jspay.getTradeid());
            if (tradevo != null) {
                tradeService.deleteById(jspay.getTradeid());
                if (tradevo.getTradedetails() != null) {
                    for (TradeDetail td : tradevo.getTradedetails()) {
                        tradedetailService.deleteById(td.getId());
                    }
                }
            }
        }
        JSONArray jsonObject = JSONArray.fromObject("success");
        return jsonObject.toString();

    }

    // 查看
    @RequestMapping("/notify.action")
    public void wxPayNotify() throws InterruptedException {
        Thread.currentThread().sleep(2000);
        log.info("通知接口進入，開始過濾");
        Map<String, Object> map = new HashMap<>();
        // 所有未同步订单
        map.put("state", 7);
        List<Trade> list = tradeDao.find(map);
        if (list != null) {
            for (Trade t : list) {
                log.info(t.getId()+","+t.getState());
//                微信訂單同步
                Map<String, String> orderParams = new HashMap<String, String>();
                orderParams.put("appid", MyWxPayConfig.APPID);
                orderParams.put("mch_id", MyWxPayConfig.MCHID);
                orderParams.put("out_trade_no", t.getOutTradeNo());
                orderParams.put("nonce_str", WXPayUtil.generateNonceStr());
                // 默认使用MD5
                Map<String, String> orderResult=null;
                try {
                    orderParams
                            .put("sign", WXPayUtil.generateSignature(orderParams,
                                    MyWxPayConfig.KEY));
                    orderResult = new WXPay(new MyWxPayConfig()).orderQuery(orderParams);
                    String return_code = orderResult.get("return_code");
                    log.info("return code :"+CodeUtils.mapToJson(orderResult));
                    if (return_code.equals("SUCCESS")
                            && orderResult.get("result_code").equals("SUCCESS")
                            && orderResult.get("trade_state").equals("SUCCESS")) {


                    } else if (return_code.equals("NOTENOUGH")) {
                        System.out.println("余额不足 用户帐号余额不足  ");
                    }else{
                        orderResult=null;
                    }
                } catch (Exception e) {
                    log.info(e.getMessage());
                }
                // 支付成功
                if (orderResult != null) {
                    //充值成功，需要更新账户
                    if (t.getCategory() == 1) {
                        // 跟新账户金额
                        Student student = studentService.get(t
                                .getPayUserOpenid());
                        String temp = new DecimalFormat("######0.00").format(student.getXianjin()
                                + t.getTotalFee());

                        log.info("更新前账户金额："+student.getXianjin());
                        log.info("充值金额："+t.getTotalFee());
                        student.setXianjin(Double.parseDouble(temp));

                        studentService.update(student);
                        log.info("更新后的金额："+student.getXianjin());
                    }


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
                            log.info(t.getId());
                            tradeDetailDao.update(td);
                        }
                        log.info("子订单更新成功");
                    }
                } else {
                    //删掉当前订单
                    tradeDao.deleteById(t.getId());
                    Map<String, Object> paraMap = new HashMap<String, Object>();
                    paraMap.put("tradeId", t.getId());
                    List<TradeDetail> list2 = tradeDetailDao.find(paraMap);
                    if (list2 != null) {
                        for (TradeDetail td : list2) {
                            tradeDetailDao.deleteById(td.getId());
                        }
                    }
                    log.info("删除订单失败");
                }
            }
        }

    }

}

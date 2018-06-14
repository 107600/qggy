package cn.itcast.jk.controller;

import javax.servlet.http.HttpSession;

import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.itcast.jk.domain.Student;

@Controller
public class PhoneUserHomeController {

    @RequestMapping("/phone/user/main.action")
    public String main(Model model, HttpSession session) {
        Student student = (Student) session.getAttribute("user");

        model.addAttribute("state", student.getState());

        return "/basicinfo/phoneuser/Main.jsp";
    }

    // 我的课程/qggy/phone/user/becomedaoshi.action
    @RequestMapping("/phone/user/myclass.action")
    public String myclass(String state) {
        if (state == null) {
            return "/basicinfo/phoneuser/myclass.html?state=0";
        } else {
            return "/basicinfo/phoneuser/myclass.html?state=" + state;
        }
    }

    @RequestMapping("/phone/user/flush.action")
    public String flush(String state) {
        return "/basicinfo/phoneuser/flush.jsp";
    }

    // 全部课程
    @RequestMapping("/phone/user/myclassall.action")
    public String myclassall(String id) {
        return "/basicinfo/phoneuser/myclassall.html?id=" + id;
    }

    // 开班待确认
    @RequestMapping("/phone/user/myclasscheck.action")
    public String myclasscheck(String id) {
        return "/basicinfo/phoneuser/myclasscheck.html?id=" + id;
    }

    // 个人信息
    @RequestMapping("/phone/user/myinfo.action")
    public String myinfo() {
        return "/basicinfo/trade/myinfo.jsp";
    }

    // 考勤记录
    @RequestMapping("/phone/user/myattendance.action")
    public String myattendancce() {
        return "/basicinfo/phoneuser/coming.jsp";

        //return "/basicinfo/phoneuser/myattendance.html";
    }

    // 退款记录
    @RequestMapping("/phone/user/myrefund.action")
    public String myrefund() {
        return "/basicinfo/phoneuser/refund.html";
    }

    // 退款详情
    @RequestMapping("/phone/user/refundDetail.action")
    public String refundDetail(String id) {
        return "/basicinfo/phoneuser/refundDetail.html?id=" + id;
    }

    //
    @RequestMapping("/phone/user/mytradedetail.action")
    public String mytradedetail() {
        return "/basicinfo/phoneuser/mytradedetail.html";
    }

    // 提现
    @RequestMapping("/phone/user/mywithdraw.action")
    public String mywithdraw() {
        return "/basicinfo/phoneuser/withdraw.html";
    }

    // 提现详情
    @RequestMapping("/phone/user/withdrawDetail.action")
    public String mywithdrawdetail(String id) {
        return "/basicinfo/phoneuser/withdrawDetail.html?id=" + id;
    }

    // 我的订单
    @RequestMapping("/phone/user/myorder.action")
    public String myorder() {
        System.out.println("nfo/phoneuser/myorder.html");
        return "/basicinfo/phoneuser/myorder.html";
    }

    // 订单
    @RequestMapping("/phone/user/orderDetail.action")
    public String orderDetail(String id) {
        System.out.println("jinru");
        return "/basicinfo/phoneuser/orderDetail.html?id" + id;
    }

    // 子订单详情
    @RequestMapping("/phone/user/cellOrderDetail.action")
    public String cellOrderDetail(String id) {
        return "/basicinfo/phoneuser/cellOrderDetail.html?id=" + id;
    }

    // 内部转账
    @RequestMapping("/phone/user/mytransfer.action")
    public String myTransfer() {
        return "/basicinfo/phoneuser/mytransfer.html";
    }

    // 内部转账详情
    @RequestMapping("/phone/user/transferdetail.action")
    public String transferdetail(String id) {
        return "/basicinfo/phoneuser/transferdetail.html?id=" + id;
    }

    // 充值记录
    @RequestMapping("/phone/user/myRecharge.action")
    public String myRecharge() {
        return "/basicinfo/phoneuser/myrecharge.html";
    }

    // 押金
    @RequestMapping("/phone/user/myyajin.action")
    public String myyajin() {
        return "/basicinfo/phoneuser/gryj.html";
    }

    // 个人押金
    @RequestMapping("/phone/user/myyajin1.action")
    public String myyajin1() {
        return "/basicinfo/phoneuser/gryj2.html";
    }

    // 个人押金2
    @RequestMapping("/phone/user/myyajin2.action")
    public String myyajin2() {
        return "/basicinfo/phoneuser/gryj3.html";
    }

    // 个人押金3
    @RequestMapping("/phone/user/myyajin3.action")
    public String myyajin3() {
        return "/basicinfo/phoneuser/gryj.html";
    }

    // 导师课程押金
    @RequestMapping("/phone/user/kcyj.action")
    public String kcyj() {
        return "/basicinfo/phoneuser/kcyj.html";
    }


    // 充值详情
    @RequestMapping("/phone/user/myRechargedetail.action")
    public String myRechargedetail(String id) {

        return "/basicinfo/phoneuser/rechargedetail.html?id=" + id;
        // return "/basicinfo/phoneuser/cellOrderDetail.html?id=" + id;

    }

    // 课程列表
    @RequestMapping("/phone/user/teachercourselist.action")
    public String teachercourselist() {
        return "/basicinfo/teacher/courselist.html";
    }

    // 班级列表
    @RequestMapping("/phone/user/teacherclasslist.action")
    public String teacherclasslist() {
        return "/basicinfo/teacher/classlist.html";
    }

    @RequestMapping("/phone/user/becomedaoshi.action")
    public String becomedaoshi(HttpSession session, Model model) {
        model.addAttribute("teacher", (Student) session.getAttribute("user"));
        return "/basicinfo/phoneuser/becomedaoshi.jsp";
    }

    //活动中心
    @RequestMapping("/phone/user/activitycenter.action")
    public String activitycenter() { return "/basicinfo/phoneuser/activitycenter.html";}

    //确认内部转账
    @RequestMapping("/phone/user/suretiqutoxianjin.action")
    public String myTransfer(double money) {
        return "/basicinfo/phoneuser/suretiqutoxianjin.html?money=" + money;
    }

    //app接口转向个人中心
    @RequestMapping("/app/user/user.action")
    public String appToUserCenter() {
       return "/basicinfo/phoneuser/Main.jsp";
    }

}

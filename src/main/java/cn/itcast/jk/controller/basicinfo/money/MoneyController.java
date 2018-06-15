package cn.itcast.jk.controller.basicinfo.money;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class MoneyController {

    //列表,显示导师申请酬金的全部列表
    @RequestMapping("basicinfo/money/tutorMoneyList.action")
    public String tutorMoneylist(Model model, HttpSession session, String likes) {
        return "money/tutorMoneyManage.html";
    }

    //列表,显示匠人申请酬金的全部列表
    @RequestMapping("basicinfo/money/craftsmanMoneyList.action")
    public String craftsmanMoneylist(Model model, HttpSession session, String likes) {
        return "money/craftsmanMoneyManage.html";
    }

    @RequestMapping("basicinfo/money/checkMonthRecord.action")
    public String checkMonthRecordList(Model model, HttpSession session, String likes){
        return "money/checkMonthRecord.html";
    }

    @RequestMapping("basicinfo/money/checkHistoryRecord.action")
    public String checkHistoryRecordList(Model model, HttpSession session, String likes){
        return "money/checkHistoryRecord.html";
    }
}

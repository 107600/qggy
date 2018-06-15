package cn.itcast.jk.controller.basicinfo.teacher;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.jws.WebParam;
import javax.servlet.http.HttpSession;

@Controller
public class TeacherController {

    //列表，显示已经上传的课件
    @RequestMapping("basicinfo/teacher/fileUploadManage.action")
    public String fileUploadManageList(Model model, HttpSession httpSession, String likes){
        return "teacher/uploadManage.html";
    }

    //列表,显示待审核的正在申请导师或匠人的列表
    @RequestMapping("basicinfo/teacher/tutorAndCraAppliRegis.action")
    public String craftsmanMoneylist(Model model, HttpSession session, String likes) {
        return "teacher/tutorAppliRegis.html";
    }

    //列表，显示已经成为导师的人的列表
    @RequestMapping("basicinfo/teacher/tutorRegis.action")
    public String tutorRegisList(Model model, HttpSession session, String likes) {
        return "teacher/tutorRegisted.html";
    }

    //列表，显示已经成为匠人的人的列表
    @RequestMapping("basicinfo/teacher/craftsmanRegis.action")
    public String craftsmanRegisList(Model model, HttpSession session, String likes) {
        return "teacher/craftsmanRegisted.html";
    }

    //显示待审核的导师及匠人的详细信息
    @RequestMapping("basicinfo/teacher/tutorAppliRegis.action")
    public String tutorInfomationList(Model model, HttpSession session, String likes){
        return "teacher/tutorAppliRegisInformation.html";
    }

    //显示已注册的导师的详细信息
    @RequestMapping("basicinfo/teacher/tutorRegisted.action")
    public String tutorRegistedList(Model model, HttpSession session, String likes){
        return "teacher/tutorInformation.html";
    }

    //显示已注册的匠人的详细信息
    @RequestMapping("basicinfo/teacher/craftsmanRegisted.action")
    public String craftsmanRegistedList(Model model, HttpSession session, String likes){
        return "teacher/craftsmanInformation.html";
    }
}

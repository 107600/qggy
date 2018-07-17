package cn.itcast.jk.controller.basicinfo.promotecourse;

import cn.itcast.jk.domain.PromoteCourse;
import cn.itcast.jk.domain.Student;
import cn.itcast.jk.service.PromoteCourseService;
import cn.itcast.util.DateConverter;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * 电脑端的课程发起的Controller
 */
@Controller
public class PromoteCourseController {
    @Autowired
    private PromoteCourseService promoteCourseService;

    //将待审核的状态更新为未审核通过
    @RequestMapping("/basicinfo/promotecourse/updateCoursePromoteState.action")
    public String updateCoursePromoteState(Model model,
                                           @RequestParam(value = "promoteCourseId")Integer id){
        //更新数据表
        promoteCourseService.updatePromoteState(id);
        return "redirect:/basicinfo/course/coursePromote.action";
    }

    //将待审核的状态更新为审核通过
    @RequestMapping("/basicinfo/promotecourse/updateCoursePromoteStatePass.action")
    public String  updateCoursePromoteStatePass(@RequestParam(value = "promoteCourseId")
                                                            Integer id){
        //更新数据表
        promoteCourseService.updatePromoteStatePass(id);
        return "redirect:/basicinfo/course/coursePromote.action";
    }

    //查询功能
    @RequestMapping("/basicinfo/promotecourse/findByParams.action")
    public String findByParams(PromoteCourse promoteCourse,Model model){

//        System.out.println(courseTimeStr);
//        if (!StringUtils.isEmpty(courseTimeStr)){
//            Date courseTime;
//            if(courseTimeStr.contains(":")) {
//                //把字符串类型的时间转换成Data类型
//                courseTime = DateConverter.StringToDate(courseTimeStr + ":00");
//            }else{
//                courseTime = DateConverter.StringToDate(courseTimeStr);
//            }
//            //把Date类型的时间放入promoteCourse实体中
//
//            promoteCourse.setCourseTime(courseTime);
//            System.out.println(courseTime);
//        }
//        System.out.println(promoteCourse.getCourseAreaName());
//        System.out.println(promoteCourse.getCourseCategory());
//        System.out.println(promoteCourse.getCourseName());
//        System.out.println(promoteCourse.getCourseTime());
        System.out.println(promoteCourse.getCourseTimeStr());
        //根据参数查询发起课程的列表
        List<PromoteCourse> promoteCourseList = promoteCourseService.queryByParams(promoteCourse);
        System.out.println(promoteCourseList);
        //添加到model中
        model.addAttribute("promoteCourseList",promoteCourseList);

        return "basicinfo/course/promoteCourse.jsp";
    }

    //查看对某一课程感兴趣的老师的详细信息"
    @RequestMapping("/basicinfo/promotecourse/tutorinformation.action")
    public String tutorinformation(Model model,@RequestParam String userOpenid){
        System.out.println("测试一下注册界面能否发起跳转");
        Student s = promoteCourseService.queryOneStudent(userOpenid);
        System.out.println(s);
        model.addAttribute("student",s);
        return "teacher/tutorInformation.jsp";
    }

}

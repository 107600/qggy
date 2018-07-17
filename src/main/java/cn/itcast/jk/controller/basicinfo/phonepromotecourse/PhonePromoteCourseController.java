package cn.itcast.jk.controller.basicinfo.phonepromotecourse;

import cn.itcast.jk.domain.PromoteCourse;
import cn.itcast.jk.domain.Student;
import cn.itcast.jk.service.PromoteCourseService;

import cn.itcast.util.DateConverter;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 手机端发起课程的Controller
 */

@Controller
public class PhonePromoteCourseController {
    @Autowired
    private PromoteCourseService promoteCourseService;

    //增加一个课程发起
    @RequestMapping("/phone/user/basicinfo/phonepromotecourse/add.action")
    public String registerCourse(PromoteCourse promoteCourse,HttpSession session,
                               @RequestParam(value = "courseTime1")String courseTimeStr){
        //校验时间
        if (courseTimeStr != null){
            //把字符串类型的时间转换成Data类型
            Date courseTime = DateConverter.StringToDate(courseTimeStr+":00");
            //把Date类型的时间放入promoteCourse实体中
            promoteCourse.setCourseTime(courseTime);
        }

        //获取登录者的信息
        Student user = (Student) session.getAttribute("user");
        //校验是否登录
        if (user != null){
            //拿到session中用户的openid，并设置到promoteCourse中
            promoteCourse.setCourseUserOpenid(user.getUserOpenid());
            //拿到session中用户的user_name，并设置到promoteCourse中
            promoteCourse.setCoursePromotePerson(user.getUserName());
        }

        //后端校验
        //调用增加发起课程的service
        promoteCourseService.addCoursePromote(promoteCourse);

        return "/basicinfo/phoneuser/successCoursePromote.html";
    }

    // 待审核的课程发起列表
    @RequestMapping("/phone/user/basicinfo/phonepromotecourse/list.action")
    public
    @ResponseBody
    String listpromotecourse(HttpSession session) {
        //找出待审核状态的发起课程的列表
        List<PromoteCourse> dataList = promoteCourseService.queryUnChecked();
        //遍历dataList，将Date的时间类型转为String类型
        for (PromoteCourse promoteCourse : dataList) {
            //HH表示24小时制，而hh表示12小时制
            String dateStr = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
                    .format(promoteCourse.getCourseTime());
            //promoteCourse类中保留了一个String类型的时间，将时间set进去
            promoteCourse.setCourseTimeStr(dateStr);
        }
        //转为json对象
        JSONArray jsonObject = JSONArray.fromObject(dataList);

        System.out.println(jsonObject);

        return jsonObject.toString();
    }

    //显示某一个待发起的课程的详细信息
    @RequestMapping("/phone/user/promotecoursedetail.action")
    public String promoteCourseDetail(@RequestParam Integer id, Model model){
        PromoteCourse promoteCourse = promoteCourseService.query(id);
        model.addAttribute("promoteCourse",promoteCourse);
        System.out.println(promoteCourse);
        return "/basicinfo/phoneuser/coursePromoteUser.jsp";
    }

    //学生、老师对发起的课程感兴趣，记录感兴趣的人数以及将人(谁对该课程感兴趣)和发起的课程存入数据库
    @RequestMapping("/phone/user/interestCourse.action")
    public String interestCourse(HttpServletRequest request, @RequestParam(value = "promoteCourseId") Integer id) {
        //根据id获得这门课程
        PromoteCourse promoteCourse = promoteCourseService.query(id);
        //从session中获取是哪一个用户
        Student s = (Student) request.getSession().getAttribute("user");
        //map用来传递参数
        Map<String,String> map = new HashMap<String,String>();
        map.put("userOpenid",s.getUserOpenid());
        //将int类型的courseId转为String类型
        map.put("courseId", String.valueOf(promoteCourse.getPromoteCourseId()));

        System.out.println(map);

        //判断数据表中是否有该用户的openid，如果有，则不能重复添加我想参加
        String openid = promoteCourseService.queryInterestCourse(map);
        System.out.println(openid);
        if (openid == null){
            if(s.getState() == 3){
                //获得原数据表中感兴趣的老师的人数
                int teaNum = promoteCourse.getCourseNumTea();
                //将对某一门感兴趣的课程的老师人数加1
                teaNum += 1;
                //将增加后的人数set到类中
                promoteCourse.setCourseNumTea(teaNum);
                //更新数据库的操作
                promoteCourseService.updateTeaNum(promoteCourse);
            }else if (s.getState() == 1){
                //获得原数据表中感兴趣的学生的人数
                int stuNum = promoteCourse.getCourseNumStu();
                //将对某一门感兴趣的课程的老师人数加1
                stuNum += 1;
                //将增加后的人数set到类中
                promoteCourse.setCourseNumStu(stuNum);
                //更新数据库的操作
                promoteCourseService.updateStuNum(promoteCourse);
            }

//            Map<String, String> map = new HashMap<String, String>();
            map.put("userId",s.getId());
            map.put("userName",s.getUserName());
//            map.put("userOpenid",s.getUserOpenid());
            //将int类型的courseId转为String类型
//            map.put("courseId", String.valueOf(promoteCourse.getPromoteCourseId()));
            map.put("courseCategory",promoteCourse.getCourseCategory());
            map.put("courseName",promoteCourse.getCourseName());

            System.out.println(map.toString());

            promoteCourseService.addInterestCourse(map);

            return "/basicinfo/phoneuser/successinterestcoursepromote.html";
        }else {
            return "/basicinfo/phoneuser/failinterestcoursepromote.html";
        }
    }

    @RequestMapping("/phone/user/basicinfo/student/userRegister.action")
    public String userRegister(){
        System.out.println("hhahahhuserRegister的页面");
        return "test.html";
    }
}

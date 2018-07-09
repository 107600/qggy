package cn.itcast.jk.controller.basicinfo.phoneactivity;
import java.util.List;
import cn.itcast.jk.domain.Activity;
import cn.itcast.jk.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.ModelMap;


@Controller
public class PhoneActivityController{
    @Autowired
    private ActivityService activityService;

    @RequestMapping(value = "/phone/public/basicinfo/activity/view.action")
    public String listActivity(ModelMap model) {
        System.out.println("hh");
        List<Activity> activitys = activityService.getActivityList(null);
        System.out.println(activitys);
        model.addAttribute("activitys", activitys);
        return "/basicinfo/activity/PhActivityView.jsp";
    }




}

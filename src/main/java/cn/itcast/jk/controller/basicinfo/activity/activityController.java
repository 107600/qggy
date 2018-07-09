package cn.itcast.jk.controller.basicinfo.activity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.itcast.jk.domain.Activity;
import cn.itcast.jk.domain.UrRo;
import cn.itcast.jk.service.ActivityService;
import cn.itcast.jk.vo.SysUserVO;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.ModelMap;

import javax.servlet.http.HttpSession;


@Controller
public class activityController {
    @Autowired
    private ActivityService activityService;

    @RequestMapping(value = "/basicinfo/activity/list.action")
    public String listActivity(ModelMap model) {
        System.out.println("hh");
        List<Activity> activitys = activityService.getActivityList(null);
        System.out.println(activitys);
        model.addAttribute("activitys", activitys);

        return "/basicinfo/activity/jallactivityList.jsp";
    }

    @RequestMapping(value = "/basicinfo/activity/show.action")
    public String list(Model model, String likes) {
        Map<String, Integer> parmap = new HashMap<>();
        if (!StringUtils.isBlank(likes)) {
            parmap.put("num", Integer.valueOf(likes));
        }
        List<Activity> dataList = activityService.find(parmap);
        if(null!=dataList){
            System.out.println(dataList.get(0).getNum());
        }

        model.addAttribute("dataList", dataList); // 将数据传递到页面

        return "/basicinfo/activity/jallactivityshow.jsp";
    }


        @RequestMapping(value = "/basicinfo/activity/view.action")
        public String viewActivity (ModelMap model){

            List<Activity> activitys = activityService.getActivityList(null);
            model.addAttribute("activitys", activitys);

            return "/basicinfo/activity/detailactivityview.jsp";
        }


    }


package cn.itcast.jk.controller.basicinfo.activity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.itcast.jk.domain.Activity;
import cn.itcast.jk.service.ActivityService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@Controller
public class activityController {
    @Autowired
    private ActivityService activityService;
    private HttpServletRequest request;
    private HttpServletResponse response;


    // 调入所有数据
    @RequestMapping(value = "/basicinfo/activity/list.action")
    public String listActivity(ModelMap model) {
        System.out.println("hh");
        List<Activity> activitys = activityService.getActivityList(null);
        System.out.println(activitys);
        model.addAttribute("activitys", activitys);
        return "/basicinfo/activity/jallactivityList.jsp";
    }


    // 主页面模糊查询
    @RequestMapping(value = "/basicinfo/activity/show.action")
    public String list(Model model, String likes) {
        Map<String, Integer> parmap = new HashMap<>();
        if (!StringUtils.isBlank(likes)) {
            parmap.put("num", Integer.valueOf(likes));
        }
        List<Activity> dataList = activityService.find(parmap);
        if (null != dataList) {
            System.out.println(dataList.get(0).getNum());
        }
        model.addAttribute("dataList", dataList); // 将数据传递到页面
        return "/basicinfo/activity/jallactivityshow.jsp";
    }



    // 发布面模糊查询
    @RequestMapping(value = "/basicinfo/activity/fabuview.action")
    public String fabushow(Model model, String likes) {
        Map<String, Integer> parmap = new HashMap<>();
        if (!StringUtils.isBlank(likes)) {
            parmap.put("num", Integer.valueOf(likes));
        }
        List<Activity> dataList = activityService.find(parmap);
        if (null != dataList) {
            System.out.println(dataList.get(0).getNum());
        }
        model.addAttribute("dataList", dataList); // 将数据传递到页面
        return "/basicinfo/activity/jallactivityfabuview.jsp";
    }



    // 已发布,审核通过面模糊查询
    @RequestMapping(value = "/basicinfo/activity/confirmfabushow.action")
    public String confirmfabushow(Model model, String likes) {
        Map<String, Integer> parmap = new HashMap<>();
        if (!StringUtils.isBlank(likes)) {
            parmap.put("num", Integer.valueOf(likes));
        }
        List<Activity> dataList = activityService.find(parmap);
        if (null != dataList) {
            System.out.println(dataList.get(0).getNum());
        }
        model.addAttribute("dataList", dataList); // 将数据传递到页面
        return "/basicinfo/activity/jallactivityconfirmfabushow.jsp";
    }







    // 根据id查看详细信息
    @RequestMapping(value = "/basicinfo/activity/view.action")
    public String viewActivity(Integer num, ModelMap model) {
        List<Activity> activitys = activityService.get(num);
        model.addAttribute("activitys", activitys);// 将数据传递到页面
        return "/basicinfo/activity/detailactivityview.jsp";
    }


    // 根据id改变状态码（审核未通过）
    @RequestMapping(value = "/basicinfo/activity/shenhefActivity.action")
    public String shenheActivity(Activity activity, Integer num, ModelMap model) {
        activity.setState("审核未通过");  //审核未通过
        activityService.updateActivityByKey(activity);
        List<Activity> activitys = activityService.get(num);
        model.addAttribute("activitys", activitys);
        List<Activity> activityc = activityService.getActivityList(null);
        model.addAttribute("activitys", activityc);
        return "/basicinfo/activity/jallactivityList.jsp";
    }


    // 根据id改变状态码（审核通过）
    @RequestMapping(value = "/basicinfo/activity/shenheActivity.action")
    public String fabuActivity(Activity activity, Integer num, ModelMap model) {
        activity.setState("审核通过");  //审核通过
        activityService.updateActivityByKey(activity);
        List<Activity> activitys = activityService.get(num);
        model.addAttribute("activitys", activitys);
        List<Activity> activityc = activityService.getActivityList(null);
        model.addAttribute("activitys", activityc);
        return "/basicinfo/activity/jallactivityList.jsp";
    }

    // 根据id改变状态码（模糊搜索审核未通过）
    @RequestMapping(value = "/basicinfo/activity/findshenhefActivity.action")
    public String findshenheActivity(Activity activity, Integer num, ModelMap model) {
        activity.setState("审核未通过");  //审核未通过
        activityService.updateActivityByKey(activity);
        List<Activity> dataList  = activityService.get(num);
        model.addAttribute("dataList", dataList);
        return "/basicinfo/activity/jallactivityshow.jsp";
    }


    // 根据id改变状态码（模糊搜索审核通过）
    @RequestMapping(value = "/basicinfo/activity/findshenheActivity.action")
    public String findfabuActivity(Activity activity, Integer num, ModelMap model) {
        activity.setState("审核通过");  //审核通过
        activityService.updateActivityByKey(activity);
        List<Activity> dataList  = activityService.get(num);
        model.addAttribute("dataList", dataList);
        return "/basicinfo/activity/jallactivityshow.jsp";
    }

    // 调入数据去发布页面
    @RequestMapping(value = "/basicinfo/activity/fabuActivity.action")
    public String listfabuActivity(ModelMap model) {
        List<Activity> activitys = activityService.select(null);
        model.addAttribute("activitys", activitys);
        return "/basicinfo/activity/jallactivityfabu.jsp";
    }

    // 根据id改变状态码（确认发布）
    @RequestMapping(value = "/basicinfo/activity/fabuconfirmActivity.action")
    public String fabuconfirmActivity(Activity activity, Integer num, ModelMap model) {
        activity.setState("已发布");  //确认发布
        activityService.updateActivityByKey(activity);
        List<Activity> activitys = activityService.get(num);
        model.addAttribute("activitys", activitys);
        List<Activity> activityc = activityService.select(null);
        model.addAttribute("activitys", activityc);
        return "/basicinfo/activity/jallactivityfabu.jsp";
    }


    // 根据id改变状态码（确认失败）
    @RequestMapping(value = "/basicinfo/activity/fabufailedActivity.action")
    public String fabufailedActivity(Activity activity, Integer num, ModelMap model) {
        activity.setState("发布失败");  //发布失败
        activityService.updateActivityByKey(activity);
        List<Activity> activitys = activityService.get(num);
        model.addAttribute("activitys", activitys);
        List<Activity> activityc = activityService.select(null);
        model.addAttribute("activitys", activityc);
        return "/basicinfo/activity/jallactivityfabu.jsp";
    }




    // 显示审核通过getpass
    @RequestMapping(value = "/basicinfo/activity/shenhepassActivity.action")
    public String shenhepassActivity(ModelMap model) {
        List<Activity> activityc = activityService.getpass(null);
        model.addAttribute("activitys", activityc);
        return "/basicinfo/activity/jallactivityshenhepass.jsp";

    }
    // 显示确认发布getconfirm
    @RequestMapping(value = "/basicinfo/activity/confirmfabuActivity.action")
    public String confirmfabuActivity(ModelMap model) {
        List<Activity> activityc = activityService.getconfirm(null);
        model.addAttribute("activitys", activityc);
        return "/basicinfo/activity/jallactivityconfirmfabu.jsp";

    }

    // 删除发布
    @RequestMapping("/basicinfo/activity/deletefabuactivity.action")
    public String deletefabuactivity(Integer num, ModelMap model) {

        activityService.deleteByKey(num);
        System.out.println("dd");
        List<Activity> activityc = activityService.getconfirm(null);
        model.addAttribute("activitys", activityc);
        return "/basicinfo/activity/jallactivityconfirmfabu.jsp";

    }

    // 主页面提交审核意见
    @RequestMapping("/basicinfo/activity/submitactivity.action")
    public String submitactivity(Model model, Integer num, Activity activity, String suggestion) {
        Map<String, String> parmap = new HashMap<>();
        if (!StringUtils.isBlank(suggestion)) {
            parmap.put("num", suggestion);
        }
        activity.setSuggestion(suggestion);
        activityService.updateActivityByKey(activity);
        List<Activity> activitys = activityService.get(num);
        model.addAttribute("activitys", activitys);
        List<Activity> activityc = activityService.getActivityList(null);
        model.addAttribute("activitys", activityc);
        return "/basicinfo/activity/jallactivityList.jsp";
    }


    // 发布页面交审核意见
    @RequestMapping("/basicinfo/activity/fabusubmitactivity.action")
    public String fabusubmitactivity(Model model, Integer num, Activity activity, String suggestion) {
        Map<String, String> parmap = new HashMap<>();
        if (!StringUtils.isBlank(suggestion)) {
            parmap.put("num", suggestion);
        }
        activity.setSuggestion(suggestion);
        activityService.updateActivityByKey(activity);
        List<Activity> activitys = activityService.get(num);
        model.addAttribute("activitys", activitys);
        List<Activity> activityc = activityService.select(null);
        model.addAttribute("activitys", activityc);
        return "/basicinfo/activity/jallactivityfabu.jsp";
    }


    //  模糊查询提交意见
    @RequestMapping("/basicinfo/activity/mohusubmitactivity.action")
    public String mohusubmitactivity(ModelMap model, Integer num, Activity activity, String suggestion) {
        Map<String, String> parmap = new HashMap<>();
        if (!StringUtils.isBlank(suggestion)) {
            parmap.put("num", suggestion);
        }
        activity.setSuggestion(suggestion);
        activityService.updateActivityByKey(activity);
        List<Activity> dataList  = activityService.get(num);
        model.addAttribute("dataList", dataList);
        return "/basicinfo/activity/jallactivityshow.jsp";
    }
}
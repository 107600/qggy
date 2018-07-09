package cn.itcast.jk.controller.basicinfo.deposit;

import cn.itcast.jk.controller.BaseController;
import cn.itcast.jk.domain.ActivityDeposit;
import cn.itcast.jk.domain.UrRo;
import cn.itcast.jk.service.ActivityDepositService;
import cn.itcast.jk.vo.SysUserVO;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class DepositController extends BaseController {
//    @RequestMapping("/basicinfo/deposit/coursedeposit.action")
//    public String coursedeposit() {
//        return "basicinfo/deposit/jCourseDeposit.jsp";
//    }
//
//    @RequestMapping("/basicinfo/deposit/deposit.action")
//    public String coursedeposit() {
//        return "basicinfo/deposit/j.jsp";
//    }


    @Resource
    ActivityDepositService activityDepositService;

    @RequestMapping("/basicinfo/deposit/list.action")
    public String list(Model model, HttpSession session, String likes) {
        SysUserVO sysUserVO = (SysUserVO) session.getAttribute("sysUserVO");
        for (UrRo r : sysUserVO.getRoles()) {
            if (r.getSroleId().equals("29"))// 分部角色管理
            {
                Map<String, String> map = new HashMap<>();
                map.put("areaId", sysUserVO.getAreaId() + "");
                if (!StringUtils.isBlank(likes)) {
                    map.put("likes", likes);
                }
                List<ActivityDeposit> dataList = activityDepositService.find(map);
                model.addAttribute("dataList", dataList); // 将数据传递到页面

                return "basicinfo/deposit/jActivityDepositListz.jsp"; // 转向页面
            } else if (r.getSroleId().equals("30"))// 总部角色管理
            {
                Map<String, String> map = new HashMap<>();
                if (!StringUtils.isBlank(likes)) {
                    map.put("likes", likes);
                }

                List<ActivityDeposit> dataList = activityDepositService.find(map);
                model.addAttribute("dataList", dataList); // 将数据传递到页面

                return "basicinfo/deposit/jActivityDepositListf.jsp"; // 转向页面
            }
        }


        return "/baseinfo/error.jsp";

    }
    // 查看
    @RequestMapping("/basicinfo/deposit/toview.action")
    public String toview(String id, Model model) {
        ActivityDeposit obj = activityDepositService.get(id);
        model.addAttribute("obj", obj); // 将数据传递到页面
        return "/basicinfo/deposit/jActivityDepositView.jsp";
    }


    // 批量启用
    @RequestMapping("/basicinfo/deposit/start.action")
    public String start(@RequestParam("id") String[] ids) {
        activityDepositService.start(ids);

        return "redirect:/basicinfo/deposit/list.action";
    }

    // 批量停用
    @RequestMapping("/basicinfo/deposit/stop.action")
    public String stop(@RequestParam("id") String[] ids) {
        activityDepositService.stop(ids);

        return "redirect:/basicinfo/deposit/list.action";
    }





}

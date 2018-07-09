//package cn.itcast.jk.controller.basicinfo.points;
//
//import cn.itcast.jk.controller.BaseController;
//import cn.itcast.jk.domain.CreditPoints;
//import cn.itcast.jk.domain.UrRo;
//import cn.itcast.jk.service.CreditPointsService;
//import cn.itcast.jk.vo.SysUserVO;
//import org.apache.commons.lang.StringUtils;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import javax.annotation.Resource;
//import javax.servlet.http.HttpSession;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//@Controller
//public class PointsController extends BaseController {
//
//
//   @Resource
//    CreditPointsService creditPointsService;
//    //信用积分页面的跳转
//   /* @RequestMapping("/basicinfo/points/creditPoints.action")
//    public  String jCreditPointsList() {
//        return "basicinfo/points/jCreditPointsList.jsp";
//    }
//    //公益积分页面的跳转
//    @RequestMapping("/basicinfo/points/pointsAddSet.action")
//    public  String pointsAddSet() {
//        return "/basicinfo/points/pointsAddSet.jsp";
//    }
////    @RequestMapping("/basicinfo/points/pointsSubSet.action")
////    public  String ps() {
////        return "/basicinfo/points/pointsSubSet.jsp";
////    }
//    //增加积分设定页面的跳转
//    @RequestMapping("/basicinfo/points/publicInterestPoints.action")
//    public  String publicInterestPoints() {
//        return "/basicinfo/points/publicInterestPoints.jsp";
//    }
//*/
//
//    // 列表
//    @RequestMapping("/basicinfo/points/list.action")
//    public String list(Model model, HttpSession session, String likes) {
//        SysUserVO sysUserVO = (SysUserVO) session.getAttribute("sysUserVO");
//        for (UrRo r : sysUserVO.getRoles()) {
//            if (r.getSroleId().equals("27"))// 分部积分管理
//            {
//                Map<String, String> map = new HashMap<>();
//                map.put("areaId", sysUserVO.getAreaId() + "");
//                if (!StringUtils.isBlank(likes)) {
//                    map.put("likes", likes);
//                }
//                List<CreditPoints> dataList = creditPointsService.find(map);
//                model.addAttribute("dataList", dataList); // 将数据传递到页面
//
//                return "/basicinfo/points/jCreditListf.jsp"; // 转向页面
//            } else if (r.getSroleId().equals("28"))// 总部积分管理
//            {
//                Map<String, String> map = new HashMap<>();
//                if (!StringUtils.isBlank(likes)) {
//                    map.put("likes", likes);
//                }
//
//                List<CreditPoints> dataList = creditPointsService.find(map);
//                model.addAttribute("dataList", dataList); // 将数据传递到页面
//
//                return "/basicinfo/points/jCreditListz.jsp"; // 转向页面
//            }
//        }
//
//        // 将数据传递到页面
//
//        return "/baseinfo/error.jsp";
//
//    }
//
//
//    // 转向新增页面
//    @RequestMapping("/basicinfo/points/tocreate.action")
//    public String tocreate() {
//        return "/basicinfo/points/jCreditCreate.jsp";
//    }
//
//    // 新增保存
//    @RequestMapping("/basicinfo/points/insert.action")
//    public String insert(CreditPoints creditPoints) {
//        if (creditPoints.getCreditUserName() != null && !creditPoints.getCreditUserName().equals("")) {
//            creditPointsService.insert(creditPoints);
//        }
//        return "redirect:/basicinfo/points/list.action"; // 转向列表的action
//    }
//
//    // 转向修改页面
//    @RequestMapping("/basicinfo/points/toupdate.action")
//    public String toupdate(String id, Model model) {
//        CreditPoints obj = creditPointsService.get(id);
//        model.addAttribute("obj", obj);
//
//        return "/basicinfo/points/jCreditUpdate.jsp";
//    }
//
//    // 修改保存
//    @RequestMapping("/basicinfo/points/update.action")
//    public String update(CreditPoints creditPoints) {
//        creditPointsService.update(creditPoints);
//
//        return "redirect:/basicinfo/points/list.action";
//    }
//
//    // 查看
//    @RequestMapping("/basicinfo/points/toview.action")
//    public String toview(String id, Model model) {
//        CreditPoints obj = creditPointsService.get(id);
//        model.addAttribute("obj", obj);
//
//        return "/basicinfo/points/jCreditView.jsp";
//    }
//
//    // 批量启用
//    @RequestMapping("/basicinfo/points/start.action")
//    public String start(@RequestParam("id") String[] ids) {
//        creditPointsService.start(ids);
//
//        return "redirect:/basicinfo/points/list.action";
//    }
//
//    // 批量停用
//    @RequestMapping("/basicinfo/points/stop.action")
//    public String stop(@RequestParam("id") String[] ids) {
//        creditPointsService.stop(ids);
//
//        return "redirect:/basicinfo/points/list.action";
//    }
//
//}

package cn.itcast.jk.controller.basicinfo.activityreleased;

import cn.itcast.jk.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ActivityReleasedController extends BaseController {
    @RequestMapping("/basicinfo/activityreleased/list.action")
    public  String list() {
        return "/basicinfo/activityreleased/activityreleased.jsp";
    }
}

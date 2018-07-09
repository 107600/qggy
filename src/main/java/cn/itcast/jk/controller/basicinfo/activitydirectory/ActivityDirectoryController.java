package cn.itcast.jk.controller.basicinfo.activitydirectory;

import cn.itcast.jk.controller.BaseController;
import cn.itcast.jk.dao.ActivityDirectoryDao;
import cn.itcast.jk.domain.ActivityDirectory;
import cn.itcast.jk.service.ActivityDirectoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class ActivityDirectoryController extends BaseController {
    @Resource
    ActivityDirectoryService activityDirectoryService;

   @RequestMapping("/basicinfo/activitydirectory/activitydirectory.action")
   @ResponseBody
   public  List<ActivityDirectory> select(@RequestParam Integer id) {
        List<ActivityDirectory> activityDirectories = activityDirectoryService.selectFromActivityDirectory(id);
        return activityDirectories;
    }
}

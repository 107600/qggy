/**
 *
 * @author 展佳俊
 * @date 2018/7/7 10:59
 */

package cn.itcast.jk.controller.basicinfo.activityreleased;

import cn.itcast.jk.controller.BaseController;
import cn.itcast.jk.domain.ActivityReleased;
import cn.itcast.jk.service.ActivityReleasedService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

import java.util.Date;

@Controller
public class ActivityReleasedController extends BaseController {
    //点击青果活动发布跳转发布页面
    @RequestMapping("/basicinfo/activityreleased/list.action")
    public  String list() {
        return "/basicinfo/activityreleased/activityreleased.jsp";
    }

    //发布活动
    //注入service
    @Resource
    ActivityReleasedService activityReleasedService;

    @RequestMapping("/basicinfo/activityreleased/insertActivity.action")
    @ResponseBody
    public void insertActivity(ActivityReleased activityReleased,
                               @RequestParam(value = "activityName")String activityName,
                               @RequestParam(value = "firstCategory")String firstCategory,
                               @RequestParam(value = "secondCategory")String secondCategory,
                               @RequestParam(value = "address")String address,

                               @RequestParam(value = "activityDate")Date activityDate,
                               @RequestParam(value = "affiliatedCompany")String affiliatedCompany,

                               @RequestParam(value = "isNeedTeacher", required = false)Integer isNeedTeacher,
                               @RequestParam(value = "teacherNumbers")Integer teacherNumbers,
                               @RequestParam(value = "teacherDomain")String teacherDomain,
                               @RequestParam(value = "teacherDeposit")Integer teacherDeposit,
                               @RequestParam(value = "teacherReward")Integer teacherReward,

                               @RequestParam(value = "isNeedCraftsman", required = false)Integer isNeedCraftsman,
                               @RequestParam(value = "craftsmanNumbers")Integer craftsmanNumbers,
                               @RequestParam(value = "craftsmanDomain")String craftsmanDomain,
                               @RequestParam(value = "craftsmanDeposit")Integer craftsmanDeposit,
                               @RequestParam(value = "craftsmanReward")Integer craftsmanReward,

                               @RequestParam(value = "isNeedVolunteer", required = false)Integer isNeedVolunteer,
                               @RequestParam(value = "volunteerNumbers")Integer volunteerNumbers,
                               @RequestParam(value = "volunteerDeposit")Integer volunteerDeposit,
                               @RequestParam(value = "volunteerReward")Integer volunteerReward,

                               @RequestParam(value = "isNeedAudience", required = false)Integer isNeedAudience,
                               @RequestParam(value = "audienceNumbers")Integer audienceNumbers,

                               @RequestParam(value = "isNeedPlace",required = false)Integer isNeedPlace,
                               @RequestParam(value = "placeProvider")String placeProvider,
                               @RequestParam(value = "traffic")String traffic,
                               @RequestParam(value = "image")String image,
                               @RequestParam(value = "activityDescribe")String activityDescribe

                               ) {

        activityReleased.setActivityName(activityName);
        activityReleased.setFirstCategory(firstCategory);
        activityReleased.setSecondCategory(secondCategory);
        activityReleased.setAddress(address);

        activityReleased.setActivityDate(activityDate);
        activityReleased.setAffiliatedCompany(affiliatedCompany);

        activityReleased.setIsNeedTeacher(isNeedTeacher);
        activityReleased.setTeacherNumbers(teacherNumbers);
        activityReleased.setTeacherDomain(teacherDomain);
        activityReleased.setTeacherDeposit(teacherDeposit);
        activityReleased.setTeacherReward(teacherReward);

        activityReleased.setIsNeedCraftsman(isNeedCraftsman);
        activityReleased.setCraftsmanDomain(craftsmanDomain);
        activityReleased.setCraftsmanNumbers(craftsmanNumbers);
        activityReleased.setCraftsmanDeposit(craftsmanDeposit);
        activityReleased.setCraftsmanReward(craftsmanReward);

        activityReleased.setIsNeedVolunteer(isNeedVolunteer);
        activityReleased.setVolunteerNumbers(volunteerNumbers);
        activityReleased.setVolunteerDeposit(volunteerDeposit);
        activityReleased.setVolunteerReward(volunteerReward);

        activityReleased.setIsNeedAudience(isNeedAudience);
        activityReleased.setAudienceNumbers(audienceNumbers);

        activityReleased.setIsNeedPlace(isNeedPlace);
        activityReleased.setPlaceProvider(placeProvider);

        activityReleased.setTraffic(traffic);
        activityReleased.setImage(image);
        activityReleased.setActivityDescribe(activityDescribe);

        activityReleasedService.insertIntoActivityReleased(activityReleased);

    }

    @RequestMapping(value = "/basicinfo/activityreleased/releasedsuccess.action")
    public String showSuccess () {
        return "/basicinfo/activityreleased/releasedsuccess.jsp";
    }

}

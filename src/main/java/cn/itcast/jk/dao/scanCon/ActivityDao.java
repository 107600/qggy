package cn.itcast.jk.dao.scanCon;
import cn.itcast.jk.controller.query.ActivityQuery;
import cn.itcast.jk.domain.Activity;

import java.util.List;

public interface ActivityDao {
    public Integer addActivity(Activity activity);

    public Activity getActivityByKey(Integer num);

    public List<Activity> getActivitysByKeys(List<Integer> idList);

    public Integer deleteByKey(Integer num);


    public Integer deleteByKeys(List<Integer> idList);

    public Integer updateActivityByKey(Activity activity);

    public List<Activity> getActivityListWithPage(ActivityQuery ActivityQuery);


    public List<Activity> getActivityList(ActivityQuery ActivityQuery);

    public int getActivityListCount(ActivityQuery ActivityQuery);
}
package cn.itcast.jk.dao.scanCon;
import  cn.itcast.jk.controller.query.ActivityQuery;
import cn.itcast.jk.domain.Activity;
import org.apache.ibatis.annotations.Param;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface ActivityDao {
    public String addActivity(Activity activity);

    public Activity getActivityByKey(Integer num);

    public List<Activity> find(Map<?, ?> map); // 查询某个活动

    public List<Activity> getActivitysByKeys(List<Integer> idList);

    public Integer deleteByKey(Integer num);

    public String update(Activity activity);//根据id进行state数据更新

    public List<Activity> get(Integer id);

    public Integer deleteByKeys(List<Integer> idList);

    public Integer updateActivityByKey(Activity activity);

    public List<Activity> getActivityListWithPage(ActivityQuery ActivityQuery);

    public List<Activity> getActivityList(ActivityQuery ActivityQuery);

    public List<Activity> select (ActivityQuery activityQuery);

    public List<Activity> getconfirm (ActivityQuery activityQuery);
    public List<Activity> getpass(ActivityQuery activityQuery);

    public int getActivityListCount(ActivityQuery ActivityQuery);

//    public List update(@Param("state")List<String> state);
}
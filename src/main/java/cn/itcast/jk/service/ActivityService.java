package cn.itcast.jk.service;


import java.util.List;
import java.util.Map;

import cn.itcast.jk.controller.query.ActivityQuery;
import cn.itcast.jk.domain.Activity;
import org.apache.ibatis.annotations.Param;


public interface ActivityService {
	public String addActivity(Activity activity);
	public Activity getActivityByKey(Integer num);
	public List<Activity> get(Integer num); // 只查询一个，常用于修改
	public List<Activity> find(Map<?, ?> paraMap);
    public List<Activity> getActivitysByKeys(List<Integer> idList);
	public Integer deleteByKey(Integer num);
	public Integer deleteByKeys(List<Integer> idList);
	public Integer updateActivityByKey(Activity activity);//根据id进行state数据更新
    public String update(Activity activity);//根据id进行state数据更新
	public List<Activity> select (ActivityQuery activityQuery);
	public List<Activity> getconfirm (ActivityQuery activityQuery);
	public List<Activity> getpass (ActivityQuery activityQuery);
	public List<Activity> getActivityList(ActivityQuery activityQuery);
//	public List update(@Param("state")List<String> state);
	
}

package cn.itcast.jk.service;

import java.util.List;
import java.util.Map;

import cn.itcast.jk.controller.query.ActivityQuery;
import cn.itcast.jk.domain.Activity;
import cn.itcast.jk.domain.Course;


public interface ActivityService {
	public Integer addActivity(Activity activity);
	public Activity getActivityByKey(Integer num);
	public List<Activity> find(Map<?, ?> paraMap);
    public List<Activity> getActivitysByKeys(List<Integer> idList);
	public Integer deleteByKey(Integer num);
	public Integer deleteByKeys(List<Integer> idList);
	public Integer updateActivityByKey(Activity activity);
	public List<Activity> getActivityList(ActivityQuery activityQuery);
	
}

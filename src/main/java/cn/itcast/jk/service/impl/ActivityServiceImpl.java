package cn.itcast.jk.service.impl;

import java.util.List;

import cn.itcast.jk.controller.query.ActivityQuery;
import cn.itcast.jk.domain.Activity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import cn.itcast.jk.service.ActivityService;
import cn.itcast.jk.dao.scanCon.ActivityDao;
import javax.annotation.Resource;

@Service
@Transactional
public class ActivityServiceImpl implements ActivityService{
	@Resource
    ActivityDao activityDao;
	public Integer addActivity(Activity activity) {
		// TODO Auto-generated method stub
		return activityDao.addActivity(activity);
	}
	@Transactional(readOnly = true)
	public Activity getActivityByKey(Integer num) {
		// TODO Auto-generated method stub
		return activityDao.getActivityByKey(num);
	}

	public List<Activity> getActivitysByKeys(List<Integer> idList) {
		// TODO Auto-generated method stub
		return activityDao.getActivitysByKeys(idList);
	}

	public Integer deleteByKey(Integer num) {
		// TODO Auto-generated method stub
		return activityDao.deleteByKey(num);
	}

	public Integer deleteByKeys(List<Integer> idList) {
		// TODO Auto-generated method stub
		return activityDao.deleteByKeys(idList);
	}

	public Integer updateActivityByKey(Activity activity) {
		// TODO Auto-generated method stub
		return activityDao.updateActivityByKey(activity);
	}

	@Transactional(readOnly = true)
	public List<Activity> getActivityList(ActivityQuery activityQuery) {
		// TODO Auto-generated method stub
		return activityDao.getActivityList(activityQuery);
	}

}

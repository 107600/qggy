package cn.itcast.jk.service.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import cn.itcast.jk.controller.query.ActivityQuery;
import cn.itcast.jk.domain.Activity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import cn.itcast.jk.service.ActivityService;
import cn.itcast.jk.dao.scanCon.ActivityDao;
import javax.annotation.Resource;

@Service
@Transactional
public class ActivityServiceImpl implements ActivityService {
	@Resource
	ActivityDao activityDao;

	public String  addActivity(Activity activity) {
		// TODO Auto-generated method stub
		return activityDao.addActivity(activity);
	}

	@Transactional(readOnly = true)
	public Activity getActivityByKey(Integer num) {
		// TODO Auto-generated method stub
		return activityDao.getActivityByKey(num);
	}

	@Override
	public List<Activity> find(Map<?, ?> paraMap) {
		return activityDao.find(paraMap);
	}

	public List<Activity> getActivitysByKeys(List<Integer> idList) {
		// TODO Auto-generated method stub
		return activityDao.getActivitysByKeys(idList);
	}

	public List<Activity> get(Integer num) {
		return activityDao.get(num);
	}


	public Integer deleteByKey(Integer num) {
		// TODO Auto-generated method stub
		return activityDao.deleteByKey(num);
	}

	public String update(Activity activity) {
		return activityDao.update(activity);
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

	@Transactional(readOnly = true)
	public List<Activity> select(ActivityQuery activityQuery) {
		// TODO Auto-generated method stub
		return activityDao.select(activityQuery);
	}

	@Transactional(readOnly = true)
	public List<Activity> getconfirm(ActivityQuery activityQuery) {
		// TODO Auto-generated method stub
		return activityDao.getconfirm(activityQuery);
	}

	@Transactional(readOnly = true)
	public List<Activity> getpass(ActivityQuery activityQuery) {
		// TODO Auto-generated method stub
		return activityDao.getpass(activityQuery);
	}

}

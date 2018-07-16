package cn.itcast.jk.service.impl;

import cn.itcast.jk.dao.ActivityReleasedDao;
import cn.itcast.jk.domain.ActivityReleased;
import cn.itcast.jk.service.ActivityReleasedService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ActivityReleasedServiceImpl implements ActivityReleasedService {
    @Resource
    ActivityReleasedDao activityReleasedDao;

    @Override
    public void insertIntoActivityReleased(ActivityReleased activityReleased) {
        activityReleasedDao.insertIntoActivityReleased(activityReleased);
    }

    @Override
    public List<ActivityReleased> findActivityList () {
       return activityReleasedDao.findActivityList();
    }
}

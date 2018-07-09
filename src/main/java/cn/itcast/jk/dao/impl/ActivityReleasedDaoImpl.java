package cn.itcast.jk.dao.impl;

import cn.itcast.jk.dao.ActivityReleasedDao;
import cn.itcast.jk.domain.ActivityReleased;
import org.springframework.stereotype.Repository;

@Repository
public  class ActivityReleasedDaoImpl extends BaseDaoImpl<ActivityReleased> implements ActivityReleasedDao {
    public ActivityReleasedDaoImpl() {super.setNs("cn.itcast.jk.mapper.ActivityReleasedMapper");}

    @Override
    public void insertIntoActivityReleased (ActivityReleased activityReleased) {
        super.getSqlSession().insert(super.getNs() + ".insertIntoActivityReleased",activityReleased);
    }
}

package cn.itcast.jk.dao.impl;

import cn.itcast.jk.dao.ActivityReleasedDao;
import cn.itcast.jk.domain.ActivityReleased;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public  class ActivityReleasedDaoImpl extends BaseDaoImpl<ActivityReleased> implements ActivityReleasedDao {
    public ActivityReleasedDaoImpl() {super.setNs("cn.itcast.jk.mapper.ActivityReleasedMapper");}

    @Override
    public void insertIntoActivityReleased (ActivityReleased activityReleased) {
        super.getSqlSession().insert(super.getNs() + ".insertIntoActivityReleased",activityReleased);
    }

    @Override
    public List<ActivityReleased> findActivityList () {
       return super.getSqlSession().selectList(super.getNs() + ".findActivityReleased");
    }
}

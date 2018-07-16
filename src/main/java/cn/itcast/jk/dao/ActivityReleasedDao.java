package cn.itcast.jk.dao;

import cn.itcast.jk.domain.ActivityReleased;

import java.util.List;

public interface ActivityReleasedDao extends BaseDao<ActivityReleased> {
    public void insertIntoActivityReleased (ActivityReleased activityReleased);

    public List<ActivityReleased> findActivityList ();
}

package cn.itcast.jk.dao;

import cn.itcast.jk.domain.ActivityReleased;

public interface ActivityReleasedDao extends BaseDao<ActivityReleased> {
    public void insertIntoActivityReleased (ActivityReleased activityReleased);
}

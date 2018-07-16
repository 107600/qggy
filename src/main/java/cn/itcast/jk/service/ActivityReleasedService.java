package cn.itcast.jk.service;

import cn.itcast.jk.domain.ActivityReleased;

import java.util.List;

public interface ActivityReleasedService {
    public void insertIntoActivityReleased (ActivityReleased activityReleased);

    public List<ActivityReleased> findActivityList ();
}

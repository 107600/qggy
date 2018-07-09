package cn.itcast.jk.service;

import cn.itcast.jk.domain.ActivityDirectory;

import java.util.List;

public interface ActivityDirectoryService {
    public List<ActivityDirectory> selectFromActivityDirectory (Integer parentId);
}

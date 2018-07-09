package cn.itcast.jk.dao;

import cn.itcast.jk.domain.ActivityDirectory;

import java.util.List;

public interface ActivityDirectoryDao extends BaseDao<ActivityDirectory> {
    public List<ActivityDirectory> selectFromActivityDirectory (Integer parentId);
}

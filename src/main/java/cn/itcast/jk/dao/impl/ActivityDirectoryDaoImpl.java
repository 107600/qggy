package cn.itcast.jk.dao.impl;

import cn.itcast.jk.dao.ActivityDirectoryDao;
import cn.itcast.jk.domain.ActivityDirectory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ActivityDirectoryDaoImpl extends BaseDaoImpl<ActivityDirectory> implements ActivityDirectoryDao {
    public ActivityDirectoryDaoImpl() {
        super.setNs("cn.itcast.jk.mapper.ActivityDirectoryMapper");
    }

    @Override
    public List<ActivityDirectory> selectFromActivityDirectory (Integer parentId) {
        return super.getSqlSession().selectList(super.getNs() + ".selectFromActivityDirectory", parentId);
    }
}

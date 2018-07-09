package cn.itcast.jk.service.impl;

import cn.itcast.jk.dao.ActivityDirectoryDao;
import cn.itcast.jk.domain.ActivityDirectory;
import cn.itcast.jk.service.ActivityDirectoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ActivityDirectoryServiceImpl implements ActivityDirectoryService {
    @Resource
    ActivityDirectoryDao activityDirectoryDao;

    @Override
    public List<ActivityDirectory> selectFromActivityDirectory (Integer parentId) {
        return activityDirectoryDao.selectFromActivityDirectory(parentId);
    }

}


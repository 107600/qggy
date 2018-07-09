package cn.itcast.jk.service.impl;

import cn.itcast.jk.dao.TeacherDomainDao;
import cn.itcast.jk.domain.TeacherDomain;
import cn.itcast.jk.service.TeacherDomainService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TeacherDomainServiceImpl implements TeacherDomainService {
    @Resource//注入Dao
    TeacherDomainDao teacherDomainDao;


    @Override
    public List<TeacherDomain> selectTeacherDomain () {
        return teacherDomainDao.selectTeacherDomain();
    }
}

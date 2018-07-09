package cn.itcast.jk.dao.impl;

import cn.itcast.jk.dao.TeacherDomainDao;
import cn.itcast.jk.domain.TeacherDomain;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TeacherDomainDaoImpl extends BaseDaoImpl<TeacherDomain> implements TeacherDomainDao {
    public TeacherDomainDaoImpl() {
        super.setNs("cn.itcast.jk.mapper.TeacherDomainMapper");
    }

    @Override
    public List<TeacherDomain> selectTeacherDomain () {
        return super.getSqlSession().selectList(super.getNs() + ".selectTeacherDomain");
    }
}

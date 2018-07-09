package cn.itcast.jk.dao;

import cn.itcast.jk.domain.TeacherDomain;

import java.util.List;

public interface TeacherDomainDao extends BaseDao<TeacherDomain> {
    public List<TeacherDomain> selectTeacherDomain ();
}

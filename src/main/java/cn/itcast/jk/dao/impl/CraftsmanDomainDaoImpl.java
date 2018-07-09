package cn.itcast.jk.dao.impl;


import cn.itcast.jk.dao.CraftsmanDomainDao;
import cn.itcast.jk.domain.CraftsmanDomain;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CraftsmanDomainDaoImpl extends BaseDaoImpl<CraftsmanDomain> implements CraftsmanDomainDao {
    public CraftsmanDomainDaoImpl() {
        super.setNs("cn.itcast.jk.mapper.CraftsmanDomainMapper");
    }

    @Override
    public List<CraftsmanDomain> selectCraftsmanDomain () {
        return super.getSqlSession().selectList(super.getNs() + ".selectCraftsmanDomain");
    }
}

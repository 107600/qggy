package cn.itcast.jk.dao;


import cn.itcast.jk.domain.CraftsmanDomain;

import java.util.List;

public interface CraftsmanDomainDao extends BaseDao<CraftsmanDomain> {
    public List<CraftsmanDomain> selectCraftsmanDomain ();
}

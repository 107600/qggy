package cn.itcast.jk.service.impl;


import cn.itcast.jk.dao.CraftsmanDomainDao;
import cn.itcast.jk.domain.CraftsmanDomain;
import cn.itcast.jk.service.CraftsmanDomainSerivice;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CraftsmanDomainServiceImpl implements CraftsmanDomainSerivice {
    @Resource
    CraftsmanDomainDao craftsmanDomainDao;

    @Override
    public List<CraftsmanDomain> selectCraftsmanDomain () {
        return craftsmanDomainDao.selectCraftsmanDomain();
    }
}

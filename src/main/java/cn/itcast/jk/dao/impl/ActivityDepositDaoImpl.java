package cn.itcast.jk.dao.impl;

import cn.itcast.jk.dao.ActivityDepositDao;
import cn.itcast.jk.dao.ActivityDepositDao;
import cn.itcast.jk.domain.ActivityDeposit;
import cn.itcast.jk.domain.ActivityDeposit;
import org.springframework.stereotype.Repository;

import java.util.Map;

/**
 * @Description:
 * @Author: nutony
 * @Company: http://java.itcast.cn
 * @CreateDate: 2014年10月9日
 */
@Repository
public class ActivityDepositDaoImpl extends BaseDaoImpl<ActivityDeposit> implements ActivityDepositDao {
    public ActivityDepositDaoImpl() {
        // 设置命名空间
        super.setNs("cn.itcast.jk.mapper.ActivityDepositMapper");
    }

    public void updateState(Map<?, ?> map) {
        super.getSqlSession().update(super.getNs() + ".updateState", map);
    }
}

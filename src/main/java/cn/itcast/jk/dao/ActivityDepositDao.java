package cn.itcast.jk.dao;

import cn.itcast.jk.domain.ActivityDeposit;
import cn.itcast.jk.domain.ActivityDeposit;

import java.util.Map;

/**
 * @Description:
 * @Author: nutony
 * @Company: http://java.itcast.cn
 * @CreateDate: 2014年10月9日
 */
public interface ActivityDepositDao extends BaseDao<ActivityDeposit> {
    public void updateState(Map<?, ?> map); // 修改状态

}

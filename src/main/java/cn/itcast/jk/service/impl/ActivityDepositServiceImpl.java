package cn.itcast.jk.service.impl;

import cn.itcast.jk.dao.ActivityDepositDao;
import cn.itcast.jk.dao.ActivityDepositDao;
import cn.itcast.jk.domain.ActivityDeposit;
import cn.itcast.jk.domain.ActivityDeposit;
import cn.itcast.jk.pagination.Page;
import cn.itcast.jk.service.ActivityDepositService;
import cn.itcast.jk.service.ActivityDepositService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @Author: ZH
 * @Company: http://java.itcast.cn
 * @CreateDate: 2018年7月10日
 */
@Service
public class ActivityDepositServiceImpl implements ActivityDepositService {
    @Resource
    ActivityDepositDao activityDepositDao;

    @Override
    public List<ActivityDeposit> findPage(Page<?> page) {
        return null;
    }

    @Override
    public List<ActivityDeposit> find(Map<?, ?> paraMap) {
        return activityDepositDao.find(paraMap);
    }

    public ActivityDeposit get(Serializable id) {
        return activityDepositDao.get(id);
    }

    public void insert(ActivityDeposit activityDeposit) {
        // activityDeposit.setId(UUID.randomUUID().toString()); //设置UUID
        activityDeposit.setActivityDepositState("1"); // 默认启用状态
        activityDepositDao.insert(activityDeposit);
    }

    public void update(ActivityDeposit activityDeposit) {
        activityDepositDao.update(activityDeposit);
    }

    public void deleteById(Serializable id) {
        activityDepositDao.deleteById(id);
    }

    public void delete(Serializable[] ids) {
        activityDepositDao.delete(ids);
    }

    public void start(Serializable[] ids) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("state", 1); // 1启用
        map.put("ids", ids);

        activityDepositDao.updateState(map);
    }

    public void stop(Serializable[] ids) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("state", 0); // 0停用
        map.put("ids", ids);

        activityDepositDao.updateState(map);
    }

    public List<ActivityDeposit> getActivityDepositList() {
        Map<String, Object> paraMap = new HashMap<String, Object>();
        paraMap.put("state", 1); // 1启用，代表只查询启用的类别

        return activityDepositDao.find(paraMap);
    }




}

package cn.itcast.jk.domain;


import java.io.Serializable;
import java.util.Date;

public class ActivityDeposit implements Serializable {

    private static final long serialVersionUID = -17438342718829082L;
    private String id;//活动编号
    private String activityDepositUserName;//用户名
    private java.util.Date activityDepositPayTime;//活动押金缴纳时间
    private java.util.Date activityDepositReturnTime;//活动押金退回时间
    private double activityDepositPayMoney;//活动押金缴纳金额
    private double activityDepositReturnMoney;//活动押金退回金额
    private String activityDepositDetails;//活动押金说明
    private String activityDepositState;//活动押金状态
    private String activityDepositName;//活动名称
    private String activityDepositUserId;//用户编号
    private String areaId;//区域编号
    private String areaName;//区域名称


    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getActivityDepositUserName() { return activityDepositUserName; }
    public void setActivityDepositUserName(String activityDepositUserName) { this.activityDepositUserName = activityDepositUserName; }

    public Date getActivityDepositPayTime() { return activityDepositPayTime; }
    public void setActivityDepositPayTime(Date activityDepositPayTime) { this.activityDepositPayTime = activityDepositPayTime; }

    public Date getActivityDepositReturnTime() { return activityDepositReturnTime; }
    public void setActivityDepositReturnTime(Date activityDepositReturnTime) { this.activityDepositReturnTime = activityDepositReturnTime; }

    public double getActivityDepositPayMoney() { return activityDepositPayMoney; }
    public void setActivityDepositPayMoney(double activityDepositPayMoney) { this.activityDepositPayMoney = activityDepositPayMoney; }

    public double getActivityDepositReturnMoney() { return activityDepositReturnMoney; }
    public void setActivityDepositReturnMoney(double activityDepositReturnMoney) { this.activityDepositReturnMoney = activityDepositReturnMoney; }

    public String getActivityDepositDetails() { return activityDepositDetails; }
    public void setActivityDepositDetails(String activityDepositDetails) { this.activityDepositDetails = activityDepositDetails; }

    public String getActivityDepositState() { return activityDepositState; }
    public void setActivityDepositState(String activityDepositState) { this.activityDepositState = activityDepositState; }

    public String getActivityDepositName() { return activityDepositName; }
    public void setActivityDepositName(String activityDepositName) { this.activityDepositName = activityDepositName; }

    public String getActivityDepositUserId() { return activityDepositUserId; }
    public void setActivityDepositUserId(String activityDepositUserId) { this.activityDepositUserId = activityDepositUserId; }

    public String getAreaId() { return areaId; }
    public void setAreaId(String areaId) { this.areaId = areaId; }

    public String getAreaName() { return areaName; }
    public void setAreaName(String areaName) { this.areaName = areaName; }


}

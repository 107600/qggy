package cn.itcast.jk.domain;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.Date;

public class PromoteCourse {

    private Integer promoteCourseId; //发起课程对应的课程主键，主键自增
    private String courseCategory; //发起课程对应的课程种类
    private String courseName; //发起课程对应的课程名称
    private Date courseTime; //发起课程对应的上课时间
    private String courseTimeStr; //发起课程对应的上课时间的string类型，用于查询
    private int courseAreaId; //发起课程对应的上课区域id，可能用不到，先保留
    private String courseAreaName; //发起课程对应的上课区域地点
    private String courseIntro; //发起课程对应的课程简介
    private Integer courseNumStu; //对该课程感兴趣的学生人数
    private Integer courseNumTea; //对该课程感兴趣的教师人数
    private String coursePromotePerson; //课程发起者
    private String courseUserOpenid; //唯一识别课程发起者的openid
    private int coursePromoteState; //该条课程发起的状态

    public PromoteCourse() {
    }

    public PromoteCourse(Integer promoteCourseId, String courseCategory, String courseName,
                         Date courseTime, String courseTimeStr, int courseAreaId,
                         String courseAreaName, String courseIntro,
                         Integer courseNumStu, Integer courseNumTea,
                         String coursePromotePerson, String courseUserOpenid,
                         int coursePromoteState) {
        this.promoteCourseId = promoteCourseId;
        this.courseCategory = courseCategory;
        this.courseName = courseName;
        this.courseTime = courseTime;
        this.courseTimeStr = courseTimeStr;
        this.courseAreaId = courseAreaId;
        this.courseAreaName = courseAreaName;
        this.courseIntro = courseIntro;
        this.courseNumStu = courseNumStu;
        this.courseNumTea = courseNumTea;
        this.coursePromotePerson = coursePromotePerson;
        this.courseUserOpenid = courseUserOpenid;
        this.coursePromoteState = coursePromoteState;
    }

    public Integer getPromoteCourseId() {
        return promoteCourseId;
    }

    public void setPromoteCourseId(Integer promoteCourseId) {
        this.promoteCourseId = promoteCourseId;
    }

    public String getCourseCategory() {
        return courseCategory;
    }

    public void setCourseCategory(String courseCategory) {
        this.courseCategory = courseCategory;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Date getCourseTime() {
        return courseTime;
    }

    public void setCourseTime(Date courseTime) {
        this.courseTime = courseTime;
    }

    public String getCourseTimeStr() {
        return courseTimeStr;
    }

    public void setCourseTimeStr(String courseTimeStr) {
        this.courseTimeStr = courseTimeStr;
    }

    public int getCourseAreaId() {
        return courseAreaId;
    }

    public void setCourseAreaId(int courseAreaId) {
        this.courseAreaId = courseAreaId;
    }

    public String getCourseAreaName() {
        return courseAreaName;
    }

    public void setCourseAreaName(String courseAreaName) {
        this.courseAreaName = courseAreaName;
    }

    public String getCourseIntro() {
        return courseIntro;
    }

    public void setCourseIntro(String courseIntro) {
        this.courseIntro = courseIntro;
    }

    public Integer getCourseNumStu() {
        return courseNumStu;
    }

    public void setCourseNumStu(Integer courseNumStu) {
        this.courseNumStu = courseNumStu;
    }

    public Integer getCourseNumTea() {
        return courseNumTea;
    }

    public void setCourseNumTea(Integer courseNumTea) {
        this.courseNumTea = courseNumTea;
    }

    public String getCoursePromotePerson() {
        return coursePromotePerson;
    }

    public void setCoursePromotePerson(String coursePromotePerson) {
        this.coursePromotePerson = coursePromotePerson;
    }

    public String getCourseUserOpenid() {
        return courseUserOpenid;
    }

    public void setCourseUserOpenid(String courseUserOpenid) {
        this.courseUserOpenid = courseUserOpenid;
    }

    public int getCoursePromoteState() {
        return coursePromoteState;
    }

    public void setCoursePromoteState(int coursePromoteState) {
        this.coursePromoteState = coursePromoteState;
    }

    @Override
    public String toString() {
        return "PromoteCourse{" +
                "promoteCourseId=" + promoteCourseId +
                ", courseCategory='" + courseCategory + '\'' +
                ", courseName='" + courseName + '\'' +
                ", courseTime=" + courseTime +
                ", courseTimeStr='" + courseTimeStr + '\'' +
                ", courseAreaId=" + courseAreaId +
                ", courseAreaName='" + courseAreaName + '\'' +
                ", courseIntro='" + courseIntro + '\'' +
                ", courseNumStu=" + courseNumStu +
                ", courseNumTea=" + courseNumTea +
                ", coursePromotePerson='" + coursePromotePerson + '\'' +
                ", courseUserOpenid='" + courseUserOpenid + '\'' +
                ", coursePromoteState=" + coursePromoteState +
                '}';
    }
}

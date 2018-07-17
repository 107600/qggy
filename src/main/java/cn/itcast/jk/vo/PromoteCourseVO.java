package cn.itcast.jk.vo;

//电脑端课程发起中的查看详细信息所要显示的内容
public class PromoteCourseVO {
    //老师：员工编号（暂时没有字段），姓名，领域（课程种类），信用积分
    //学生：会员号（暂时没有）、姓名
    //通用：openid、userid、状态（表示老师还是学生)、课程的id
    private String userName; //用户姓名
    private String courseCategory; //课程种类（领域）
    private int courseId; //课程的id
    private int creditPoints; //教师信用积分
    private String userOpenid; //用户的openid
    private String userId; //用户的userId
    private int state; //用户的状态，表明身份（老师、学生或其他）

    public PromoteCourseVO() {
    }

    public PromoteCourseVO(String userName, String courseCategory,int courseId,
                           int creditPoints, String userOpenid,
                           String userId, int state) {
        this.userName = userName;
        this.courseCategory = courseCategory;
        this.courseId = courseId;
        this.creditPoints = creditPoints;
        this.userOpenid = userOpenid;
        this.userId = userId;
        this.state = state;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getCourseCategory() {
        return courseCategory;
    }

    public void setCourseCategory(String courseCategory) {
        this.courseCategory = courseCategory;
    }

    public int getCreditPoints() {
        return creditPoints;
    }

    public void setCreditPoints(int creditPoints) {
        this.creditPoints = creditPoints;
    }

    public String getUserOpenid() {
        return userOpenid;
    }

    public void setUserOpenid(String userOpenid) {
        this.userOpenid = userOpenid;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "PromoteCourseVO{" +
                "userName='" + userName + '\'' +
                ", courseCategory='" + courseCategory + '\'' +
                ", courseId=" + courseId +
                ", creditPoints=" + creditPoints +
                ", userOpenid='" + userOpenid + '\'' +
                ", userId='" + userId + '\'' +
                ", state=" + state +
                '}';
    }
}

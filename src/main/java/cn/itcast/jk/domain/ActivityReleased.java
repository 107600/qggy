package cn.itcast.jk.domain;


import com.sun.istack.NotNull;


import java.util.Date;

/**
 *
 * @author 展佳俊
 * @date 2018/7/6 13:38
 */
public class ActivityReleased {

    private Integer id;

    @NotNull
    private String activityName;

    private String firstCategory;
    private String secondCategory;

    @NotNull
    private String address;


    private Date activityDate;

    @NotNull
    private String affiliatedCompany;

    private Integer isNeedTeacher;


    private Integer teacherNumbers;
    private String teacherDomain;
    private Integer teacherDeposit;
    private Integer teacherReward;

    private Integer isNeedCraftsman;
    private Integer craftsmanNumbers;
    private String craftsmanDomain;
    private Integer craftsmanDeposit;
    private Integer craftsmanReward;

    private Integer isNeedVolunteer;
    private Integer volunteerNumbers;
    private Integer volunteerDeposit;
    private Integer volunteerReward;

    private Integer isNeedAudience;
    private Integer audienceNumbers;

    private String placeProvider;
    private String traffic;
    private String image;
    private String activityDescribe;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public String getFirstCategory() {
        return firstCategory;
    }

    public void setFirstCategory(String firstCategory) {
        this.firstCategory = firstCategory;
    }

    public String getSecondCategory() {
        return secondCategory;
    }

    public void setSecondCategory(String secondCategory) {
        this.secondCategory = secondCategory;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getActivityDate() {
        return activityDate;
    }

    public void setActivityDate(Date activityDate) {
        this.activityDate = activityDate;
    }

    public String getAffiliatedCompany() {
        return affiliatedCompany;
    }

    public void setAffiliatedCompany(String affiliatedCompany) {
        this.affiliatedCompany = affiliatedCompany;
    }

    public Integer getIsNeedTeacher() {
        return isNeedTeacher;
    }

    public void setIsNeedTeacher(Integer isNeedTeacher) {
        this.isNeedTeacher = isNeedTeacher;
    }

    public Integer getTeacherNumbers() {
        return teacherNumbers;
    }

    public void setTeacherNumbers(Integer teacherNumbers) {
        this.teacherNumbers = teacherNumbers;
    }

    public String getTeacherDomain() {
        return teacherDomain;
    }

    public void setTeacherDomain(String teacherDomain) {
        this.teacherDomain = teacherDomain;
    }

    public Integer getTeacherDeposit() {
        return teacherDeposit;
    }

    public void setTeacherDeposit(Integer teacherDeposit) {
        this.teacherDeposit = teacherDeposit;
    }

    public Integer getTeacherReward() {
        return teacherReward;
    }

    public void setTeacherReward(Integer teacherReward) {
        this.teacherReward = teacherReward;
    }

    public Integer getIsNeedCraftsman() {
        return isNeedCraftsman;
    }

    public void setIsNeedCraftsman(Integer isNeedCraftsman) {
        this.isNeedCraftsman = isNeedCraftsman;
    }

    public Integer getCraftsmanNumbers() {
        return craftsmanNumbers;
    }

    public void setCraftsmanNumbers(Integer craftsmanNumbers) {
        this.craftsmanNumbers = craftsmanNumbers;
    }

    public String getCraftsmanDomain() {
        return craftsmanDomain;
    }

    public void setCraftsmanDomain(String craftsmanDomain) {
        this.craftsmanDomain = craftsmanDomain;
    }

    public Integer getCraftsmanDeposit() {
        return craftsmanDeposit;
    }

    public void setCraftsmanDeposit(Integer craftsmanDeposit) {
        this.craftsmanDeposit = craftsmanDeposit;
    }

    public Integer getCraftsmanReward() {
        return craftsmanReward;
    }

    public void setCraftsmanReward(Integer craftsmanReward) {
        this.craftsmanReward = craftsmanReward;
    }

    public Integer getIsNeedVolunteer() {
        return isNeedVolunteer;
    }

    public void setIsNeedVolunteer(Integer isNeedVolunteer) {
        this.isNeedVolunteer = isNeedVolunteer;
    }

    public Integer getVolunteerNumbers() {
        return volunteerNumbers;
    }

    public void setVolunteerNumbers(Integer volunteerNumbers) {
        this.volunteerNumbers = volunteerNumbers;
    }

    public Integer getVolunteerDeposit() {
        return volunteerDeposit;
    }

    public void setVolunteerDeposit(Integer volunteerDeposit) {
        this.volunteerDeposit = volunteerDeposit;
    }

    public Integer getVolunteerReward() {
        return volunteerReward;
    }

    public void setVolunteerReward(Integer volunteerReward) {
        this.volunteerReward = volunteerReward;
    }

    public Integer getIsNeedAudience() {
        return isNeedAudience;
    }

    public void setIsNeedAudience(Integer isNeedAudience) {
        this.isNeedAudience = isNeedAudience;
    }

    public Integer getAudienceNumbers() {
        return audienceNumbers;
    }

    public void setAudienceNumbers(Integer audienceNumbers) {
        this.audienceNumbers = audienceNumbers;
    }

    public String getPlaceProvider() {
        return placeProvider;
    }

    public void setPlaceProvider(String placeProvider) {
        this.placeProvider = placeProvider;
    }

    public String getTraffic() {
        return traffic;
    }

    public void setTraffic(String traffic) {
        this.traffic = traffic;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getActivityDescribe() {
        return activityDescribe;
    }

    public void setActivityDescribe(String activityDescribe) {
        this.activityDescribe = activityDescribe;
    }
}

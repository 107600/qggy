package cn.itcast.jk.domain;
import java.io.Serializable;

/**
 * Created by ck on 2018/6/11.
 */
public class Activity implements Serializable{



    private Integer num;
    private String type;
    private String theme;
    private String time;
    private String place;
    private String state;
    private String launcher;
    private Integer people;
    private Integer money;
    private String volunteerneed;
    private String audienceneed;
    private String craftsmanneed;
    private String placeneed;
    private Integer volunteernum;
    private Integer audiencenum;
    private Integer craftsmannum;
    private String deposit;
    private String teacherneed;
    private Integer teachernum;
    private String introduction;
    private String teachertype;
    private String suggestion;


    public String getSuggestion() {
        return suggestion;
    }

    public void setSuggestion(String suggestion) {
        this.suggestion = suggestion;
    }

    public Integer getPeople() {
        return people;
    }

    public void setPeople(Integer people) {
        this.people = people;
    }

    public String getTeachertype() {
        return teachertype;
    }

    public void setTeachertype(String teachertype) {
        this.teachertype = teachertype;
    }


    public String getLauncher() {
        return launcher;
    }

    public void setLauncher(String launcher) {
        this.launcher = launcher;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    public String getVolunteerneed() {
        return volunteerneed;
    }

    public void setVolunteerneed(String volunteerneed) {
        this.volunteerneed = volunteerneed;
    }

    public String getAudienceneed() {
        return audienceneed;
    }

    public void setAudienceneed(String audienceneed) {
        this.audienceneed = audienceneed;
    }

    public String getCraftsmanneed() {
        return craftsmanneed;
    }

    public void setCraftsmanneed(String craftsmanneed) {
        this.craftsmanneed = craftsmanneed;
    }

    public String getPlaceneed() {
        return placeneed;
    }

    public void setPlaceneed(String placeneed) {
        this.placeneed = placeneed;
    }

    public Integer getVolunteernum() {
        return volunteernum;
    }

    public void setVolunteernum(Integer volunteernum) {
        this.volunteernum = volunteernum;
    }

    public Integer getAudiencenum() {
        return audiencenum;
    }

    public void setAudiencenum(Integer audiencenum) {
        this.audiencenum = audiencenum;
    }

    public Integer getCraftsmannum() {
        return craftsmannum;
    }

    public void setCraftsmannum(Integer craftsmannum) {
        this.craftsmannum = craftsmannum;
    }

    public String getDeposit() {
        return deposit;
    }

    public void setDeposit(String deposit) {
        this.deposit = deposit;
    }

    public String getTeacherneed() {
        return teacherneed;
    }

    public void setTeacherneed(String teacherneed) {
        this.teacherneed = teacherneed;
    }

    public Integer getTeachernum() {
        return teachernum;
    }

    public void setTeachernum(Integer teachernum) {
        this.teachernum = teachernum;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }



    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String  getState() {
        return state;
    }

    public void setState(String  state) {
        this.state = state;
    }


    @Override
    public String toString() {
        return "Activity{" +
                "num=" + num +
                ", type='" + type + '\'' +
                ", theme='" + theme + '\'' +
                ", time='" + time + '\'' +
                ", place='" + place + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}

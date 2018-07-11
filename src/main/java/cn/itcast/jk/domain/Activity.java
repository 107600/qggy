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
    private int people;
    private double money;
    private int volunteerneed;
    private int audienceneed;
    private int craftsmanneed;
    private int placeneed;
    private String volunteernum;
    private String audiencenum;
    private String craftsmannum;
    private int deposit;
    private int teacherneed;
    private String teachernum;
    private String introduction;
    private String teachertype;



    public int getPeople() {
        return people;
    }

    public void setPeople(int people) {
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

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public int getVolunteerneed() {
        return volunteerneed;
    }

    public void setVolunteerneed(int volunteerneed) {
        this.volunteerneed = volunteerneed;
    }

    public int getAudienceneed() {
        return audienceneed;
    }

    public void setAudienceneed(int audienceneed) {
        this.audienceneed = audienceneed;
    }

    public int getCraftsmanneed() {
        return craftsmanneed;
    }

    public void setCraftsmanneed(int craftsmanneed) {
        this.craftsmanneed = craftsmanneed;
    }

    public int getPlaceneed() {
        return placeneed;
    }

    public void setPlaceneed(int placeneed) {
        this.placeneed = placeneed;
    }

    public String getVolunteernum() {
        return volunteernum;
    }

    public void setVolunteernum(String volunteernum) {
        this.volunteernum = volunteernum;
    }

    public String getAudiencenum() {
        return audiencenum;
    }

    public void setAudiencenum(String audiencenum) {
        this.audiencenum = audiencenum;
    }

    public String getCraftsmannum() {
        return craftsmannum;
    }

    public void setCraftsmannum(String craftsmannum) {
        this.craftsmannum = craftsmannum;
    }

    public int getDeposit() {
        return deposit;
    }

    public void setDeposit(int deposit) {
        this.deposit = deposit;
    }

    public int getTeacherneed() {
        return teacherneed;
    }

    public void setTeacherneed(int teacherneed) {
        this.teacherneed = teacherneed;
    }

    public String getTeachernum() {
        return teachernum;
    }

    public void setTeachernum(String teachernum) {
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

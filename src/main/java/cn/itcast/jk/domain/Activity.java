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

    public String getState() {
        return state;
    }

    public void setState(String state) {
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

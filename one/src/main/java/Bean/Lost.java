package Bean;

import java.util.Calendar;
import java.util.Date;

public abstract class Lost {
    //对于学生卡就是学生的名字，图书就是书名。可能存在问题
    private String name;
    private String location;//认领地点
    private Calendar date;
    private String information;//具体补充信息


    public Lost() {

    }

    public Lost(Calendar date) {
        this.date = date;
    }

    public Lost(String name, String location, Calendar date, String information) {
        this.name = name;
        this.location = location;
        this.date = date;
        this.information = information;
    }

    public Lost(String name, String location, String information) {
        this.name = name;
        this.location = location;
        this.information = information;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Calendar getDate() {
        return date;
    }

    public void setDate(Calendar date) {
        this.date = date;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }
}

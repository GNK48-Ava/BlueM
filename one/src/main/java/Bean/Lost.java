package Bean;

import java.util.Calendar;
import java.util.Date;

public abstract class Lost {

    private String name;
    private String location;
    private Calendar date;
    private String information;




    public Lost() {

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

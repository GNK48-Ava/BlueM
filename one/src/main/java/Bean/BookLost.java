package Bean;

import java.util.Calendar;

public class BookLost extends Lost{
    private String press;





    public BookLost(String name, String location, Calendar date, String information, String press) {
        super(name, location, date, information);
        this.press = press;
    }

    public BookLost(String name, String location, String information, String press) {
        super(name, location, information);
        this.press = press;
    }

    public BookLost() {

    }
}

package Bean;

public class CardLost extends Lost{
    private String id;//学号
    private String college;//学院


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }
}

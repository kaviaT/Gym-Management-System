package CourseworkTwo;

import javafx.beans.property.SimpleStringProperty;

public class StudentGui {

    private SimpleStringProperty id;
    private SimpleStringProperty name;
    private SimpleStringProperty school;

    public StudentGui(String id,String name,String school) {
        this.id=new SimpleStringProperty(id);
        this.name=new SimpleStringProperty(name);
        this.school=new SimpleStringProperty(school);
    }

    //------------ID---------------
    public String getId() {
        return id.get();
    }
    public void setId(String id) {
        this.id=new SimpleStringProperty(id);
    }

    //----------Name--------------
    public String getName() {
        return name.get();
    }
    public void setName(String name) {
        this.name=new SimpleStringProperty(name);
    }

    //--------School---------------
    public String getSchool() {
        return school.get();
    }
    public void setSchool(String school) {
        this.school=new SimpleStringProperty(school);
    }
}




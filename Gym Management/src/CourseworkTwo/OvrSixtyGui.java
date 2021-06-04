package CourseworkTwo;

import javafx.beans.property.SimpleStringProperty;

public class OvrSixtyGui {

    private SimpleStringProperty ovrId;
    private SimpleStringProperty ovrName;
    private SimpleStringProperty ovrAge;

    public OvrSixtyGui(String ovrId,String ovrName,String ovrAge) {
        this.ovrId=new SimpleStringProperty(ovrId);
        this.ovrName=new SimpleStringProperty(ovrName);
        this.ovrAge=new SimpleStringProperty(ovrAge);
    }

    //------------ID---------------
    public String getOvrId() {
        return ovrId.get();
    }
    public void setOvrId(String ovrId) {
        this.ovrId=new SimpleStringProperty(ovrId);
    }

    //----------Name--------------
    public String getOvrName() {
        return ovrName.get();
    }
    public void setOvrName(String ovrName) {
        this.ovrName=new SimpleStringProperty(ovrName);
    }


    //--------Age---------------
    public String getOvrAge() {
        return ovrAge.get();
    }
    public void setOvrAge(String ovrAge) {
        this.ovrAge=new SimpleStringProperty(ovrAge);
    }
}
package CourseworkTwo;

import javafx.beans.property.SimpleStringProperty;

public class DefaultGui {

    private SimpleStringProperty defId;
    private SimpleStringProperty defName;
    private SimpleStringProperty defAge;

    public DefaultGui(String defId,String defName,String defAge) {
        this.defId=new SimpleStringProperty(defId);
        this.defName=new SimpleStringProperty(defName);
        this.defAge=new SimpleStringProperty(defAge);
    }

    //------------ID---------------
    public String getDefId() {
        return defId.get();
    }
    public void setDefId(String defId) {
        this.defId=new SimpleStringProperty(defId);
    }

    //----------Name--------------
    public String getDefName() {
        return defName.get();
    }
    public void setDefName(String defName) {
        this.defName=new SimpleStringProperty(defName);
    }

    //--------Age---------------
    public String getDefAge() {
        return defAge.get();
    }
    public void setDefAge(String defAge) {
        this.defAge=new SimpleStringProperty(defAge);
    }
}

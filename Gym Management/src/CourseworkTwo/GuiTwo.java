package CourseworkTwo;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.bson.Document;

public class GuiTwo {
    TableView<OvrSixtyGui> tableViewOvr;
    TableColumn<OvrSixtyGui,String> tcOvrId;
    TableColumn<OvrSixtyGui,String>tcOvrName;
    TableColumn<OvrSixtyGui,String>tcOvrAge;

    public void openViewTwo() {

        Stage primaryStage=new Stage();
        primaryStage.setTitle("Over Sixty Years");

        Label lblHead=new Label("Over Sixty Yrs Member List");  //label of Heading
        lblHead.setLayoutX(118.0);
        lblHead.setLayoutY(22.0);
        lblHead.setPrefSize(260.0,19.0);
        lblHead.setStyle("-fx-font-weight: bold;-fx-font-size: 20px");

        TextField txtSearch=new TextField();  //textfield for Search
        txtSearch.setLayoutX(40.0);
        txtSearch.setLayoutY(387.0);
        txtSearch.setPrefSize(198.0,25.0);
        txtSearch.setPromptText("Search By ID");
        txtSearch.setStyle("-fx-border-color: darkblue;-fx-background-color: lightblue");

        Button btnSearch=new Button("Search");
        btnSearch.setLayoutX(257.0);
        btnSearch.setLayoutY(381.0);
        btnSearch.setPrefSize(101.0,38.0);
        btnSearch.setStyle("-fx-background-color: lightblue;-fx-font-size: 17px;-fx-font-weight: bold;-fx-border-color: darkblue");

        btnSearch.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                MongoDatabase maindatabase = DBConnection.connect();
                MongoCollection<Document> addcheck = maindatabase.getCollection("OverSixtyMembers");
                FindIterable<Document> findIterable = addcheck.find();
                String userId=txtSearch.getText();   //taking the value which is user searched for
                MongoCursor<Document> recordsTwo =findIterable.iterator();

                while(recordsTwo.hasNext()) {
                    String ID=recordsTwo.next().getString("Over_Sixty_Member_Id");  //search from ID

                    if(ID.equals(userId)) {
                        System.out.println("This ID is Exists"); //will print when the ID number is Exists
                        break;

                    }else {
                        System.out.println("This ID is not Exists");
                        break;
                    }
                }
            }

        });

        tableViewOvr=new TableView();
        tableViewOvr.setLayoutX(7.0);
        tableViewOvr.setLayoutY(74.0);
        tableViewOvr.setPrefSize(481.0,277.0);
        //columns of table
        tcOvrId=new TableColumn("Id Number");
        tcOvrId.setPrefWidth(101.0);

        tcOvrName=new TableColumn("Name");
        tcOvrName.setPrefWidth(223.0);

        tcOvrAge=new TableColumn("Age");
        tcOvrAge.setPrefWidth(156.0);

        tableViewOvr.getColumns().addAll(tcOvrId,tcOvrName,tcOvrAge);

        Pane root=new Pane();
        root.setStyle("-fx-background-color: bisque");
        root.getChildren().addAll(tableViewOvr,lblHead,txtSearch,btnSearch);

        primaryStage.setScene(new Scene(root,495.0,475.0));
        primaryStage.show();

        //adding all values into Table in the GUI
        tcOvrId.setCellValueFactory(new PropertyValueFactory<>("ovrId"));
        MongoDatabase maindatabase = DBConnection.connect();
        MongoCollection<Document> doc4 = maindatabase.getCollection("OverSixtyMembers");
        FindIterable<Document> findIterable = doc4.find();
        ObservableList<OvrSixtyGui> array4 = FXCollections.observableArrayList();
        for (Document count4 : findIterable) {
            OvrSixtyGui sg4=new OvrSixtyGui(count4.getString("Over_Sixty_Member_Id"),count4.getString("Over_Sixty_Member_Name"),count4.getString("Over_Sixty_Member_Age"));
            array4.add(sg4);
        }
        tableViewOvr.setItems(array4);


        tcOvrName.setCellValueFactory(new PropertyValueFactory<>("ovrName"));
        MongoDatabase maindatabase2 = DBConnection.connect();
        MongoCollection<Document> doc5 = maindatabase2.getCollection("OverSixtyMembers");
        FindIterable<Document> findIterable2 = doc5.find();
        ObservableList<OvrSixtyGui> array5 = FXCollections.observableArrayList();
        for (Document count5 : findIterable2) {
            OvrSixtyGui sg5=new OvrSixtyGui(count5.getString("Over_Sixty_Member_Id"),count5.getString("Over_Sixty_Member_Name"),count5.getString("Over_Sixty_Member_Age"));
            array5.add(sg5);
        }
        tableViewOvr.setItems(array5);


        tcOvrAge.setCellValueFactory(new PropertyValueFactory<>("ovrAge"));
        MongoDatabase maindatabase3 = DBConnection.connect();
        MongoCollection<Document> doc6 = maindatabase3.getCollection("OverSixtyMembers");
        FindIterable<Document> findIterable3 = doc6.find();
        ObservableList<OvrSixtyGui> array6 = FXCollections.observableArrayList();
        for (Document count6 : findIterable3) {
            OvrSixtyGui sg6=new OvrSixtyGui(count6.getString("Over_Sixty_Member_Id"),count6.getString("Over_Sixty_Member_Name"),count6.getString("Over_Sixty_Member_Age"));
            array6.add(sg6);  //adding the values to Columns of GUI
        }
        tableViewOvr.setItems(array6);

    }
}

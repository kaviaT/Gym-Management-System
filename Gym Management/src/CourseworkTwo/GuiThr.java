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

public class GuiThr {

    TableView<DefaultGui> tableDefault;
    TableColumn<DefaultGui, String> tcDefId;
    TableColumn<DefaultGui, String>tcDefName;
    TableColumn<DefaultGui, String>tcDefAge;

    public void openViewThr() {

        Stage primaryStage=new Stage();
        primaryStage.setTitle("Default Members");

        Label lblHead=new Label("Default Member List");  //Label of the Heading
        lblHead.setLayoutX(158.0);
        lblHead.setLayoutY(21.0);
        lblHead.setPrefSize(198.0,31.0);
        lblHead.setStyle("-fx-font-weight: bold;-fx-font-size: 20px");

        TextField txtSearch=new TextField();  //search textfield
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
                MongoCollection<Document> collection = maindatabase.getCollection("DefaultMembers");
                FindIterable<Document> findIterable =  collection.find();
                String userId=txtSearch.getText();  //getting the value of textfield
                MongoCursor<Document> records =findIterable.iterator();

                while(records.hasNext()) {
                    String ID=records.next().getString("Member_Id");

                    if(ID.equals(userId)) {
                        System.out.println("This ID is Exists");
                        break;

                    }else {
                        System.out.println("This ID is not Exists");
                        break;
                    }
                }

            }
        });

        tableDefault=new TableView();
        tableDefault.setLayoutX(7.0);
        tableDefault.setLayoutY(74.0);
        tableDefault.setPrefSize(481.0,277.0);
        tableDefault.setStyle("");

        tcDefId=new TableColumn("Id Number");
        tcDefId.setPrefWidth(101.0);

        tcDefName=new TableColumn("Name");
        tcDefName.setPrefWidth(223.0);

        tcDefAge=new TableColumn("Age");
        tcDefAge.setPrefWidth(156.0);

        tableDefault.getColumns().addAll(tcDefId,tcDefName,tcDefAge);

        Pane root=new Pane();
        root.setStyle("-fx-background-color: indianred");
        root.getChildren().addAll(tableDefault,lblHead,txtSearch,btnSearch);

        primaryStage.setScene(new Scene(root,495.0,475.0));
        primaryStage.show();

        //adding the all values for the Table of GUI
        tcDefId.setCellValueFactory(new PropertyValueFactory<>("defId"));
        MongoDatabase maindatabase = DBConnection.connect();
        MongoCollection<Document> doc4 = maindatabase.getCollection("DefaultMembers");
        FindIterable<Document> findIterable = doc4.find();
        ObservableList<DefaultGui> array4 = FXCollections.observableArrayList();
        for (Document count4 : findIterable) {
            DefaultGui sg4=new DefaultGui(count4.getString("Member_Id"),count4.getString("Member_Name"),count4.getString("Member_Age"));
            array4.add(sg4);
        }
        tableDefault.setItems(array4);


        tcDefName.setCellValueFactory(new PropertyValueFactory<>("defName"));
        MongoDatabase maindatabase2 = DBConnection.connect();
        MongoCollection<Document> doc5 = maindatabase2.getCollection("DefaultMembers");
        FindIterable<Document> findIterable2 = doc5.find();
        ObservableList<DefaultGui> array5 = FXCollections.observableArrayList();
        for (Document count5 : findIterable2) {
            DefaultGui sg5=new DefaultGui(count5.getString("Member_Id"),count5.getString("Member_Name"),count5.getString("Member_Age"));
            array5.add(sg5);
        }
        tableDefault.setItems(array5);


        tcDefAge.setCellValueFactory(new PropertyValueFactory<>("defAge"));
        MongoDatabase maindatabase3 = DBConnection.connect();
        MongoCollection<Document> doc6 = maindatabase3.getCollection("DefaultMembers");
        FindIterable<Document> findIterable3 = doc6.find();
        ObservableList<DefaultGui> array6 = FXCollections.observableArrayList();
        for (Document count6 : findIterable3) {
            DefaultGui sg6=new DefaultGui(count6.getString("Member_Id"),count6.getString("Member_Name"),count6.getString("Member_Age"));
            array6.add(sg6);
        }
        tableDefault.setItems(array6);

    }

}

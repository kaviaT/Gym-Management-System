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

public class GUI {

     TableView<StudentGui> tableView;
     TableColumn<StudentGui, String> tcId;
     TableColumn<StudentGui, String>tcName;
     TableColumn<StudentGui, String>tcSchool;

    public void openView(){
        Stage primaryStage=new Stage();
        primaryStage.setTitle("Student Gui");

        Label lblHead=new Label("Student Member List");  //label for Heading
        lblHead.setLayoutX(158.0);
        lblHead.setLayoutY(21.0);
        lblHead.setPrefSize(198.0,31.0);
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

        btnSearch.setOnAction(new EventHandler<ActionEvent>() {  //When Search Button is Clicked,
            @Override
            public void handle(ActionEvent event) {
                MongoDatabase maindatabase = DBConnection.connect();
                MongoCollection<Document> collection = maindatabase.getCollection("StudentMembers");
                FindIterable<Document> findIterable =  collection.find();

                String userId=txtSearch.getText();

                MongoCursor<Document> records =findIterable.iterator();

                while(records.hasNext()) {
                    String ID=records.next().getString("StudentMemberId");

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

        tableView=new TableView();
        tableView.setLayoutX(7.0);
        tableView.setLayoutY(74.0);
        tableView.setPrefSize(481.0,277.0);
        tableView.setStyle("-fx-background-color: lightgreen");

        tcId=new TableColumn("Id Number");
        tcId.setPrefWidth(101.0);

        tcName=new TableColumn("Name");
        tcName.setPrefWidth(223.0);

        tcSchool=new TableColumn("School");
        tcSchool.setPrefWidth(156.0);

        tableView.getColumns().addAll(tcId,tcName,tcSchool);  //adding all columns the Table

        Pane root=new Pane();
        root.setStyle("-fx-background-color: lightgreen");

        root.getChildren().addAll(tableView,lblHead,txtSearch,btnSearch);

        primaryStage.setScene(new Scene(root,495.0,475.0));
        primaryStage.show();
        //getting the data on Mongodb and Add them Into the Table
        tcId.setCellValueFactory(new PropertyValueFactory<>("id"));
        MongoDatabase maindatabase = DBConnection.connect();
        MongoCollection<Document> doc = maindatabase.getCollection("StudentMembers");
        FindIterable<Document> findIterable = doc.find();
        ObservableList<StudentGui> array = FXCollections.observableArrayList();
        for (Document count : findIterable) {
            StudentGui sg=new StudentGui(count.getString("StudentMemberId"),count.getString("StudentMemberName"),count.getString("StudentMemberSchool"));
            array.add(sg);
        }
        tableView.setItems(array);


        tcName.setCellValueFactory(new PropertyValueFactory<>("name"));
        MongoDatabase maindatabase1 = DBConnection.connect();
        MongoCollection<Document> doc2 = maindatabase1.getCollection("StudentMembers");
        FindIterable<Document> findIterable2 = doc2.find();
        ObservableList<StudentGui> array2=FXCollections.observableArrayList();
        for (Document count2 : findIterable2) {
            StudentGui sg2=new StudentGui(count2.getString("StudentMemberId"),count2.getString("StudentMemberName"),count2.getString("StudentMemberSchool"));
            array2.add(sg2);
        }
        tableView.setItems(array2);



        tcSchool.setCellValueFactory(new PropertyValueFactory<>("school"));
        MongoDatabase maindatabase3 = DBConnection.connect();
        MongoCollection<Document> doc3 = maindatabase3.getCollection("StudentMembers");
        FindIterable<Document> findIterable3 = doc3.find();
        ObservableList<StudentGui> array3=FXCollections.observableArrayList();
        for (Document count3 : findIterable3) {
            StudentGui sg3=new StudentGui(count3.getString("StudentMemberId"),count3.getString("StudentMemberName"),count3.getString("StudentMemberSchool"));
            array3.add(sg3);
        }
        tableView.setItems(array3);
    }
}











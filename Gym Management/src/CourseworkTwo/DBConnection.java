package CourseworkTwo;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public class DBConnection {
    public static MongoDatabase connect(){
        //Establish the default database connection
        MongoClient mongoClient = MongoClients.create();
        MongoDatabase database = mongoClient.getDatabase("Gym");

        //creating collections for Student,OverSixty and Default Members
        if(database.getCollection("StudentMembers")==null){
            database.createCollection("StudentMembers");
        }
        if(database.getCollection("OverSixtyMembers")==null){
            database.createCollection("OverSixtyMembers");
        }
        if(database.getCollection("DefaultMembers")==null){
            database.createCollection("DefaultMembers");
        }
        return database;
    }
}

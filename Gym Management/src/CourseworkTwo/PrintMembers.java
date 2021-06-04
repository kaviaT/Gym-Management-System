package CourseworkTwo;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class PrintMembers {

    public void printmem() {
        Scanner select = new Scanner(System.in);
        System.out.println("Press and Enter Number 1 to Print all names Student");
        System.out.println("Press and Enter Number 2 to Print all names Over 60 yrs ");
        System.out.println("Press and Enter Number 3 to Print all names Default Members");
        System.out.println("------------------------------------------------");

        Integer memberChoice = select.nextInt();
        if (memberChoice == 1) {
            PrintStudent printStudent = new PrintStudent();
            printStudent.student();
        }
        else if (memberChoice == 2) {
            PrintOvrSixty printOvrSixty = new PrintOvrSixty();
            printOvrSixty.ovrsixty();
        }
        else if (memberChoice == 3) {
            PrintDefault printDefault = new PrintDefault();
            printDefault.defaultmember();
        }
        else{
            System.out.println("Run Again and Please Enter a Valid Number! ");
        }
    }
}

class PrintStudent extends AddMember {

    public static String Check;
    public void student() {
        MongoDatabase maindatabase = DBConnection.connect();
        MongoCollection<Document> sortcheck = maindatabase.getCollection("StudentMembers");
        FindIterable<Document> findIterable = sortcheck.find();

        List<String> list= new ArrayList<>();
        for (Document count : findIterable) {
            Check = count.getString("StudentMemberName");
            list.add(Check);
        }
        Collections.sort(list);
        System.out.println("All Student Members are: "+list);  //printing the List of Students

    }
}

class PrintOvrSixty extends AddMember {

    public static String Check;
    public void ovrsixty() {
        MongoDatabase maindatabase = DBConnection.connect();
        MongoCollection<Document> sortcheck = maindatabase.getCollection("OverSixtyMembers");
        FindIterable<Document> findIterable = sortcheck.find();

        List<String>list= new ArrayList<>();
        for (Document count : findIterable) {
            Check = count.getString("Over_Sixty_Member_Name");
            list.add(Check);
        }
        Collections.sort(list);
        System.out.println("All Over 60yrs Members are: " +list);  //Printing the List of Over 60 yrs old Members

    }
}

class PrintDefault extends AddMember {

    public static String Check;
    public void defaultmember() {
        MongoDatabase maindatabase = DBConnection.connect();
        MongoCollection<Document> sortcheck = maindatabase.getCollection("DefaultMembers");
        FindIterable<Document> findIterable = sortcheck.find();

        List<String>list= new ArrayList<>();
        for (Document count : findIterable) {
            Check = count.getString("Member_Name");
            list.add(Check);
        }
        Collections.sort(list);
        System.out.println("All Default Members are: " +list); //printing the list of Default Members

    }
}

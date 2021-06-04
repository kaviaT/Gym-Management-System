package CourseworkTwo;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Sort {
    public void sort() {
        Scanner select = new Scanner(System.in);
        System.out.println("Press and Enter Number 1 to Sort from Student");
        System.out.println("Press and Enter Number 2 to Sort from Over 60 yrs ");
        System.out.println("Press and Enter Number 3 to Sort from Default Members");
        System.out.println("------------------------------------------------");

        Integer memberChoice = select.nextInt();
        if(memberChoice==1){
            SortStudent sortStudent=new SortStudent();
            sortStudent.student();
        }
        else if(memberChoice==2){
            SortOvrSixty sortOvrSixty=new SortOvrSixty();
            sortOvrSixty.ovrSixty();
        }
        else if(memberChoice==3){
            SortDefaultMem sortDefaultMem=new SortDefaultMem();
            sortDefaultMem.defaultmem();
        }
        else{
            System.out.println("Run Again and Please Enter a Valid Number! "); //will print when User didn't click a valid Number
        }

    }
}

class SortStudent extends AddMember {
    //sorting from Student Members
    public static String Check;
    public void student() {
        MongoDatabase maindatabase = DBConnection.connect();
        MongoCollection<Document> sortcheck = maindatabase.getCollection("StudentMembers");
        FindIterable<Document> findIterable = sortcheck.find();

        List<String>list= new ArrayList<>();
        for (Document count : findIterable) {
            Check = count.getString("StudentMemberName");
            list.add(Check);
        }
        Collections.sort(list);
        System.out.println(list);

    }
}

class SortOvrSixty extends AddMember {
    //sorting from Over 60yrs Old Members
    public static String Check;
    public void ovrSixty() {
        MongoDatabase maindatabase = DBConnection.connect();
        MongoCollection<Document> sortcheck = maindatabase.getCollection("OverSixtyMembers");
        FindIterable<Document> findIterable = sortcheck.find();

        List<String>list= new ArrayList<>();
        for (Document count : findIterable) {
            Check = count.getString("Over_Sixty_Member_Name");
            list.add(Check);
        }
        Collections.sort(list);
        System.out.println(list);

    }
}

class SortDefaultMem extends AddMember {
    //sorting from Default Members
    public static String Check;
    public void defaultmem() {
        MongoDatabase maindatabase = DBConnection.connect();
        MongoCollection<Document> sortcheck = maindatabase.getCollection("DefaultMembers");
        FindIterable<Document> findIterable = sortcheck.find();

        List<String>list= new ArrayList<>();
        for (Document count : findIterable) {
            Check = count.getString("Member_Name");
            list.add(Check);
        }
        Collections.sort(list);
        System.out.println(list);
        //will display a empty String if There's no any data to Sort
    }
}
package CourseworkTwo;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.Scanner;

public class AddMember {
    public static String AddCheck;

    public void addchoice() {
        Scanner select = new Scanner(System.in);
        System.out.println("Press and Enter Number 1 to Add a Student");
        System.out.println("Press and Enter Number 2 to Add Over 60 yrs ");
        System.out.println("Press and Enter Number 3 to Add a Default");
        System.out.println("------------------------------------------------");

        Integer memberChoice = select.nextInt();    //asking user to enter a number (1,2,3)

        if (memberChoice == 1) {
            AddMemberStudent addmember = new AddMemberStudent();
            addmember.student();
        }
        else if (memberChoice == 2) {
            AddMemberOverSixty addMemberOverSixty = new AddMemberOverSixty();
            addMemberOverSixty.overSixty();
        }
        else if (memberChoice==3) {
            AddDefault addDefault=new AddDefault();
            addDefault.memDefault();
        }
        else{
            System.out.println("Run Again and Please Enter a Valid Number! ");
        }
    }
    //creating a class of Student Data
    class AddMemberStudent extends AddMember {
        public void student() {
            Scanner id = new Scanner(System.in);
            System.out.print("Enter ID :");     //asking for the ID
            String Id = id.nextLine();
            Scanner name = new Scanner(System.in);
            System.out.print("Enter Name :");   //asking for the Name
            String Name = name.nextLine();
            Scanner scl = new Scanner(System.in);
            System.out.print("Enter School :");     //asking the school
            String schoolName = scl.nextLine();

            Boolean find = false;

            if (!Id.equals("") && (!Name.equals("")) && (!schoolName.equals(""))) { //when all the Data is inserted
                MongoDatabase maindatabase = DBConnection.connect();
                MongoCollection<Document> addcheck = maindatabase.getCollection("StudentMembers");
                FindIterable<Document> findIterable = addcheck.find();

                for (Document count : findIterable) {
                    AddCheck = count.getString("StudentMemberId");
                    if (Id.equals(AddCheck)) {
                        find = true;
                    }
                }
                if (find) {
                    System.out.print("Registered Student!");    //will print If same ID is Registered before
                } else {
                    Document document1 = new Document();
                    //inserting the Data into Columns
                    document1.put("StudentMemberId", Id);
                    document1.put("StudentMemberName", Name);
                    document1.put("StudentMemberSchool", schoolName);
                    addcheck.insertOne(document1);
                    System.out.println("Data Inserted");    //will print when all the data is Inserted

                }
            }
        }
    }

    class AddMemberOverSixty extends AddMember {
        public void overSixty() {
            Scanner sc = new Scanner(System.in);
            //asking and storing values of ID, Name and Age
            System.out.print("Enter the ID :");
            String Id = sc.nextLine();
            Scanner sc1 = new Scanner(System.in);
            System.out.print("Enter the Name :");
            String Name = sc1.nextLine();
            Scanner sc2 = new Scanner(System.in);
            System.out.print("Enter the Age :");
            String age = sc2.nextLine();

            Boolean find = false;

            if (!Id.equals("") && (!Name.equals("")) && (!age.equals(""))) {
                MongoDatabase maindatabase = DBConnection.connect();
                MongoCollection<Document> addcheck = maindatabase.getCollection("OverSixtyMembers");
                FindIterable<Document> findIterable = addcheck.find();

                for (Document count : findIterable) {
                    AddCheck = count.getString("Over_Sixty_Member_Id");
                    if (Id.equals(AddCheck)) {
                        find = true;
                    }
                }

                if (find) {
                    System.out.print("Registered Member!");  //will print If same ID is Registered before

                } else {
                    Document document1 = new Document();
                    //inserting values into columns
                    document1.put("Over_Sixty_Member_Id", Id);
                    document1.put("Over_Sixty_Member_Name", Name);
                    document1.put("Over_Sixty_Member_Age", age);
                    addcheck.insertOne(document1);
                    System.out.println("Data inserted");    //will print when all the data is Inserted
                }
            }
        }
    }

    class AddDefault extends AddMember {
        public void memDefault() {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter the ID :");
            String Id = sc.nextLine();
            Scanner sc1 = new Scanner(System.in);
            System.out.print("Enter the Name :");
            String Name = sc1.nextLine();
            Scanner sc2 = new Scanner(System.in);
            System.out.print("Enter the Age :");
            String age = sc2.nextLine();

            Boolean find = false;

            if (!Id.equals("") && (!Name.equals("")) && (!age.equals(""))) {
                MongoDatabase maindatabase = DBConnection.connect();
                MongoCollection<Document> addcheck = maindatabase.getCollection("DefaultMembers");
                FindIterable<Document> findIterable = addcheck.find();

                for (Document count : findIterable) {
                    AddCheck = count.getString("Member_Id");
                    if (Id.equals(AddCheck)) {
                        find = true;
                    }
                }
                if (find) {
                    System.out.print("Registered Member!");
                } else {
                    Document document1 = new Document();
                    //inserting values into columns
                    document1.put("Member_Id", Id);
                    document1.put("Member_Name", Name);
                    document1.put("Member_Age", age);
                    addcheck.insertOne(document1);
                    System.out.println("Data inserted");    //will print when all the data is Inserted
                }
            }
        }
    }
}

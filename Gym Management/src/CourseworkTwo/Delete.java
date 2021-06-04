package CourseworkTwo;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import java.util.Scanner;

public class Delete {

    public void deleteMember() {
        Scanner select = new Scanner(System.in);
        System.out.println("Press and Enter Number 1 to Delete a Student");
        System.out.println("Press and Enter Number 2 to Delete Over 60 yrs ");
        System.out.println("Press and Enter Number 3 to Delete a Default");
        System.out.println("------------------------------------------------");
        //setting all the classes for the Choice Numbers
        Integer memberChoice = select.nextInt();
        if (memberChoice == 1) {
            DeleteMemberStudent deleteMemberStudent=new DeleteMemberStudent();
            deleteMemberStudent.student();

        }
        else if (memberChoice==2) {
            DeleteMemberOvrSixty deleteMemberOvrSixty=new DeleteMemberOvrSixty();
            deleteMemberOvrSixty.ovrSixty();

        }
        else if (memberChoice==3) {
            DeleteMemberDefault deleteMemberDefault=new DeleteMemberDefault();
            deleteMemberDefault.defaultMem();
        }
        else{
            System.out.println("Run Again and Please Enter a Valid Number! ");
        }
    }
}

class DeleteMemberStudent extends AddMember {
    public static String DeleteCheck;

    public void student() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Type the ID that you want to Delete:");     //asking for the ID
        String Id = sc.nextLine();
        Boolean find = false;

        if (!Id.equals("")) {
            MongoDatabase maindatabase = DBConnection.connect();
            MongoCollection<Document> deletecheck = maindatabase.getCollection("StudentMembers");
            FindIterable<Document> findIterable = deletecheck.find();

            for (Document count : findIterable) {
                DeleteCheck = count.getString("StudentMemberId");
                if (Id.equals(DeleteCheck)) {  //taking the ID which is entered
                    find = true;
                }

            }
            if (!find) {
                System.out.print("Please Enter a Valid ID number");  //will print when the ID is not there
            } else {
                Document document = new Document();
                document.put("StudentMemberId", Id);
                deletecheck.deleteMany(document);
            }
        }
    }
}

class DeleteMemberOvrSixty extends AddMember {
    public static String DeleteCheck;

    public void ovrSixty() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Type the ID that you want to Delete:");     //asking for the ID
        String Id = sc.nextLine();
        Boolean find = false;

        if (!Id.equals("")) {
            MongoDatabase maindatabase = DBConnection.connect();
            MongoCollection<Document> deletecheck = maindatabase.getCollection("OverSixtyMembers");
            FindIterable<Document> findIterable = deletecheck.find();

            for (Document count : findIterable) {
                DeleteCheck = count.getString("OverSixtyMemberId");
                if (Id.equals(DeleteCheck)) {  //taking the ID which is entered
                    find = true;
                }

            }
            if (!find) {
                System.out.print("Please Enter a Valid ID number");
            } else {
                Document document = new Document();
                document.put("Over_Sixty_Member_Id", Id);
                deletecheck.deleteMany(document);
            }
        }
    }
}

class DeleteMemberDefault extends AddMember {
    public static String DeleteCheck;

    public void defaultMem() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Type the ID that you want to Delete:");     //asking for the ID
        String Id = sc.nextLine();
        Boolean find = false;

        if (!Id.equals("")) {
            MongoDatabase maindatabase = DBConnection.connect();
            MongoCollection<Document> deletecheck = maindatabase.getCollection("DefaultMembers");
            FindIterable<Document> findIterable = deletecheck.find();

            for (Document count : findIterable) {
                DeleteCheck = count.getString("DefaultId");
                if (Id.equals(DeleteCheck)) {  //taking the ID which is entered
                    find = true;
                }

            }
            if (!find) {
                System.out.print("Please Enter a Valid ID number");
            } else {
                Document document = new Document();
                document.put("Member_Id", Id);
                deletecheck.deleteMany(document);
            }
        }
    }
}




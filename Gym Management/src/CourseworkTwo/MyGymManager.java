package CourseworkTwo;

import javafx.application.Application;
import javafx.stage.Stage;
import java.util.Scanner;

public class MyGymManager extends Application {

    @Override
    public void start(Stage primaryStage) {
        Scanner sc = new Scanner(System.in);
        //welcome in Controller
        System.out.println("Enter Number 1 to Add a new Member");
        System.out.println("Enter Number 2 to Delete a Member");
        System.out.println("Enter Number 3 to Print all the Members");
        System.out.println("Enter Number 4 to Sort all the Members");
        System.out.println("Enter Number 5 to Open the GUI of Students");
        System.out.println("Enter Number 6 to Open the GUI of Over 60 Years Old Members");
        System.out.println("Enter Number 7 to Open the GUI of Default Members");

        System.out.println("------------------------------------------------");

        System.out.print("Type the Number Here :- ");

        String user = sc.nextLine();   //storing the Input of user

        if (user.equals("1")) {
            AddMember addlist = new AddMember();
            addlist.addchoice();
        }

        else if (user.equals("2")) {
            Delete deleteMember = new Delete();
            deleteMember.deleteMember();

        }
        else if (user.equals("3")) {
            PrintMembers printMembers = new PrintMembers();
            printMembers.printmem();
        }

        else if (user.equals("4")) {
            Sort sort = new Sort();
            sort.sort();

        }
        else if (user.equals("5")) {
           GUI gui=new GUI();
           gui.openView();

        }
        else if (user.equals("6")) {
            GuiTwo guiTwo=new GuiTwo();
            guiTwo.openViewTwo();
        }

        else if (user.equals("7")) {
            GuiThr guiThr=new GuiThr();
            guiThr.openViewThr();
        }
        else{
            System.out.println("Run again and Please Enter a Valid Number");    //will print when User not print a valid number
        }
    }
}
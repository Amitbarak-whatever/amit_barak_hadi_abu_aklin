package amit_barak_hadi_abu_aklin;

import amit_barak_hadi_abu_aklin.college.College;
import amit_barak_hadi_abu_aklin.college.Exceptions.CommitteeException;
import amit_barak_hadi_abu_aklin.college.Exceptions.DepartmentException;
import amit_barak_hadi_abu_aklin.college.Exceptions.LecturerException;

import java.util.Scanner;

// Amit Barak -322605080 ; Hadi Abu-Aklin - 211670641

public class Main {
//    private static final String[] MENU = {
//            "Exit Program",
//            "Add Lecturer",
//            "Add Committee",
//            "Add Division",
//            "Add lecturer to committee",
//            "Show average salary for ALL lecturers",
//            "Show average salary for lecturers in a specific division",
//            "Show all lecturers",
//            "Show all committees",
//
//    };
    private static final String[] MENU = {
            "Exit Program",                                      // 0
            "Add Lecturer",                                      // 1
            "Add Committee",                                     // 2
            "Assign lecturer to committee",                      // 3
            "Appoint new head of a committee",                   // 4
            "Remove lecturer from committee",                    // 5
            "Add Department",                                    // 6
            "Show average salary for all lecturers",             // 7
            "Show average salary for lecturers in a department", // 8
            "Show all lecturers",                                // 9
            "Show all committees",                               // 10
            "Assign lecturer to a department",                   // 11
            "Compare between Doctors/Professors",                // 12
            "Compare between Committees",                        // 13
            "Clone Committee"                                    // 14
    };
    private static Scanner s;
    private static boolean exceptionOccurred = false;
    private static void run() {

        System.out.println("enter college name:");
        String cName = s.nextLine();
        College c1 = new College(cName);

        int userChosen;
        do {
            exceptionOccurred = false;
            userChosen = showMenu(s);
            switch (userChosen) {
                case 0 -> System.out.println("goodbye");
                case 1 -> {s.nextLine();addLecturerMain(c1);}
                case 2 -> {s.nextLine();addCommitteeMain(c1);}
                case 3 -> {s.nextLine();lecturerToCommitteeMain(c1);}
                case 4 -> {s.nextLine();newCommitteeHeadMain(c1);}
                case 5 -> {s.nextLine();removeFromCommitteeMain(c1);}
                case 6 -> {s.nextLine();addDepartmentMain(c1);}
                case 7 -> showAvgPayAllMain(c1);
                case 8 -> {s.nextLine();showAvgPayDepartmentMain(c1);}
                case 9 -> lecturersAllStatsMain(c1);
                case 10 -> committeesAllStatsMain(c1);
                case 11 -> {s.nextLine();lecturerToDepartmentMain(c1);}
                case 12 -> { s.nextLine(); compareDoctorsMain(c1);}
                case 13 -> { s.nextLine(); compareCommitteesMain(c1); }
                case 14 -> { s.nextLine(); cloneCommitteeMain(c1); }
                default -> System.out.println("Unexpected value");
            }
        } while (userChosen != 0);
    }

    private static void removeFromCommitteeMain(College c1) {
        System.out.println("Enter committee's name:" );
        String committee = s.nextLine();
        System.out.println("Enter committee's lecturer:" );
        String lecturer = s.nextLine();
        try {
            College.removeLecturerFromCommitteeUser(c1, lecturer, committee);
        }catch (LecturerException | CommitteeException e){
            System.out.println(e.getMessage());
            exceptionOccurred = true;
        }finally {
            if (exceptionOccurred) {
                System.out.println("would you like to retry? yes/no");
                String redo = s.nextLine();
                switch (redo) {
                    case "yes" -> {exceptionOccurred = false;removeFromCommitteeMain(c1);return;}
                    case "no" -> {return;}
                    default -> System.out.println("invalid answer, returning to main menu");
                }
            }else{
                System.out.println("successful operation");}
        }
    }

    private static void addLecturerMain(College c1) {
        int numOfPapers = -1;
        String grantingBody = null;
        System.out.println("Enter lecturer's name: ");
        String name = s.nextLine();
        System.out.println("Enter lecturer's ID: ");
        String id = s.nextLine();
        String degree;
        do{
            System.out.println("Enter lecturer's degree: (FIRST,SECOND,DOC,PROF)");
            degree = s.nextLine().toUpperCase();
            if (!degree.equals("FIRST") && !degree.equals("SECOND") && !degree.equals("DOC") && !degree.equals("PROF")){
                System.out.println("this degree doesn't count");
            }
        }while(!degree.equals("FIRST") && !degree.equals("SECOND") && !degree.equals("DOC") && !degree.equals("PROF"));
        System.out.println("Enter lecturer's degree name:");
        String degreeName = s.nextLine();
        if(degree.equals("DOC") || degree.equals("PROF")){
            do{
                System.out.println("Enter how many papers he wrote:");
                numOfPapers = s.nextInt();
                if (numOfPapers<0){
                    System.out.println("can't have a negative number");
                }
            }while(numOfPapers<0);
        }
        if(degree.equals("PROF")){
            System.out.println("Enter lecturer's granting body's name: ");
            grantingBody = s.nextLine();
        }
        double salary;
        do{
            System.out.println("Enter lecturer's salary:");
            salary = s.nextInt();
            if (salary <= 0){
                System.out.println("invalid number please enter a new one");
            }
        }while (salary <= 0);
        s.nextLine();
        try{
            College.addLecturerUser(c1 ,name, id, degree, degreeName, salary, numOfPapers , grantingBody);
        }catch (LecturerException e){
            System.out.println(e.getMessage());
            exceptionOccurred = true;
        }finally {
            if(exceptionOccurred){
                System.out.println("would you like to retry? yes/no");
                String redo = s.nextLine();
                switch (redo) {
                    case "yes" -> {exceptionOccurred = false;addLecturerMain(c1);return;}
                    case "no" -> {return;}
                    default -> System.out.println("invalid answer, returning to main menu");
                }
            }else{
                System.out.println("successful operation");}
        }
    }

    private static void addCommitteeMain(College c1) {
        System.out.println("Enter committee's name:" );
        String name = s.nextLine();
        System.out.println("Enter committee's head:" );
        String head = s.nextLine();
        try{
        College.addCommitteeUser(c1 ,name, head);
        } catch (CommitteeException | LecturerException e){
            System.out.println(e.getMessage());
            exceptionOccurred = true;
        }finally {
            if (exceptionOccurred) {
                System.out.println("would you like to retry? yes/no");
                String redo = s.nextLine();
                switch (redo) {
                    case "yes" -> {exceptionOccurred = false;addCommitteeMain(c1);return;}
                    case "no" -> {return;}
                    default -> System.out.println("invalid answer, returning to main menu");
                }
            }else{
                System.out.println("successful operation");}
        }
    }

    private static void addDepartmentMain(College c1) {
        System.out.println("Enter department's name: ");
        String name = s.nextLine();
        int num;
        do{
            System.out.println("Enter number of students: ");
            num = s.nextInt();
            if (num < 0){
                System.out.println("invalid number please enter a new one");
            }
        }while (num < 0);
        try{
        College.addDepartmentUser(c1,name,num);
        }catch (DepartmentException e){
            System.out.println(e.getMessage());
            exceptionOccurred = true;
        }finally {
            if (exceptionOccurred){
                System.out.println("would you like to retry? yes/no");
                String redo = s.nextLine();
                switch (redo){
                    case "yes" ->{exceptionOccurred = false;addDepartmentMain(c1);return;}
                    case "no"-> {return;}
                    default -> System.out.println("invalid answer, returning to main menu");
                }
            }else{System.out.println("successful operation");}
        }
    }

    private static void lecturerToCommitteeMain(College c1) {
        System.out.println("Enter lecturer's name: " );
        String nameL = s.nextLine();
        System.out.println("Enter committee's name: " );
        String nameC = s.nextLine();
        try{
        College.lecturerToCommitteeUser(c1,nameL,nameC);}
        catch (LecturerException|CommitteeException e){
            System.out.println(e.getMessage());
            exceptionOccurred = true;
        }finally {
            if (exceptionOccurred) {
                System.out.println("would you like to retry? yes/no");
                String redo = s.nextLine();
                switch (redo) {
                    case "yes" -> {exceptionOccurred = false;lecturerToCommitteeMain(c1);return;}
                    case "no" -> {return;}
                    default -> System.out.println("invalid answer, returning to main menu");
                }
            }else{
                System.out.println("successful operation");}
        }
    }

    private static void lecturerToDepartmentMain(College c1) {
        System.out.println("Enter Lecturer's name: ");
        String lecturerName = s.nextLine();
        System.out.println("Enter Department's name: ");
        String departmentName = s.nextLine();
        try {
            College.lecturerToDepartmentUser(c1, lecturerName, departmentName);
        }catch (LecturerException | DepartmentException e){
            System.out.println(e.getMessage());
            exceptionOccurred = true;
        }finally {
            if (exceptionOccurred) {
                System.out.println("Would you like to retry? yes/no");
                String redo = s.nextLine();
                switch (redo.toLowerCase()) {
                    case "yes" -> {exceptionOccurred = false ;lecturerToDepartmentMain(c1); return;}
                    case "no" -> { return;}
                    default -> System.out.println("Invalid answer, returning to main menu.");
                }
            }else{
                System.out.println("successful operation");}
        }
    }

    private static void newCommitteeHeadMain(College c1) {
        System.out.println("Enter committee's name:");
        String committeeName = s.nextLine();
        System.out.println("Enter new head lecturer's name:");
        String lecturerName = s.nextLine();
        try{
            College.setNewCommitteeHeadUser(c1, committeeName, lecturerName);
        }catch (LecturerException | CommitteeException e){
            System.out.println(e.getMessage());
            exceptionOccurred = true;
        }finally {
            if (exceptionOccurred) {
                System.out.println("Would you like to retry? yes/no");
                String redo = s.nextLine();
                switch (redo.toLowerCase()) {
                    case "yes" -> {
                        exceptionOccurred = false;
                        newCommitteeHeadMain(c1);
                        return;
                    }
                    case "no" -> {
                        return;
                    }
                    default -> System.out.println("Invalid answer, returning to main menu.");
                }
            }
        }
    }

    private static void showAvgPayDepartmentMain(College c1) {
        System.out.println("which department do you want to check?");
        String department = s.nextLine();
        double res = 0 ;
        try{
        res = College.showAvgPayDepartmentUser(c1, department);
        System.out.println("average department's pay is:" + res );
        }catch (DepartmentException e){
            System.out.println(e.getMessage());
            exceptionOccurred = true;
        }finally {
            if (exceptionOccurred) {
                System.out.println("Would you like to retry? yes/no");
                String redo = s.nextLine();
                switch (redo.toLowerCase()) {
                    case "yes" -> {exceptionOccurred = false;showAvgPayDepartmentMain(c1);return;}
                    case "no" -> {return;}
                    default -> System.out.println("Invalid answer, returning to main menu.");
                }
            }
        }
    }

    private static void showAvgPayAllMain(College c1) {
        double res = College.avgPayAllUser(c1);
        if (res == -1){
            System.out.println("College " + c1.getName() + " doesn't have any lecturers");
            return;
        }
        System.out.println("average salary: " + res);

    }

    private static void committeesAllStatsMain(College c1) {
        System.out.println(College.committeesAllStatsUser(c1));
    }

    private static void lecturersAllStatsMain(College c1) {
        System.out.println(College.lecturersAllStatsUser(c1));
    }

    private static void compareDoctorsMain(College c1){
        String res ="";
        System.out.println("enter doctor's name:");
        String d1 = s.nextLine();
        System.out.println("enter doctor's name:");
        String d2 = s.nextLine();
        try{
           res = College.compareDoctorsUser(c1,d1,d2);
           System.out.println(res);
        }catch (LecturerException e){
            System.out.println(e.getMessage());
            exceptionOccurred = true;
        }finally {
            if(exceptionOccurred){
                System.out.println("would you like to retry? yes/no");
                String redo = s.nextLine();
                switch (redo) {
                    case "yes" -> {exceptionOccurred = false;compareDoctorsMain(c1);return;}
                    case "no" -> {return;}
                    default -> System.out.println("invalid answer, returning to main menu");
                }
            }else{
                System.out.println("successful operation");}
        }
    }

    private static void cloneCommitteeMain(College c1) {
        System.out.println("Enter name of committee to clone:");
        String name = s.nextLine();
        try {
            College.cloneCommitteeUser(c1, name);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            exceptionOccurred = true;
        }finally {
            if (exceptionOccurred) {
                System.out.println("Would you like to retry? yes/no");
                String redo = s.nextLine();
                switch (redo.toLowerCase()) {
                    case "yes" -> {exceptionOccurred = false ;cloneCommitteeMain(c1); return;}
                    case "no" -> { return;}
                    default -> System.out.println("Invalid answer, returning to main menu.");
                }
            }else{
                System.out.println("Successful operation");
            }
        }


    }

    private static void compareCommitteesMain(College c1) {
        System.out.println("Enter name of first committee:");
        String name1 = s.nextLine();
        System.out.println("Enter name of second committee:");
        String name2 = s.nextLine();
        int choice;
        do{
        System.out.println("Compare by:");
        System.out.println("1. Number of lecturers");
        System.out.println("2. Total number of papers by doctors");
        choice = s.nextInt();
        s.nextLine();
        }while (choice <1 || choice >2);
        String res = "";
        try{
        res = College.compareCommitteesUser(c1,name1, name2, choice);}
        catch (CommitteeException e){
            System.out.println(e.getMessage());
            exceptionOccurred = true;
        }finally {
            if (exceptionOccurred) {
                System.out.println("Would you like to retry? yes/no");
                String redo = s.nextLine();
                switch (redo.toLowerCase()) {
                    case "yes" -> {exceptionOccurred = false ;compareCommitteesMain(c1); return;}
                    case "no" -> { return;}
                    default -> System.out.println("Invalid answer, returning to main menu.");
                }
            }else{
                System.out.println(res);
            }
        }
    }

    private static int showMenu(Scanner s) {
        System.out.println("\n====== Menu =======");
        for (int i = 0; i < MENU.length; i++) {
            System.out.println(i + ". " + MENU[i]);
        }
        System.out.println("Please enter your choice: ");
        return s.nextInt();
    }


    public static void main(String[] args) {
        s = new Scanner(System.in);
        run();
        s.close();
    }
    // Amit Barak -322605080 ; Hadi Abu-Aklin - 211670641
}




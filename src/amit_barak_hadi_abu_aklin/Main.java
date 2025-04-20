package amit_barak_hadi_abu_aklin;

import amit_barak_hadi_abu_aklin.college.College;

import java.util.Scanner;

// Amit Barak -322605080 ; Hadi Abu-Aklin - 211670641

public class Main {
    private static final String[] MENU = {
            "Exit Program",
            "Add Lecturer",
            "Add Committee",
            "Add Division",
            "Add lecturer to committee",
            "Show average salary for ALL lecturers",
            "Show average salary for lecturers in a specific division",
            "Show all lecturers",
            "Show all committees"
    };
    private static Scanner s;

    private static void run() {

        System.out.println("enter college name:");
        String cName = s.nextLine();
        College c1 = new College(cName);

        int userChosen;
        do {
            userChosen = showMenu(s);
            switch (userChosen) {
                case 0 -> System.out.println("goodbye");
                case 1 -> addLecturerMain();
                case 2 -> addCommitteeMain();
                case 3 -> lecturerToCommittee();
                case 4 -> newCommitteeHead();
                case 5 -> removeFromCommittee();
                case 6 -> addDepartmentMain();
                case 7 -> showAvgPayAll();
                case 8 -> showAvgPayDepartment();
                case 9 -> lecturersAllStats();
                case 10 -> committeesAllStats();
                case 11 -> lecturerToDepartment();
                default -> System.out.println("Unexpected value");
            }
        } while (userChosen != 0);
    }

    private static void addLecturerMain() {
        s.nextLine();
        System.out.println("Enter lecturer's name: ");
        String name = s.nextLine();
        System.out.println("Enter lecturer's ID: ");
        String id = s.nextLine();
        System.out.println("Enter lecturer's degree: (FIRST,SECOND,DOC,PROF)");
        String degree = s.nextLine();
        System.out.println("Enter lecturer's name of degree:");
        String degreeName = s.nextLine();
        System.out.println("Enter lecturer's salary:");
        double salary = s.nextDouble();
        s.nextLine();
        College.addLecturer(name, id, degree, degreeName, salary);
    }
    private static void addCommitteeMain() {
        s.nextLine();
        System.out.println("Enter committee's name:  " );
        String name = s.nextLine();
        System.out.println("Enter committee's head:  " );
        String head = s.nextLine();
        College.addCommittee(name,head);
    }

    private static void addDepartmentMain() {
        s.nextLine();
        System.out.println("Enter department's name: ");
        String name = s.nextLine();
        System.out.println("Enter number of students: ");
        int num = s.nextInt();
        s.nextLine();
        College.addDepartment(name,num);}

    private static void lecturerToCommittee() {
        s.nextLine();
        System.out.println("Enter lecturer's name: " );
        String nameL = s.nextLine();
        System.out.println("Enter committee's name: " );
        String nameC = s.nextLine();
    }

    private static void showAvgPayDepartment() {
        System.out.println("which department do you want to check?");
        String name = s.nextLine();
        College.checkDepartment(name);
        if (!checkDepartment){
            System.out.println("department doesn't exist");
        }
        else {
            System.out.println("department's average salary: " + College.departmentPay(name));
        }
    }

    private static void showAvgPayAll() {
        System.out.println("average salary: " + College.avgPayAll());
    }

    private static int showMenu(Scanner s) {
        System.out.println("\n====== Menu =======");
        for (int i = 0; i < MENU.length; i++) {
            System.out.println(i + ". " + MENU[i]);
        }
        System.out.println("Please enter your choice : ");
        return s.nextInt();
    }


    public static void main(String[] args) {
        s = new Scanner(System.in);
        run();
        s.close();
    }
    // Amit Barak -322605080 ; Hadi Abu-Aklin - 211670641
}


//        if (isExist(name,lecturers,numOfLecturers)){
//        System.out.println(name + " already exist...\nwould you like to add a different name? yes/no");
//String redo = s.next();
//            switch (redo) {
//        case "yes" -> {
//addLecturerMain();
//                    return;
//                            }
//                            case "no" -> {return;}
//default -> System.out.println("what? im returning you to the menu");
//            }
//                    }
//                    if (numOfLecturers == lecturers.length){
//lecturers = copy(lecturers, numOfLecturers == 0 ? 2: numOfLecturers * 2);
//        }
//lecturers[numOfLecturers++] = name;
//    }
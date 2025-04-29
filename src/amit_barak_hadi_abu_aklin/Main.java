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
                case 1 -> addLecturerMain(c1);
                case 2 -> addCommitteeMain(c1);
                case 3 -> lecturerToCommitteeMain(c1);
                case 4 -> newCommitteeHeadMain(c1);
                case 5 -> removeFromCommitteeMain(c1);
                case 6 -> addDepartmentMain(c1);
                case 7 -> showAvgPayAll(c1);
                case 8 -> showAvgPayDepartmentMain(c1);
                case 9 -> lecturersAllStats(c1);
                case 10 -> committeesAllStats(c1);
                case 11 -> lecturerToDepartment(c1);
                default -> System.out.println("Unexpected value");
            }
        } while (userChosen != 0);
    }

    private static void removeFromCommitteeMain(College c1) {
        s.nextLine();
        System.out.println("Enter committee's name:" );
        String committee = s.nextLine();
        System.out.println("Enter committee's head:" );
        String lecturer = s.nextLine();
        ActionStatus res = College.removeLecturerFromCommitteeUser(c1 , lecturer, committee);
        System.out.println(res);
        if (res != ActionStatus.SUCCESS) {
            System.out.println("would you like to retry? yes/no");
            String redo = s.nextLine();
            switch (redo) {
                case "yes" -> {removeFromCommitteeMain(c1);return;}
                case "no" -> {return;}
                default -> System.out.println("invalid answer, returning to main menu");
            }
        }
    }

    private static void addLecturerMain(College c1) {
        s.nextLine();
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
        System.out.println("Enter lecturer's salary:");
        double salary = s.nextDouble();
        s.nextLine();
        ActionStatus res = College.addLecturerUser(c1 ,name, id, degree, degreeName, salary);
        System.out.println(res);
        if (res != ActionStatus.SUCCESS) {
            System.out.println("would you like to retry? yes/no");
            String redo = s.nextLine();
            switch (redo) {
                case "yes" -> {addLecturerMain(c1);return;}
                case "no" -> {return;}
                default -> System.out.println("invalid answer, returning to main menu");
            }
        }
    }

    private static void addCommitteeMain(College c1) {
        s.nextLine();
        System.out.println("Enter committee's name:" );
        String name = s.nextLine();
        System.out.println("Enter committee's head:" );
        String head = s.nextLine();
        ActionStatus res = College.addCommitteeUser(c1 ,name, head);
        System.out.println(res);
        if (res != ActionStatus.SUCCESS) {
            System.out.println("would you like to retry? yes/no");
            String redo = s.nextLine();
            switch (redo) {
                case "yes" -> {addCommitteeMain(c1);return;}
                case "no" -> {return;}
                default -> System.out.println("invalid answer, returning to main menu");
            }
        }
    }

    private static void addDepartmentMain(College c1) {
        s.nextLine();
        System.out.println("Enter department's name: ");
        String name = s.nextLine();
        System.out.println("Enter number of students: ");
        int num = s.nextInt();
        s.nextLine();
        ActionStatus res = College.addDepartmentUser(c1,name,num);
        System.out.println(res);
        if (res != ActionStatus.SUCCESS){
            System.out.println("would you like to retry? yes/no");
            String redo = s.nextLine();
            switch (redo){
                case "yes" ->{addDepartmentMain(c1);return;}
                case "no"-> {return;}
                default -> System.out.println("invalid answer, returning to main menu");
            }
        }
    }

    private static void lecturerToCommitteeMain(College c1) {
        s.nextLine();
        System.out.println("Enter lecturer's name: " );
        String nameL = s.nextLine();
        System.out.println("Enter committee's name: " );
        String nameC = s.nextLine();
        ActionStatus res = College.lecturerToCommitteeUser(c1,nameL,nameC);
        if (res != ActionStatus.SUCCESS) {
            System.out.println("would you like to retry? yes/no");
            String redo = s.nextLine();
            switch (redo) {
                case "yes" -> {lecturerToCommitteeMain(c1);return;}
                case "no" -> {return;}
                default -> System.out.println("invalid answer, returning to main menu");
            }
        }
    }

    private static void newCommitteeHeadMain(College c1) {
        s.nextLine();
        System.out.println("Enter committee's name:");
        String committeeName = s.nextLine();
        System.out.println("Enter new head lecturer's name:");
        String lecturerName = s.nextLine();
        ActionStatus res = College.setNewCommitteeHeadUser(c1, committeeName, lecturerName);
        System.out.println(res);
        if (res != ActionStatus.SUCCESS) {
            System.out.println("Would you like to retry? yes/no");
            String redo = s.nextLine();
            switch (redo.toLowerCase()) {
                case "yes" -> {
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

    private static void showAvgPayDepartmentMain(College c1) {
        String redo = null;
        System.out.println("which department do you want to check?");
        String department = s.nextLine();
        double res = College.showAvgPayDepartmentUser(c1, department);
        if (res == -1.00 ){
            System.out.println(department+" not found \nWould you like to retry? yes/no");
            redo = s.nextLine();
        }
        if (res == -2.00){
            System.out.println(department+" doesn't have any lecturers ");
        }
        switch (redo) {
            case "yes" -> {
                showAvgPayDepartmentMain(c1);
                return;
            }
            case "no" -> {
                return;
            }
            case null -> {
                System.out.println(department + " salary average is: " + res);
            }
            default -> System.out.println("Invalid answer, returning to main menu.");
        }
    }

    private static void showAvgPayAll(College c1) {
        double res = College.avgPayAllUser(c1);
        if (res == -1){
            System.out.println("College" + c1.getName() + " doesn't have any lecturers");
            return;
        }
        System.out.println("average salary: " + res);

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
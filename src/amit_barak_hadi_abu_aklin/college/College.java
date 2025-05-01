package amit_barak_hadi_abu_aklin.college;

import amit_barak_hadi_abu_aklin.ActionStatus;
import amit_barak_hadi_abu_aklin.Utils;

public class College {
    private String name;
    private int numOfLecturers;
    private int numOfCommittees;
    private int numOfDepartments;
    private Lecturer[] allLecturers ;
    private Department[] allDepartments ;
    private Committee[] allCommittees ;

    public College(String name) {
        this.name = name;
        this.allLecturers = new Lecturer[0];
        this.allDepartments = new Department[0];
        this.allCommittees = new Committee[0];
    }

    public static ActionStatus addDepartmentUser(College college,String name, int num) {
        Department d1 = new Department(name , num);
        return college.addDepartmentCollege(d1);

    }

    public static ActionStatus lecturerToCommitteeUser(College college, String nameOfLecturer, String nameOfCommittee) {
        return college.lecturerToCommitteeCollege(nameOfLecturer, nameOfCommittee);
    }

    public static double avgPayAllUser(College c1) {
        return c1.avgPayAllCollege();
    }

    private double avgPayAllCollege() {
        double res = 0.0 ;
        if (numOfLecturers == 0){
            return -1.00;
        }
        for ( int i = 0 ; i < numOfLecturers ; i++){
            res += allLecturers[i].getSalary();
        }
        return res/numOfLecturers;
    }

    public static double showAvgPayDepartmentUser(College college,String department) {
        return college.showAvgPayDepartmentCollege(department);
    }

    private double showAvgPayDepartmentCollege(String strDepartment) {
        Department department = findDepartmentByName(strDepartment);
        if (department == null){
            return -1.00;
        }
        Lecturer[] depLecturers = department.getLecturers();
        int numOfLecturers = department.getNumOfLecturers();
        double res = 0.0 ;
        if (numOfLecturers == 0){
            return -2;
        }
        for (int i = 0 ; i < numOfLecturers; i ++){
            res += depLecturers[i].getSalary();
        }
        return res/numOfLecturers;
    }

    private ActionStatus lecturerToCommitteeCollege(String nameOfLecturer, String nameOfCommittee){
        Lecturer l1 = findLecturerByName(nameOfLecturer);
        Committee c1 = findCommitteeByName(nameOfCommittee);
        if (l1 == null && c1 == null) {
            return ActionStatus.L_C_NOT_EXIST;
        }
        if (l1 == null) {
            return ActionStatus.LECTURER_NOT_EXIST;
        }
        if (c1 == null) {
            return ActionStatus.COMMITTEE_NOT_EXIST;
        }
        c1.addLecturerToCommitteeCollege(l1);
        return ActionStatus.SUCCESS;
    }

    private ActionStatus addDepartmentCollege(Department department) {
        if(Utils.isExist(allDepartments , numOfDepartments, department)){
            return ActionStatus.DEPARTMENT_EXIST;
        }
        if (numOfDepartments == allDepartments.length){
            allDepartments = (Department[]) Utils.resizeArr(allDepartments);
        }
        allDepartments[numOfDepartments++] = department;
        return ActionStatus.SUCCESS;
    }

    public static ActionStatus addLecturerUser(College college, String name, String id, String degree, String degreeName, double salary) {
        Lecturer l1 = new Lecturer( salary , degree, degreeName , id ,name );
        return college.addLecturerCollege(l1);
    }

    private ActionStatus addLecturerCollege(Lecturer lecturer) {
        if(Utils.isExist(allLecturers , numOfLecturers, lecturer)){
            return ActionStatus.LECTURER_EXIST;
        }
        if (numOfLecturers == allLecturers.length){
            allLecturers = (Lecturer[]) Utils.resizeArr(allLecturers);
        }
        allLecturers[numOfLecturers++] = lecturer;
        return ActionStatus.SUCCESS;
    }

    public static ActionStatus addCommitteeUser(College college, String name, String headOf) {
        Committee c1 = new Committee(name,college.findLecturerByName(headOf));
        return college.addCommitteeCollege(c1);
    }

    private ActionStatus addCommitteeCollege(Committee committee) {
        if(Utils.isExist(allCommittees , numOfCommittees, committee)){
            return ActionStatus.COMMITTEE_EXIST;
        }
        if (committee.getHead() == null) {
            return ActionStatus.LECTURER_NOT_EXIST;
        }
        Degree headsDegree = committee.getHead().getDegree();
        if ( headsDegree != Degree.DOC && headsDegree != Degree.PROF){
            return ActionStatus.LECTURER_NOT_QUALIFIED;
        }
        if (numOfCommittees == allCommittees.length){
            allCommittees = (Committee[]) Utils.resizeArr(allCommittees);
        }
        allCommittees[numOfCommittees++] = committee;
        return ActionStatus.SUCCESS;
    }

    public static ActionStatus setNewCommitteeHeadUser(College college,String committeeName, String lecturerName) {
        return  college.setNewCommitteeHeadCollege(committeeName, lecturerName);
    }

    private ActionStatus setNewCommitteeHeadCollege(String committeeName, String lecturerName) {
        Lecturer selectedLecturer = findLecturerByName(lecturerName);
        Committee selectedCommittee = findCommitteeByName(committeeName);
        if (selectedLecturer == null && selectedCommittee == null) {
            return ActionStatus.L_C_NOT_EXIST;
        }
        if (selectedCommittee == null) {
            return ActionStatus.COMMITTEE_NOT_EXIST;
        }
        if (selectedLecturer == null) {
            return ActionStatus.LECTURER_NOT_EXIST;
        }
        return selectedCommittee.setHeadOf(selectedLecturer);
    }

    public static ActionStatus removeLecturerFromCommitteeUser(College college, String lecturer, String committee) {
        return college.removeLecturerFromCommitteeCollege(lecturer , committee);
    }

    public ActionStatus removeLecturerFromCommitteeCollege( String committeeName, String lecturerName) {
        Committee selectedCommittee = findCommitteeByName(committeeName);
        Lecturer selectedLecturer = findLecturerByName(lecturerName);
        if (selectedLecturer == null && selectedCommittee == null) {
            return ActionStatus.L_C_NOT_EXIST;
        }
        if (selectedCommittee == null) {
            return ActionStatus.COMMITTEE_NOT_EXIST;
        }
        if (selectedLecturer == null) {
            return ActionStatus.LECTURER_NOT_EXIST;
        }
        return selectedCommittee.removeFromCommittee(selectedLecturer);
    }

    public static String committeesAllStatsUser(College college) {
        return college.committeesAllStatsCollege();
    }

    private String committeesAllStatsCollege() {
        if (numOfCommittees == 0) {
            return "No committees in the college yet.";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numOfCommittees; i++) {
            sb.append(allCommittees[i].toString()).append("\n");
        }
        return sb.toString();
    }

    public static String lecturersAllStatsUser(College college) {
        return college.lecturersAllStatsCollege();
    }

    private String lecturersAllStatsCollege() {
        if (numOfLecturers == 0) {
            return "No lecturers in the college yet.";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numOfLecturers; i++) {
            sb.append(allLecturers[i].toString()).append("\n");
        }
        return sb.toString();
    }

    public static ActionStatus lecturerToDepartmentUser(College college, String lecturerName, String departmentName) {
        return college.lecturerToDepartmentCollege(lecturerName, departmentName);
    }

    private ActionStatus lecturerToDepartmentCollege(String lecturerName, String departmentName) {
        Lecturer lecturer = findLecturerByName(lecturerName);
        Department department = findDepartmentByName(departmentName);

        if (lecturer == null && department == null) {
            return ActionStatus.L_C_NOT_EXIST;
        }
        if (lecturer == null) {
            return ActionStatus.LECTURER_NOT_EXIST;
        }
        if (department == null) {
            return ActionStatus.DEPARTMENT_NOT_EXIST;
        }

        boolean success = department.addLecturerToDepartment(lecturer);
        if (!success) {
            return ActionStatus.LECTURER_EXIST;
        }
        return ActionStatus.SUCCESS;
    }

    private Lecturer findLecturerByName(String name) {
        for (int i = 0; i < numOfLecturers; i++) {
            if (allLecturers[i].getName().equals(name)) {
                return allLecturers[i];
            }
        }
        return null;
    }

    private Committee findCommitteeByName(String name) {
        for (int i = 0; i < numOfCommittees; i++) {
            if (allCommittees[i].getName().equals(name)) {
                return allCommittees[i];
            }
        }
        return null;
    }

    private Department findDepartmentByName(String name) {
        for (int i = 0; i < numOfDepartments; i++) {
            if (allDepartments[i].getName().equals(name)) {
                return allDepartments[i];
            }
        }
        return null;
    }

    public String getName() {
        return name;
    }




//    private static void showLecturersAll() {
//        System.out.print("[ ");
//        for (int i = 0; i < numOfLecturers; i++) {
//            if (i == numOfLecturers - 1){
//                System.out.print(lecturers[i]);
//            } else{
//                System.out.print(lecturers[i] + ", ");
//            }
//        }
//        System.out.println("]");
//    }
//
//    private static void showCommitteesAll() {
//        System.out.print("[ ");
//        for (int i = 0; i < numOfCommittees; i++) {
//            if (i == numOfCommittees - 1){
//                System.out.print(committees[i]);
//            } else{
//                System.out.print(committees[i] + ", ");
//            }
//        }
//        System.out.println("]");
//    }

}

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
        if ( headsDegree == Degree.FIRST || headsDegree == Degree.SECOND){
            return ActionStatus.LECTURER_NOT_QUALIFIED;
        }
        if (numOfCommittees == allCommittees.length){
            allCommittees = (Committee[]) Utils.resizeArr(allCommittees);
        }
        allCommittees[numOfCommittees++] = committee;
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

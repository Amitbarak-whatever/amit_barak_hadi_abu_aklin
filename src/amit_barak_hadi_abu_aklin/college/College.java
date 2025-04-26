package amit_barak_hadi_abu_aklin.college;

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

//    private static boolean isExist(String name,Object[] array, int numOf) {
//        for (int i = 0; i < numOf; i++) {
//            if (valueOf(array[i].getName).equals(name)){
//                return true;
//            }
//        }
//        return false;
//    }

    public static void addDepartment(String name, int num) {

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

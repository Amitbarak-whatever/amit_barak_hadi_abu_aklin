package amit_barak_hadi_abu_aklin.college;

import java.util.Arrays;

class Department {
    private String name;
    private Lecturer[] lecturers;
    private int numOfLecturers;
    private int numOfStudents;

    public Department(String name, int numOfStudents) {
        this.name = name;
        this.lecturers = new Lecturer[0];
        this.numOfStudents = numOfStudents;
    }

    public boolean addLecturerToDepartment(Lecturer lecturer) {
        if (lecturer.getDepartment() != null) {
            return false;
        }
        if (numOfLecturers == lecturers.length) {
            lecturers = Arrays.copyOf(lecturers, lecturers.length == 0 ? 2 : lecturers.length * 2);
        }
        lecturers[numOfLecturers++] = lecturer;
        lecturer.setDepartment(this);
        return true;
    }

    public String getName() {
        return name;
    }

    public int getNumOfLecturers() {
        return numOfLecturers;
    }

    public Lecturer[] getLecturers() {
        return lecturers;
    }

    public String compareByDepartmentCount(Department d1, Department d2) {
        int d1num = d1.getNumOfLecturers();
        int d2num = d2.getNumOfLecturers();
        if (d1num == d2num){
            return "both have the same amount of lecturers";
        }
        return  d1num > d2num ? d1.getName() + "has more lecturers" : d2.getName() + "has more lecturers";
    }

    public String compareByDepartmentPapers(Department d1 , Department d2 ) {
        int d1numof = d1.numOfStudents;
        int d2numof = d2.numOfStudents;
        int sum1 = 0;
        int sum2 = 0;
        for (int i = 0 ; i<d1numof ; i++){
            if (d1.lecturers[i] instanceof Doctor){
                sum1 += ((Doctor) d1.lecturers[i]).getNumOfPapers();
            }
            i++;
        }
        for (int j = 0 ; j<d2numof ; j++){
            if (d2.lecturers[j] instanceof Doctor){
                sum2 += ((Doctor) d2.lecturers[j]).getNumOfPapers();
            }
            j++;
        }
        if (sum1 == sum2){
            return "both have the same amount of papers";
        }
        return  sum1 > sum2 ? d1.getName() + "has more papers" : d2.getName() + "has more papers";
    }




//    public boolean removeFromDepartment(Lecturer lecturer){
//        for (Lecturer name : lecturers ){
//            if (lecturer == name){
//                name = null;
//            }
//        }
//    }
//
//    @Override
//    public String toString() {
//        StringBuilder sb = new StringBuilder();
//        sb.append("Department Name: ").append(name).append("\n");
//        sb.append("Number of Students: ").append(numOfStudents).append("\n");
//        sb.append("Lecturers in Department: \n");
//
//        if (numOfLecturers == 0) {
//            sb.append(" No lecturers assigned yet. \n");
//        } else {
//            for (int i = 0; i < numOfLecturers; i++) {
//                if (lecturers[i] != null) {
//                    sb.append("- ").append(lecturers[i].getName()).append("\n");
//                }
//            }
//        }
//        return sb.toString();
//    }


}

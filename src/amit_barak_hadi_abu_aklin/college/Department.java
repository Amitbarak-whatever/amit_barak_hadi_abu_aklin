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
        setNumOfStudents(numOfStudents);
    }

    public boolean setNumOfStudents(int numOfStudents) {
        if (0< numOfStudents) {
            this.numOfStudents = numOfStudents;
            return true;
        }
        return false;
    }
    public boolean addLecturerToDepartment(Lecturer lecturer) {
        if (lecturer.getDepartment() != null) {
            return false;
        }
        if (numOfLecturers == lecturers.length) {
            lecturers = Arrays.copyOf(lecturers, lecturers.length == 0 ? 2 : lecturers.length * 2);
        }
        lecturers[numOfLecturers++] = lecturer;
        lecturer.setDepartment(this.department);
        return true;
    }
    // TODO ask pini how to send the the department to lecturer

//    public boolean removeFromDepartment(Lecturer lecturer){
//        for (Lecturer name : lecturers ){
//            if (lecturer == name){
//                name = null;
//            }
//        }
//    }
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

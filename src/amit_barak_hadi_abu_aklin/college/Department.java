package amit_barak_hadi_abu_aklin.college;

import amit_barak_hadi_abu_aklin.college.Exceptions.LecturerException;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

class Department implements Serializable {
    private String name;
    private ArrayList<Lecturer> lecturers;
    private int numOfStudents;
    @Serial
    private static final long serialVersionUID = 1L ;

    public Department(String name, int numOfStudents) {
        this.name = name;
        this.lecturers = new ArrayList<>();
        this.numOfStudents = numOfStudents;
    }

    public void addLecturerToDepartment(Lecturer lecturer) throws LecturerException {
        if (lecturer.getDepartment() != null) {
           throw new LecturerException("lecturer already in a department");
        }
        this.lecturers.add(lecturer);
        lecturer.setDepartment(this);
    }

    public String getName() {
        return name;
    }

    public ArrayList<Lecturer> getLecturers() {
        return lecturers;
    }



    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Department Name: ").append(name).append("\n");
        sb.append("Number of Students: ").append(numOfStudents).append("\n");
        sb.append("Lecturers in Department: \n");
        if (lecturers.isEmpty()) {
            sb.append("not in any committees");
        } else {
            sb.append("[");
            for (int i = 0; i < lecturers.size(); i++) {
                sb.append(lecturers.get(i).getName());
                if (i != lecturers.size() - 1) {
                    sb.append(", ");
                }
            }
            sb.append("]");
        }
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj){
            return true;
        }
        if (obj == null){
            return false;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        Department other = (Department) obj;
        if (!other.name.equals(this.name)){
            return false;
        }
        return true;
    }
}

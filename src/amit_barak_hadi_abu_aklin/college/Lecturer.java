package amit_barak_hadi_abu_aklin.college;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;

class Lecturer implements Serializable {
    protected double salary;
    protected String name;
    protected String id;
    protected Degree degree;
    protected String degreeName;
    protected Department department;
    protected ArrayList<Committee> committees;
    @Serial
    private static final long serialVersionUID = 1L ;

    public Lecturer(double salary,String degree,String degreeName, String id, String name) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.degreeName = degreeName;
        this.committees = new ArrayList<>();
        setDegree(degree);
    }

    public String getName() {
        return name;
    }

    public Degree getDegree() {
        return degree;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public ArrayList<Committee> getCommittees() {
        return committees;
    }

    public double getSalary() {
        return salary;
    }

    public void setDegree(String degreeFromUser) {
        Degree[] degrees = Degree.values();
        for (Degree deg : degrees ){
            if (deg.name().equals(degreeFromUser)){
                this.degree = deg;
            }
        }
    }


    public void addCommitteeToLecturer(Committee committee) {
        committees.add(committee);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(name).append('-').append(id).append(":\n")
                .append("degree: ").append(degree).append(" in ").append(degreeName).append('\n')
                .append("salary: ").append(salary).append('\n')
                .append("department: ")
                .append(department != null ? department + "\n" : "not in a department\n")
                .append("committees: ");
        if (committees.isEmpty()) {
            sb.append("not in any committees");
        } else {
            sb.append("[");
            for (int i = 0; i < committees.size(); i++) {
                sb.append(committees.get(i).getName());
                if (i != committees.size() - 1) {
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
        Lecturer other = (Lecturer) obj;
        if (!other.name.equals(this.name)){
            return false;
        }
        return true;
    }


}

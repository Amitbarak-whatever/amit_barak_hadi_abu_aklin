package amit_barak_hadi_abu_aklin.college;

import amit_barak_hadi_abu_aklin.Utils;

class Lecturer {
    private double salary;
    private String name;
    private String id;
    private Degree degree;
    private String degreeName;
    private Department department;
    private Committee[] committees;
    private int numOfCommittees;
    public Lecturer(double salary,String degree,String degreeName, String id, String name) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.degreeName = degreeName;
        this.committees = new Committee[0];
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

    public int getNumOfCommittees() {
        return numOfCommittees;
    }

    public Committee[] getCommittees() {
        return committees;
    }

    public void setNumOfCommittees(int numOfCommittees) {
        this.numOfCommittees = numOfCommittees;
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
        if (numOfCommittees == committees.length){
            committees = (Committee[]) Utils.resizeArr(committees);
        }
        committees[numOfCommittees++] = committee;
    }


}

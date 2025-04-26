package amit_barak_hadi_abu_aklin.college;

class Lecturer {

    public enum Degree{FIRST,SECOND,DOC,PROF}
    private double salary;
    private String name;
    private String id;
    private Degree degree;
    private Department department;
    private Committee[] committees;


    public Lecturer(double salary, Department department, String degree, String id, String name) {
        this.department = department;
        this.id = id;
        this.name = name;
        this.salary = salary;
        setDegree(degree);
        this.committees = new Committee[0];
    }

    public double getSalary() {
        return salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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



    public void setDegree(String degreeFromUser) {
        Degree[] degrees = Degree.values();
        for (Degree deg : degrees ){
            if (deg.name().equals(degreeFromUser)){
                this.degree = deg;
            }
        }

    }


}

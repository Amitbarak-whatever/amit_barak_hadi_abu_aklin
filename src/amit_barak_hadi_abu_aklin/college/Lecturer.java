package amit_barak_hadi_abu_aklin.college;

class Lecturer {
    public enum Degree{FIRST,SECOND,DOC,PROF}
    private double salary;
    private String name;
    private String id;
    private Degree degree;
    private Department department;
    private Committees[] committees;

    public Lecturer(double salary, Department department, String degree, String id, String name) {
        this.department = department;
        this.id = id;
        this.name = name;
        setSalary(salary);
        setDegree(degree);
    }

    public double getSalary() {
        return salary;
    }

    public boolean setSalary(double salary) {
        if (0<salary){
            this.salary = salary;
            return true;
        }
        return false;
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

    public boolean setDegree(String degreeFromUser) {
        Degree[] degrees = Degree.values();
        for (Degree deg : degrees ){
            if (deg.name().equals(degreeFromUser)){
                this.degree = deg;
                return true;
            }
        }
        return false;
    }


}

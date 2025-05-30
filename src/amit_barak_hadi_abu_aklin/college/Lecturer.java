package amit_barak_hadi_abu_aklin.college;

class Lecturer {
    protected double salary;
    protected String name;
    protected String id;
    protected Degree degree;
    protected String degreeName;
    protected Department department;
    protected Committee[] committees;
    protected int numOfCommittees;

    public Lecturer(double salary,String degree,String degreeName, String id, String name) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.degreeName = degreeName;
        this.committees = new Committee[0];
        setDegree(degree);
    }
    public Lecturer(double salary,String degreeName, String id, String name) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.degreeName = degreeName;
        this.committees = new Committee[0];
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
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(name).append('-').append(id).append(":\n")
                .append("degree: ").append(degree).append(" in ").append(degreeName).append('\n')
                .append("salary: ").append(salary).append('\n')
                .append("department: ")
                .append(department != null ? department + "\n" : "not in a department\n")
                .append("committees: ");
        if (numOfCommittees == 0) {
            sb.append("not in any committees");
        } else {
            sb.append("[");
            for (int i = 0; i < numOfCommittees; i++) {
                sb.append(committees[i].getName());
                if (i != numOfCommittees - 1) {
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

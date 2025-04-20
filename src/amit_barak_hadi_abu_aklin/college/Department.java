package amit_barak_hadi_abu_aklin.college;
class Department {
    private String name;
    private Lecturer[] lecturers;
    private int numOfLectures;
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

}

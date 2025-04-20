package amit_barak_hadi_abu_aklin.college;

class Committees {
    private String name;
    private Lecturer headOf;
    private Lecturer[] lecturers;
    private int numOfLecturers;

    public Committees(String name, Lecturer headOf) {
        this.name = name;
        this.lecturers = new Lecturer[0];

        setHeadOf(headOf);
    }

    public boolean setHeadOf(Lecturer headOf) {
        if (headOf.getDegree() == Lecturer.Degree.PROF) {
            this.headOf = headOf;
            return true;
        }
        return false;
    }

    public void addLecturerToCommittee(Lecturer lecturer,Committees committee){
        committee.lecturers[numOfLecturers] = lecturer;

    }
//    private static void lecturerToCommittee() {
//        s.nextLine();
//        System.out.println("Enter lecturer's name: " );
//        String nameL = s.nextLine();
//        System.out.println("Enter committee's name: " );
//        String nameC = s.nextLine();
//        if (!isExist(nameC,committees,numOfCommittees) || !isExist(nameL,lecturers,numOfLecturers)){
//            System.out.println("one of inputs is not in the system please try again");
//        }
//    }


}

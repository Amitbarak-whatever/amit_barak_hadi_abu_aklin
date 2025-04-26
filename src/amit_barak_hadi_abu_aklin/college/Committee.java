package amit_barak_hadi_abu_aklin.college;

import java.util.Arrays;

class Committee {
    private String name;
    private Lecturer headOf;
    private Lecturer[] lecturers;
    private int numOfLecturers;

    public Committee(String name, Lecturer headOf) {
        this.name = name;
        this.lecturers = new Lecturer[0];
        setHeadOf(headOf);
    }

    public boolean setHeadOf(Lecturer headOf) {
        if (headOf.getDegree() == Lecturer.Degree.PROF || headOf.getDegree() == Lecturer.Degree.DOC) {
            this.headOf = headOf;
            return true;
        }
        return false;
    }

    public void addLecturerToCommittee(Lecturer lecturer){
        if (numOfLecturers == lecturers.length){
            lecturers = Arrays.copyOf(lecturers,lecturers.length == 0 ? 2 : lecturers.length * 2);
        }
        lecturers[numOfLecturers++] = lecturer;
    }
    public void removeFromCommittee(Lecturer lecturer){
        for (Lecturer name : lecturers ){
            if (lecturer == name){
                name = null;
            }
        }
    }
    //TODO Remove the committee form the lecturer also
    //TODO ask pini if it is ok


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Committee Name: ").append(name).append("\n");
        sb.append("Head of Committee: ").append(headOf.getName()).append("\n");
        sb.append("Lecturers in Committee: ").append("\n");
        if (numOfLecturers == 0) {
            sb.append(" No lecturers assigned yet.");
        } else {
            for (int i = 0; i < numOfLecturers; i++) {
                if (lecturers[i] != null){
                    sb.append(lecturers[i].getName()).append("\n");
                }
            }
        }
        return sb.toString();
    }
}

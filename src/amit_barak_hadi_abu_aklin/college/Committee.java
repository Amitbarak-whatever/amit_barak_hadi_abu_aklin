package amit_barak_hadi_abu_aklin.college;

import amit_barak_hadi_abu_aklin.college.Exceptions.CommitteeException;
import amit_barak_hadi_abu_aklin.college.Exceptions.LecturerException;

import java.util.ArrayList;

class Committee implements Cloneable {
    private String name;
    private Lecturer head;
    private ArrayList<Lecturer> lecturers;
    private Degree degree;

    public Committee(String name, Lecturer head , String degree) {
        this.name = name;
        this.lecturers = new ArrayList<>();
        this.head = head;
        setDegree(degree);
    }
    public Committee(String name, Lecturer head , Degree degree) {
        this.name = name;
        this.lecturers = new ArrayList<>();
        this.head = head;
        this.degree = degree;
    }

    public void setHeadOf(Lecturer newHead) throws LecturerException{
        if (newHead.getDegree() == Degree.PROF || newHead.getDegree() == Degree.DOC) {
            if (Utils.isExist(lecturers , newHead)){
                this.lecturers.remove(newHead);
            }
            this.head = newHead;
        }else{
            throw new LecturerException("lecturer isn't qualified to be committee's head");
        }
    }

    public void removeFromCommittee(Lecturer lecturer) throws LecturerException {
        if (this.lecturers.remove(lecturer)) {
            lecturer.committees.remove(this);
        }else throw new LecturerException("lecturer is not in the committee");
    }

    public String getName() {
        return name;
    }

    public void addLecturerToCommitteeCollege(Lecturer lecturer) throws CommitteeException {
        if(this.degree == lecturer.degree || (this.degree == Degree.FIRST && lecturer.degree == Degree.SECOND) || (this.degree == Degree.SECOND && lecturer.degree == Degree.FIRST) ){
        lecturer.addCommitteeToLecturer(this);
        }
        else{
            throw new CommitteeException("Lecturer degree in not compatible with the committee");
        }

    }

    public Lecturer getHead() {
        return head;
    }

    public ArrayList<Lecturer> getLecturers() {
        return lecturers;
    }

    public void setDegree(String degreeFromUser) {
        Degree[] degrees = Degree.values();
        for (Degree deg : degrees ){
            if (deg.name().equals(degreeFromUser)){
                this.degree = deg;
            }
        }
    }

    @Override
    public Committee clone() throws CloneNotSupportedException {
        Committee committee = (Committee) super.clone();
        committee.name = "new-" + name;
        committee.lecturers = new ArrayList<>(lecturers);
        return committee;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Committee Name: ").append(name).append('\n')
        .append("Head of Committee: ").append(head.getName()).append('\n')
        .append("Lecturers in Committee: ");
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
        Committee other = (Committee) obj;
        if (!other.name.equals(this.name)){
            return false;
        }
        return true;
    }
}

package amit_barak_hadi_abu_aklin.college;

import amit_barak_hadi_abu_aklin.ActionStatus;
import amit_barak_hadi_abu_aklin.college.Exceptions.LecturerException;

class Committee implements Cloneable {
    private String name;
    private Lecturer head;
    private Lecturer[] lecturers;
    private int numOfLecturers;

    public Committee(String name, Lecturer head) {
        this.name = name;
        this.lecturers = new Lecturer[0];
        this.head = head;
    }

    public void setHeadOf(Lecturer newHead) throws LecturerException{
        if (newHead.getDegree() == Degree.PROF || newHead.getDegree() == Degree.DOC) {
            if (Utils.isExist(lecturers , numOfLecturers, newHead)){
                this.removeFromCommittee(newHead);
            }
            this.head = newHead;
        }else{
            throw new LecturerException("lecturer isn't qualified to be committee's head");
        }
    }


    public void removeFromCommittee(Lecturer lecturer) throws LecturerException {
        int oldNum = numOfLecturers;
        numOfLecturers = Utils.removeFromArray(lecturers, lecturer, numOfLecturers);
        if (oldNum == numOfLecturers) {
           throw new LecturerException("lecturer is not in the committee");
        }
        lecturer.setNumOfCommittees(Utils.removeFromArray(lecturer.getCommittees(), this, lecturer.getNumOfCommittees()));
    }

    public String getName() {
        return name;
    }

    public void addLecturerToCommitteeCollege(Lecturer lecturer){
        if (numOfLecturers == lecturers.length){
            lecturers = (Lecturer[]) Utils.resizeArr(lecturers);
        }
        lecturers[numOfLecturers++] = lecturer;
        lecturer.addCommitteeToLecturer(this);
    }

    public Committee cloneCommittee() {
        Committee clone = new Committee("new-" + this.name, this.head);
        for (int i = 0; i < this.numOfLecturers; i++) {
            clone.addLecturerToCommitteeCollege(this.lecturers[i]);
        }
        return clone;
    }


    public Lecturer getHead() {
        return head;
    }

    public Lecturer[] getLecturers() {
        return lecturers;
    }

    public int getNumOfLecturers() {
        return numOfLecturers;
    }

    @Override
    public Committee clone() throws CloneNotSupportedException {
        Committee committee = (Committee) super.clone();
        committee.name = "new-" + name;
        committee.lecturers = lecturers.clone();
        return committee;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Committee Name: ").append(name).append('\n')
        .append("Head of Committee: ").append(head.getName()).append('\n')
        .append("Lecturers in Committee: ");
        if (numOfLecturers == 0) {
            sb.append("No lecturers assigned yet.");
        } else {
            sb.append("[");
            for (int i = 0; i < numOfLecturers; i++) {
                sb.append(lecturers[i].getName());
                if (i != numOfLecturers - 1) {
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

package amit_barak_hadi_abu_aklin.college;

import amit_barak_hadi_abu_aklin.ActionStatus;

class Committee {
    private String name;
    private Lecturer head;
    private Lecturer[] lecturers;
    private int numOfLecturers;

    public Committee(String name, Lecturer head) {
        this.name = name;
        this.lecturers = new Lecturer[0];
        this.head = head;
    }

    public ActionStatus setHeadOf(Lecturer newHead) {
        if (newHead.getDegree() == Degree.PROF || newHead.getDegree() == Degree.DOC) {
            if (Utils.isExist(lecturers , numOfLecturers, newHead)){
                this.removeFromCommittee(newHead);
            }
            this.head = newHead;
            return ActionStatus.SUCCESS;
        }
        return ActionStatus.LECTURER_NOT_QUALIFIED;
    }


    public ActionStatus removeFromCommittee(Lecturer lecturer){
        int oldNum = numOfLecturers;
        numOfLecturers = Utils.removeFromArray(lecturers, lecturer, numOfLecturers);
        if (oldNum == numOfLecturers) {
            return ActionStatus.LECTURER_NOT_EXIST_IN_COMM;
        }
        lecturer.setNumOfCommittees(Utils.removeFromArray(lecturer.getCommittees(), this, lecturer.getNumOfCommittees()));
        return ActionStatus.SUCCESS;
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

    public Lecturer getHead() {
        return head;
    }

    public Committee cloneCommittee() {
        Committee clone = new Committee("new-" + this.name, this.head);
        for (int i = 0; i < this.numOfLecturers; i++) {
            clone.addLecturerToCommitteeCollege(this.lecturers[i]);
        }
        return clone;
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
}

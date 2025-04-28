package amit_barak_hadi_abu_aklin.college;

import amit_barak_hadi_abu_aklin.ActionStatus;
import amit_barak_hadi_abu_aklin.Utils;

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
            this.head = newHead;
            return ActionStatus.LECTURER_NOT_QUALIFIED;
        }
        return ActionStatus.SUCCESS;
    }


    public void removeFromCommittee(Lecturer lecturer){
        Utils.removeFromArray(this.lecturers, lecturer , this.numOfLecturers);
        Utils.removeFromArray(lecturer.getCommittees(), this ,lecturer.getNumOfCommittees());
        //TODO add a use from actionstatus and do a change to numOf to both lecturer and committee
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



    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Committee Name: ").append(name).append("\n");
        sb.append("Head of Committee: ").append(head.getName()).append("\n");
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

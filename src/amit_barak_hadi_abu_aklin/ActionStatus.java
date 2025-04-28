package amit_barak_hadi_abu_aklin;

public enum ActionStatus {
    SUCCESS("Success!"),
    LECTURER_NOT_EXIST_IN_COMM("Lecturer does not exist in committee."),
    LECTURER_NOT_EXIST_IN_DEP("Lecturer does not exist in department."),
    LECTURER_NOT_EXIST("Lecturer does not."),
    LECTURER_CANT_BE_HEADOF("lecturer can't be head of department"),
    DEPARTMENT_NOT_EXIST("Department does not exist."),
    COMMITTEE_NOT_EXIST("Committee does not exist."),
    LECTURER_EXIST("lecturer already exists."),
    COMMITTEE_EXIST("committee already exists."),
    DEPARTMENT_EXIST("department already exists."),
    LECTURER_NOT_QUALIFIED("lecturer isn't qualified to be committee's head");




    private final String message;

    private ActionStatus(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}


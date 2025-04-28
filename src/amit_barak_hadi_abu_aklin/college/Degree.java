package amit_barak_hadi_abu_aklin.college;

enum Degree {
    FIRST("bachelor's degree"),
    SECOND("master's degree"),
    DOC("doctor"),
    PROF("professor");

    private final String message;

    private Degree(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}

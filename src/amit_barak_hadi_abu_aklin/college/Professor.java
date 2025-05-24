package amit_barak_hadi_abu_aklin.college;

class Professor extends Doctor {
    private String grantingBody;
    public Professor(double salary, String degreeName, String id, String name, int numOfPapers ,String grantingBody) {
        super(salary, degreeName, id, name, numOfPapers);
        this.grantingBody = grantingBody;
    }
}

package amit_barak_hadi_abu_aklin.college;

class Professor extends Doctor {
    private String grantingBody;
    public Professor(double salary,String degree ,String degreeName, String id, String name, int numOfPapers ,String grantingBody) {
        super(salary,degree,degreeName, id, name, numOfPapers);
        this.grantingBody = grantingBody;
    }

    @Override
    public String toString() {
        return super.toString() +  '\n' +  "granting body: " +grantingBody;
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)){
            return false;
        }
        if (getClass() != obj.getClass()){
            return false;
        }
        Professor other = (Professor) obj;
        if (!grantingBody.equals(other.grantingBody)){
            return false;
        }
        return true;
    }
}

package amit_barak_hadi_abu_aklin.college;

class Doctor extends Lecturer {
    private int numOfPapers;

    public Doctor(double salary, String degreeName, String id, String name ,int numOfPapers ) {
        super(salary,degreeName, id, name);
        this.numOfPapers = numOfPapers;
    }

    public int getNumOfPapers() {
        return numOfPapers;
    }

    public String compareNumOfPapers(Doctor doc1 , Doctor doc2){
        int doc1Papers = doc1.getNumOfPapers();
        int doc2Papers = doc2.getNumOfPapers();
        if (doc1Papers == doc2Papers){
            return "both have the same amount of papers";
        }
        return  doc1Papers > doc2Papers ? doc1.getName() + "has more papers" : doc2.getName() + "has more papers";
    }
}

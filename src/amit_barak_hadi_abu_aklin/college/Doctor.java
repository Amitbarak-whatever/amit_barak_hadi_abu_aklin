package amit_barak_hadi_abu_aklin.college;

class Doctor extends Lecturer implements Comparable<Doctor> {
    protected int numOfPapers;

    public Doctor(double salary, String degree , String degreeName, String id, String name ,int numOfPapers ) {
        super(salary,degree,degreeName, id, name);
        this.numOfPapers = numOfPapers;
    }

    public int getNumOfPapers() {
        return numOfPapers;
    }

    @Override
    public int compareTo(Doctor d1) {
        return this.numOfPapers - d1.numOfPapers;
    }

    @Override
    public String toString() {
        return super.toString() + '\n' + "number of papers written: " + numOfPapers;
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)){
            return false;
        }
        if (getClass() != obj.getClass()){
            return false;
        }
        Doctor other = (Doctor) obj;
        if (numOfPapers != other.numOfPapers){
            return false;
        }
        return true;
    }
}

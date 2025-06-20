package amit_barak_hadi_abu_aklin.college;


import amit_barak_hadi_abu_aklin.college.Exceptions.CommitteeException;
import amit_barak_hadi_abu_aklin.college.Exceptions.DepartmentException;
import amit_barak_hadi_abu_aklin.college.Exceptions.LecturerException;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;


public class College implements Serializable {
    private String name;
    private ArrayList<Lecturer> allLecturers ;
    private ArrayList<Department> allDepartments ;
    private ArrayList<Committee> allCommittees ;
    @Serial
    private static final long serialVersionUID = 1L ;

    public College(String name) {
        this.name = name;
        this.allLecturers = new ArrayList<>();
        this.allDepartments = new ArrayList<>();
        this.allCommittees = new ArrayList<>();
    }

    public static void addDepartmentUser(College college,String name, int num) throws DepartmentException {
        Department d1 = new Department(name , num);
        college.addDepartmentCollege(d1);

    }

    public static void lecturerToCommitteeUser(College college, String nameOfLecturer, String nameOfCommittee) throws CommitteeException ,LecturerException{
        college.lecturerToCommitteeCollege(nameOfLecturer, nameOfCommittee);
    }

    public static double avgPayAllUser(College c1) {
        return c1.avgPayAllCollege();
    }

    private double avgPayAllCollege() {
        if (allLecturers.isEmpty()) {
            return -1.0;
        }
        double totalSalary = 0.0;
        for (Lecturer lecturer : allLecturers) {
            totalSalary += lecturer.getSalary();
        }
        return totalSalary / allLecturers.size();
    }


    public static double showAvgPayDepartmentUser(College college,String department) throws DepartmentException{
        return college.showAvgPayDepartmentCollege(department);
    }

    private double showAvgPayDepartmentCollege(String strDepartment) throws DepartmentException {
        Department department = findDepartmentByName(strDepartment);
        if (department == null) {
            throw new DepartmentException("Department doesn't exist");
        }

        ArrayList<Lecturer> depLecturers = department.getLecturers();

        if (depLecturers.isEmpty()) {
            return 0;
        }

        double totalSalary = 0.0;
        for (Lecturer lecturer : depLecturers) {
            totalSalary += lecturer.getSalary();
        }

        return totalSalary / depLecturers.size();
    }

    private void lecturerToCommitteeCollege(String nameOfLecturer, String nameOfCommittee) throws CommitteeException , LecturerException{
        Lecturer l1 = findLecturerByName(nameOfLecturer);
        Committee c1 = findCommitteeByName(nameOfCommittee);
        if (l1 == null && c1 == null) {
            throw new CommitteeException("both lecturer and committee doesn't exist");
        }
        if (l1 == null) {
            throw new LecturerException("lecturer doesn't exist");
        }
        if (c1 == null) {
            throw new CommitteeException("committee doesn't exist");
        }
        if (l1.equals(c1.getHead())){
            throw new LecturerException("lecturer is already head of committee");
        }
        c1.addLecturerToCommitteeCollege(l1);
    }

    private void addDepartmentCollege(Department department) throws DepartmentException{
        if(Utils.isExist(allDepartments, department)){
            throw new DepartmentException("department with this name already exists");
        }
        allDepartments.add(department);
    }

    public static void addLecturerUser(College college, String name, String id, String degree, String degreeName, double salary ,int numOfPapers , String grantingBody) throws LecturerException {
        Lecturer l1;
        if (grantingBody != null){
             l1 = new Professor(salary , degree, degreeName , id ,name , numOfPapers , grantingBody);
        }else{
        if (0<numOfPapers){
             l1 = new Doctor(salary , degree, degreeName , id ,name , numOfPapers);
        }else{l1 = new Lecturer( salary , degree, degreeName , id ,name );
        }}
        college.addLecturerCollege(l1);
    }

    private void addLecturerCollege(Lecturer lecturer) throws LecturerException{
        if(Utils.isExist(allLecturers , lecturer)){
            throw new LecturerException("Lecturer with this name already exists");
        }
        allLecturers.add(lecturer);
    }

    public static void addCommitteeUser(College college, String name, String headOf , String degree) throws CommitteeException , LecturerException{
        Committee c1 = new Committee(name,college.findLecturerByName(headOf), degree);
        college.addCommitteeCollege(c1);
    }

    private void addCommitteeCollege(Committee committee) throws CommitteeException , LecturerException {
        if(Utils.isExist(allCommittees ,committee)){
           throw new CommitteeException("committee already exist");
        }
        if (committee.getHead() == null) {
            throw new LecturerException("lecturer doesn't exist");
        }
        Degree headsDegree = committee.getHead().getDegree();
        if ( headsDegree != Degree.DOC && headsDegree != Degree.PROF){
            throw new LecturerException("lecturer isn't qualified to be committee's head");
        }
        allCommittees.add(committee);
    }

    public static void setNewCommitteeHeadUser(College college,String committeeName, String lecturerName) throws LecturerException , CommitteeException{
        college.setNewCommitteeHeadCollege(committeeName, lecturerName);
    }

    private void setNewCommitteeHeadCollege(String committeeName, String lecturerName) throws LecturerException , CommitteeException{
        Lecturer selectedLecturer = findLecturerByName(lecturerName);
        Committee selectedCommittee = findCommitteeByName(committeeName);
        if (selectedLecturer == null && selectedCommittee == null) {
            throw new CommitteeException("lecturer and committee doesn't exist");
        }
        if (selectedCommittee == null) {
            throw new CommitteeException("committee doesn't exist");
        }
        if (selectedLecturer == null) {
            throw new LecturerException("lecturer doesn't exist");
        }
        selectedCommittee.setHeadOf(selectedLecturer);
    }

    public static void removeLecturerFromCommitteeUser(College college, String lecturer, String committee) throws LecturerException, CommitteeException{
        college.removeLecturerFromCommitteeCollege(committee , lecturer);
    }

    public void removeLecturerFromCommitteeCollege( String committeeName, String lecturerName) throws LecturerException, CommitteeException {
        Committee selectedCommittee = findCommitteeByName(committeeName);
        Lecturer selectedLecturer = findLecturerByName(lecturerName);
        if (selectedLecturer == null && selectedCommittee == null) {
            throw new CommitteeException("lecturer and committee doesn't exist");
        }
        if (selectedCommittee == null) {
            throw new CommitteeException("committee doesn't exist");
        }
        if (selectedLecturer == null) {
            throw new LecturerException("lecturer doesn't exist");
        }
        selectedCommittee.removeFromCommittee(selectedLecturer);
    }

    public static String committeesAllStatsUser(College college) {
        return college.committeesAllStatsCollege();
    }

    private String committeesAllStatsCollege() {
        if (allCommittees.isEmpty()) {
            return "No committees in the college yet.";
        }
        StringBuilder sb = new StringBuilder();
        for (Committee committee : allCommittees) {
            sb.append(committee.toString()).append("\n");
        }
        return sb.toString();
    }

    public static String lecturersAllStatsUser(College college) {
        return college.lecturersAllStatsCollege();
    }

    private String lecturersAllStatsCollege() {
        if (allCommittees.isEmpty()) {
            return "No lecturers in the college yet.";
        }
        StringBuilder sb = new StringBuilder();
        for (Committee committee : allCommittees) {
            sb.append(committee.toString()).append("\n");
        }
        return sb.toString();
    }

    public static void lecturerToDepartmentUser(College college, String lecturerName, String departmentName) throws DepartmentException , LecturerException{
        college.lecturerToDepartmentCollege(lecturerName, departmentName);
    }

    private void lecturerToDepartmentCollege(String lecturerName, String departmentName) throws DepartmentException , LecturerException{
        Lecturer lecturer = findLecturerByName(lecturerName);
        Department department = findDepartmentByName(departmentName);

        if (lecturer == null && department == null) {
            throw new DepartmentException("lecturer and department doesn't exist");
        }
        if (lecturer == null) {
            throw new LecturerException("lecturer doesn't exist");
        }
        if (department == null) {
            throw new DepartmentException("department doesn't exist");
        }
        department.addLecturerToDepartment(lecturer);
    }

    public static void cloneCommitteeUser(College c1, String nameOfCommittee) throws LecturerException, CommitteeException, CloneNotSupportedException {
        c1.cloneCommitteeCollege(nameOfCommittee);
    }

    private void cloneCommitteeCollege(String nameOfCommittee) throws CommitteeException, CloneNotSupportedException, LecturerException {
        Committee original = findCommitteeByName(nameOfCommittee);
        if (original == null) {
            throw new CommitteeException("committee doesn't exist");
        }
        Committee clone = original.clone();
        this.addCommitteeCollege(clone);
    }

    public static String compareDoctorsUser(College c1 , String d1 , String d2) throws  LecturerException {
       return c1.compareDoctorsCollege(d1,d2);
    }

    private String compareDoctorsCollege(String d1, String d2) throws  LecturerException {
        Lecturer doc1 = findLecturerByName(d1), doc2 = findLecturerByName(d2);
        if (doc1 == null || doc2 == null) {
            throw new LecturerException("one or both do not exist");
        }
        int res;
        if (doc1 instanceof Doctor && doc2 instanceof Doctor) {
            res = ((Doctor) doc1).compareTo((Doctor) doc2);
        } else {
            throw new LecturerException("one of them or both are not doctors of professors");
        }
        if (res == 0) return "Both lads have the same number of papers.";
        return res > 0 ? doc1.name + " has more papers." : doc2.name + " has more papers.";
    }


    public static String compareCommitteesUser(College c1,String name1, String name2, int mode) throws CommitteeException{
        return c1.compareCommitteesCollege(name1,name2,mode);
    }

    private String compareCommitteesCollege(String name1, String name2, int mode) throws CommitteeException {
        Committee c1 = findCommitteeByName(name1);
        Committee c2 = findCommitteeByName(name2);
        if (c1 == null || c2 == null) {
            throw new CommitteeException("one or both of the committees doesn't exist");
        }
        int res = 0;
        switch (mode) {
            case 1->{
                CompareCommitteeByPapers comparatorP = new CompareCommitteeByPapers();
                res =  comparatorP.compare(c1, c2);
            }
            case 2 ->{
                CompareCommitteeByNumOfLecturers comparatorL = new CompareCommitteeByNumOfLecturers();
                res = comparatorL.compare(c1, c2);
            }
        }
        if (res == 0) return "Both committees have the same number of papers.";
        return res > 0 ? c1.getName() + " has more papers." : c2.getName() + " has more papers.";
    }

    private Lecturer findLecturerByName(String name) {
        for (Lecturer lecturer : allLecturers) {
            if (lecturer.getName().equals(name)) {
                return lecturer;
            }
        }
        return null;
    }

    private Committee findCommitteeByName(String name) {
        for (Committee committee : allCommittees) {
            if (committee.getName().equals(name)) {
                return committee;
            }
        }
        return null;
    }

    private Department findDepartmentByName(String name) {
        for (Department department : allDepartments) {
            if (department.getName().equals(name)) {
                return department;
            }
        }
        return null;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("College Name: ").append(name).append("\n");

        // Lecturers
        sb.append("Lecturers:\n");
        if (allLecturers.isEmpty()) {
            sb.append("No lecturers assigned yet.");
        } else {
            sb.append("[");
            for (int i = 0; i < allLecturers.size(); i++) {
                sb.append(allLecturers.get(i).getName());
                if (i != allLecturers.size() - 1) {
                    sb.append(", ");
                }
            }
            sb.append("]");
        }
        sb.append("\n");

        // Departments
        sb.append("Departments:\n");
        if (allDepartments.isEmpty()) {
            sb.append("No departments assigned yet.");
        } else {
            sb.append("[");
            for (int i = 0; i < allDepartments.size(); i++) {
                sb.append(allDepartments.get(i).getName());
                if (i != allDepartments.size() - 1) {
                    sb.append(", ");
                }
            }
            sb.append("]");
        }
        sb.append("\n");

        // Committees
        sb.append("Committees:\n");
        if (allCommittees.isEmpty()) {
            sb.append("No committees assigned yet.");
        } else {
            sb.append("[");
            for (int i = 0; i < allCommittees.size(); i++) {
                sb.append(allCommittees.get(i).getName());
                if (i != allCommittees.size() - 1) {
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
        College other = (College) obj;
        if (!other.name.equals(this.name)){
            return false;
        }
        return true;
    }



}

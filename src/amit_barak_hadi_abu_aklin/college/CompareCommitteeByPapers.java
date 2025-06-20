package amit_barak_hadi_abu_aklin.college;

import java.util.ArrayList;
import java.util.Comparator;

class CompareCommitteeByPapers implements Comparator<Committee> {
    @Override
    public int compare(Committee c1, Committee c2) {
        ArrayList<Lecturer> lec1 = c1.getLecturers();
        ArrayList<Lecturer> lec2 = c2.getLecturers();
        int sum1 = 0, sum2 = 0;
        for (Lecturer l : lec1) {
            if (l instanceof Doctor) {
                sum1 += ((Doctor) l).getNumOfPapers();
            }
        }
        for (Lecturer l : lec2) {
            if (l instanceof Doctor) {
                sum2 += ((Doctor) l).getNumOfPapers();
            }
        }
        return sum1 - sum2;
    }
}

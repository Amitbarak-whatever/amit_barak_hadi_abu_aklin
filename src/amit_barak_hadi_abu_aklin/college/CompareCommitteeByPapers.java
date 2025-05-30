package amit_barak_hadi_abu_aklin.college;

import java.util.Comparator;

class CompareCommitteeByPapers implements Comparator<Committee> {
    @Override
    public  int compare(Committee c1, Committee c2) {
        Lecturer[] lec1 = c1.getLecturers(),lec2 = c2.getLecturers();
        int numOf1 = c1.getNumOfLecturers(),numOf2 = c2.getNumOfLecturers();
        int sum1 = 0, sum2 = 0;
        for (int i = 0; i < numOf1; i++) {
            if (lec1[i] instanceof Doctor) {
                sum1 += ((Doctor) lec1[i]).getNumOfPapers();
            }
        }
        for (int i = 0; i < numOf2; i++) {
            if (lec2[i] instanceof Doctor) {
                sum2 += ((Doctor) lec2[i]).getNumOfPapers();
            }
        }
        return sum1 - sum2;
    }
}

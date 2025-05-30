package amit_barak_hadi_abu_aklin.college;

import java.util.Comparator;

class CompareCommitteeByNumOfLecturers implements Comparator<Committee> {
    @Override
    public int compare(Committee c1, Committee c2) {
        return c1.getNumOfLecturers() - c2.getNumOfLecturers();
    }
}

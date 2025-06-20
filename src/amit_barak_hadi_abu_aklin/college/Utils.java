package amit_barak_hadi_abu_aklin.college;

import java.util.ArrayList;

public class Utils {
    public static boolean isExist(ArrayList<?> list,Object item) {
        if (item instanceof Lecturer) {
            for (Object obj : list) {
                if (obj instanceof Lecturer) {
                    if (((Lecturer) obj).getName().equals(((Lecturer) item).getName())) {
                        return true;
                    }
                }
            }
        } else if (item instanceof Committee) {
            for (Object obj : list) {
                if (obj instanceof Committee) {
                    if (((Committee) obj).getName().equals(((Committee) item).getName())) {
                        return true;
                    }
                }
            }
        } else if (item instanceof Department) {
            for (Object obj : list) {
                if (obj instanceof Department) {
                    if (((Department) obj).getName().equals(((Department) item).getName())) {
                        return true;
                    }
                }
            }
        }
        return false;
        }




}

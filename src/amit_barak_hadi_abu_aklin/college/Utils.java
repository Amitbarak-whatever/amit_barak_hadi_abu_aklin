package amit_barak_hadi_abu_aklin.college;

import java.util.Arrays;

public class Utils {
    public static Object[] resizeArr(Object[] arr) {
        return Arrays.copyOf(arr, arr.length == 0 ? 2 : arr.length * 2);
    }

    public static boolean isExist(Object[] arr, int numOfItems, Object item) {
        if (arr instanceof Lecturer[] lecturers){
            for (int i = 0; i < numOfItems; i++) {
                if (lecturers[i].getName().equals(((Lecturer) item).getName())) {
                    return true;
                }
            }
            return false;
        }
        if (arr instanceof Committee[] committee){
            for (int i = 0; i < numOfItems; i++) {
                if (committee[i].getName().equals(((Committee) item).getName())) {
                    return true;
                }
            }
            return false;
        }
        if (arr instanceof Department[] departments){
            for (int i = 0; i < numOfItems; i++) {
                if (departments[i].getName().equals(((Department) item).getName())) {
                    return true;
                }
            }
            return false;
        }
        return false;
        }



    public static int removeFromArray(Object[] removeFrom, Object toRemove, int numOf) {
        for (int i = 0; i < numOf; i++) {
            if (removeFrom[i] == toRemove) {
                for (int j = i; j < numOf - 1; j++) {
                    removeFrom[j] = removeFrom[j + 1];
                }
                removeFrom[numOf - 1] = null;
                return numOf - 1;
            }
        }
        return numOf;
    }

    public static String arrayPrint(Object[] arr, int numInArr){
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < numInArr; i++) {
            sb.append(arr[i]);
            if (i != numInArr - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

//    public static ActionStatus findByName(Object[] arr, String toFind, int numOf){
//        Class g = Object[].getClass();
//        for(int i = 0 ; i < numOf ; i++){
//            if (g[i].getNameGeneric().equals
//        }
//    }
    //TODO maybe add a generic verision of findByName
}

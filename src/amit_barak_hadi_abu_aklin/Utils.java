package amit_barak_hadi_abu_aklin;

import java.util.Arrays;

public class Utils {
    public static Object[] resizeArr(Object[] arr){
        return Arrays.copyOf(arr,arr.length == 0 ? 2 : arr.length * 2);
    }

    public static boolean isExist(Object[] arr, int numOfItems, Object item) {
        for (int i = 0 ; i < numOfItems ; i++) {
            if(arr[i].equals(item)){
                return true;
            }
        }
        return false;
    }

    public static void removeFromArray(Object[] removeFrom, Object toRemove, int numOf){
        for (int i=0 ; i < numOf ; i++)
            if (removeFrom[i] == toRemove) {
                for (int j=i ;j < numOf -1 ; j++ ){
                    if (removeFrom[j] == null){
                        break;
                    }
                    removeFrom[j] = removeFrom[j+1];
                }
                removeFrom[numOf-1] = null;
                numOf--;
            }
    }
    //TODO ADD ACTIONSTATUC AS RETURN
//    public static ActionStatus findByName(Object[] arr, String toFind, int numOf){
//        Class g = Object[].getClass();
//        for(int i = 0 ; i < numOf ; i++){
//            if (g[i].getNameGeneric().equals
//        }
//    }
    //TODO maybe add a generic verision of findByName
}

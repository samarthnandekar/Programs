package Array;

import java.util.Comparator;

class Comparators implements Comparator<Pair>{

    public int compare(Pair o1, Pair o2) {
        if(o1.count <= o2.count){
            return 1;
        }else{
            return -1;
        }
    }
    
}
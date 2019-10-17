package Dynamic;

import java.util.Comparator;

class FinishTimeComparator implements Comparator<Jobw>{

    @Override
    public int compare(Jobw arg0, Jobw arg1) {
        if(arg0.end <= arg1.end){
            return -1;
        }else{
            return 1;
        }
    }
    
}

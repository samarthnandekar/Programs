package Array;

public class Triplet implements Comparable<Triplet>{

	int pos;
    int val;
    int index;
    
    public int compareTo(Triplet o) {
        if(val <= o.val){
            return -1;
        }else{
            return 1;
        }
    }

}

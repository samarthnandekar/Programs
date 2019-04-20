package Array;

import java.util.Arrays;

public class _108_NumberOfTrianglesInUnsortedArray {

    public int numberOfTriangles(int input[]){
        Arrays.sort(input);
        
        int count = 0;
        for(int i=0; i < input.length-2; i++){
            int k = i+2;
            for(int j=i+1; j < input.length; j++){
                while(k < input.length && input[i] + input[j] > input[k]){
                    k++;
                }
                count += k - j -1;
            }
        }
        return count;
    }
    
    public static void main(String args[]){
        int input[] = {3, 4, 5, 6, 8, 9, 15};
        _108_NumberOfTrianglesInUnsortedArray not = new _108_NumberOfTrianglesInUnsortedArray();
        System.out.println(not.numberOfTriangles(input));
    }
}

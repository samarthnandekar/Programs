package Recursion;

/*
 /**
 * Generate all combination of size k and less of adjacent numbers
 * e.g 1,2,3,4 k = 2
 * 1 2 3 4
 * 12 3 4
 * 1 23 4
 * 1 2 34
 * 12 34
 * 
 */
public class _1_PrintAllAdjacentCombination {

	public static void main(String[] args) {
	
		_1_PrintAllAdjacentCombination adc = new _1_PrintAllAdjacentCombination();
        int input[] = {1,2,3,4};
        int result[] = new int[input.length];
        adc.combination(input,result,2,0,0);

	}
	
public void combination(int input[],int result[],int k,int pos,int r){
        
        if(pos == input.length){
            for(int i=0; i < r ; i++){
                System.out.print(result[i] + " ");
            }
            System.out.println();
            return;
        }
        for(int i=pos; i < pos + k && i < input.length; i++ ){
            result[r] = formNumber(input,pos,i);
            combination(input,result,k,i+1,r+1);
        }
    }
    
    private int formNumber(int input[], int start, int end){
        int num = 0;
        for(int i=start; i <=end; i++){
            num = num*10 + input[i];
        }
        return num;
    }
}

package Dynamic;
/*
 * http://www.geeksforgeeks.org/remove-minimum-elements-either-side-2min-max/
 */
public class _58_RemoveMinElementfor2Max {

	public int removeFromEndDynamic(int input[]){
        int T[][] = new int[input.length][input.length];
        for(int l=1; l <= input.length; l++){
            for(int i=0; i < input.length-l+1; i++){
            	int j = i + l-1;
                int min = min(input,i,j);
                int max = max(input,i,j);
                if(2*min > max){
                    T[i][j] = 0;
                }else{
                    T[i][j] = Math.min(T[i+1][j] , T[i][j-1]) +1;
                }
            }
        }
        return T[0][input.length-1];
    }
	
	private int min(int input[],int low,int high){
        int min = Integer.MAX_VALUE;
        for(int i=low; i <=high; i++){
            if(min > input[i]){
                min = input[i];
            }
        }
        return min;
    }
    private int max(int input[],int low,int high){
        int max = Integer.MIN_VALUE;
        for(int i=low; i <=high; i++){
            if(max < input[i]){
                max = input[i];
            }
        }
        return max;
    }
    
    public static void main(String args[]){
        int input[] = {5,1,3,1,3,8,3};
        int input1[] = {4,5,100,9,10,11,12,15,200};
        _58_RemoveMinElementfor2Max rme = new _58_RemoveMinElementfor2Max();
        System.out.println(rme.removeFromEndDynamic(input1));
        int input2[] = {3,1,4,5};
        System.out.println(rme.removeFromEndDynamic(input2));
        
        int input3[] = {1,3,4,5};
        System.out.println(rme.removeFromEndDynamic(input3));
        
        
    }
}

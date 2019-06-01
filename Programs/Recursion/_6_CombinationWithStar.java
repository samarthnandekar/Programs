package Recursion;

/**
 * input is a, b c 
 * 
 * * * *
 * a * *
 * a b *
 * a b c
 * * b *
 * * b c
 * * * c
 * 
 * Idea is to store the index of values in used[] array. So just
 * like regular combination if used is set print it else print *
 */

public class _6_CombinationWithStar {

	public static void main(String[] args) {
		   char input[] = {'a','b','c'};
		   _6_CombinationWithStar cws = new _6_CombinationWithStar();
	        boolean used[] = new boolean[input.length];
	        cws.combine(input, 0, used);
	}

	public void combine(char input[], int pos, boolean used[]){
        printArray(input, used);
        for(int i= pos; i < input.length; i++){
            used[i] = true;
            combine(input, i+1, used);
            used[i] = false;
        }
    }
    
    private void printArray(char result[], boolean used[]){
        for(int i=0; i < used.length; i++){
            if(used[i]){
                System.out.print(result[i] + " ");
            }else{
                System.out.print("* ");
            }
        }
        System.out.println();
    }
    
}

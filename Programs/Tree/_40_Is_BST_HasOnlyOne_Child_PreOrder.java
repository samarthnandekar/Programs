package Tree;

/*
 
 * http://www.geeksforgeeks.org/check-if-each-internal-node-of-a-bst-has-exactly-one-child/
 
 In first and second loop will get max and min value. Remaining value should be in the range.
 
 */
public class _40_Is_BST_HasOnlyOne_Child_PreOrder {

	public boolean isBST(int input[]){
        int max = Integer.MAX_VALUE;
        int min = Integer.MIN_VALUE;
        for(int i = 0; i < input.length-1; i++)
        {
            if(input[i] > min && input[i] < max)
            {
                if(input[i+1] < input[i])
                {
                    max = input[i];
                }
                else
                {
                    min = input[i];
                }
            }
            else
            {
                return false;
            }
        }
        
        if(input[input.length-1] < max && input[input.length-1] > min){
            return true;
        }else{
            return false;
        }
    }
    
    public static void main(String args[]){
        int input[] = {20,24,10,14,15,17};
        _40_Is_BST_HasOnlyOne_Child_PreOrder boc = new _40_Is_BST_HasOnlyOne_Child_PreOrder();
        System.out.println(boc.isBST(input));
    }
}

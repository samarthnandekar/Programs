package Array;

public class DuplicateNumberDetection {
    public int findDuplicate(int[] nums) {
        if (nums.length == 0 || nums.length == 1) {
            return -1;
        }

        int slow = nums[0];
        int fast = nums[nums[0]];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        fast = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return fast;
    }
    
    void printRepeating(int arr[], int size) 
    { 
        int i;   
        System.out.println("The repeating elements are : "); 
     
        for (i = 0; i < size; i++) 
        { 
            if (arr[Math.abs(arr[i])] >= 0) 
                arr[Math.abs(arr[i])] = -arr[Math.abs(arr[i])]; 
            else
                System.out.print(Math.abs(arr[i]) + " "); 
        }          
    }  
    
    public static void main(String args[]) {
        int[] input = {-2,1,3,4,-2};
        DuplicateNumberDetection dd = new DuplicateNumberDetection();
       // System.out.println(dd.findDuplicate(input));
        dd.printRepeating(input,input.length);
    }
}

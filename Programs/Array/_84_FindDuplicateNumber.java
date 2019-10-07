package Array;

/*

287. Find the Duplicate Number

Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), prove that at least one duplicate number must exist.
Assume that there is only one duplicate number, find the duplicate one.

Example 1:

Input: [1,3,4,2,2]
Output: 2
Example 2:

Input: [3,1,3,4,2]
Output: 3
Note:

You must not modify the array (assume the array is read only).
You must use only constant, O(1) extra space.
Your runtime complexity should be less than O(n2).
There is only one duplicate number in the array, but it could be repeated more than once.

*/

public class _84_FindDuplicateNumber 
{
	
	   // O(n) and constant space,do not modify array
	    public int findDuplicate(int[] nums) 
	    {
	        if (nums.length == 0 || nums.length == 1) 
	        {
	            return -1;
	        }

	        int slow = nums[0];
	        int fast = nums[nums[0]];
	        while (slow != fast)
	        {
	            slow = nums[slow];
	            fast = nums[nums[fast]];
	        }
	        fast = 0;
	        while (slow != fast) 
	        {
	            slow = nums[slow];
	            fast = nums[fast];
	        }
	        return fast;
	    }

	    
	    // Use HashMap O(n) but will take more space
	    
	    //create boolean Array- and on particular index, changed from false to true.. o(n) but will take space.
	    
	    
	    //O(n)  , but modifing array
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
	    
	    
	    // Another approach  from http://codercareer.blogspot.com/
	    private static int countRange(int[] numbers, int start, int end)
		{
			int count = 0;
			for(int i = 0; i < numbers.length; i++)
				if(numbers[i] >= start && numbers[i] <= end)
					++count;
			return count;
		}
	 
		public static int getDuplication(int[] numbers)
		{
			int start = 1;
			int end = numbers.length;
			while(end >= start)
			{
				int middle = (start +end)/2;
				int count = countRange(numbers, start, middle);
				if(end == start) {
					if(count > 1)
						return start;
					else
						break;
				}
	 
				if(count > (middle - start + 1))
					end = middle;
				else
					start = middle + 1;
			}
			return -1;
		}
	    
	    public static void main(String args[]) 
	    {
	        int[] input = {4,1,2,4,3};
	        DuplicateNumberDetection dd = new DuplicateNumberDetection();
	        System.out.println(dd.findDuplicate(input));
	        
	        System.out.println(getDuplication(input));
	    }
	
}

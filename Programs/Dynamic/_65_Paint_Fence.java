package Dynamic;

/*
 Leetcode 276: Paint Fence

Question:- There is a fence with n posts, each post can be painted with one of the k colors.
You have to paint all the posts such that no more than two adjacent fence posts have the same color.

Return the total number of ways you can paint the fence.
Note: n and k are non-negative integers.

Example:
Input: n = 3, k = 2
Output: 6   Explanation: Take c1 as color 1, c2 as color 2. All possible ways are:

            post1  post2  post3      
 -----      -----  -----  -----       
   1         c1     c1     c2
   2         c1     c2     c1
   3         c1     c2     c2
   4         c2     c1     c1  
   5         c2     c1     c2
   6         c2     c2     c1
  

Solution
If n == 1, there would be k-ways to paint.
if n == 2, there would be two situations:

2.1 You paint same color with the previous post: k*1 ways to paint, named it as same;
2.2 You paint differently with the previous post: k*(k-1) ways to paint this way, named it as diff.
So, you can think, if n >= 3, you can always maintain these two situations, You either paint the same color with the previous one, or differently.

Since there is a rule: “no more than two adjacent fence posts have the same color.”

We can further analyze:

from 2.1, since previous two are in the same color, next one you could only paint differently, and it would form one part of “paint differently” case in the n == 3 level, 
and the number of ways to paint this way would equal to same*(k-1).
from 2.2, since previous two are not the same, you can either paint the same color this time (diff*1) ways to do so, or stick to paint differently (diff*(k-1)) times.
Here you can conclude, when seeing back from the next level, ways to paint the same, or variable same would equal to diff*1 = diff, and ways to paint differently,
variable diff, would equal to same * (k - 1) + diff * (k - 1) = (same + diff) * (k - 1).  

 */
public class _65_Paint_Fence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_65_Paint_Fence obj= new _65_Paint_Fence();
            int ans=obj.numWays(2,1);
            System.out.println(ans);
	}

	int numWays( int n, int k) {
        
		if (k == 0 || n == 0) 
			return  0 ;
		
		if(n == 1)
            return k;
		
        int same = 0 , diff = k;
        
        for ( int i = 2 ; i <= n; ++ i) {
            int t = diff;
           diff = (same + diff) * (k - 1 );
           same = t;
       }
       return same + diff;
   }
}

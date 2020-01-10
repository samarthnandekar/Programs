package Array;

/*
 * https://www.geeksforgeeks.org/stable-marriage-problem/
 Stable Marriage Problem
The Stable Marriage Problem states that given N men and N women, where each person has ranked all members of the opposite 
sex in order of preference, marry the men and women together such that there are no two people of opposite sex who would both 
rather have each other than their current partners. If there are no such people, all the marriages are “stable” (Source Wiki).

Consider the following example.

Let there be two men m1 and m2 and two women w1 and w2.
Let m1‘s list of preferences be {w1, w2}
Let m2‘s list of preferences be {w1, w2}
Let w1‘s list of preferences be {m1, m2}
Let w2‘s list of preferences be {m1, m2}

The matching { {m1, w2}, {w1, m2} } is not stable because m1 and w1 would prefer each other over their assigned partners. 
The matching {m1, w1} and {m2, w2} is stable because there are no two people of opposite sex that would prefer each other 
over their assigned partners.

It is always possible to form stable marriages from lists of preferences (See references for proof). Following is Gale–Shapley 
algorithm to find a stable matching:
The idea is to iterate through all free men while there is any free man available. Every free man goes to all women in his 
preference list according to the order. For every woman he goes to, he checks if the woman is free, if yes, they both become engaged. 
If the woman is not free, then the woman chooses either says no to him or dumps her current engagement according to her preference list.
So an engagement done once can be broken if a woman gets better option. Time Complexity of Gale-Shapley Algorithm is O(n2).

Following is complete algorithm from Wiki, Initialize all men and women to free
while there exist a free man m who still has a woman w to propose to 
{
    w = m's highest ranked such woman to whom he has not yet proposed
    if w is free
       (m, w) become engaged
    else some pair (m', w) already exists
       if w prefers m to m'
          (m, w) become engaged
           m' becomes free
       else
          (m', w) remain engaged    
}
 */
public class _154_StableMarriageProblem {

	private boolean checkIfNewIsBetter(int priority[][], int bride,
            int currentGroom, int suitor) {
        for (int groom : priority[bride]) {
            if (currentGroom == groom) {
                return false;
            }
            if (suitor == groom) {
                return true;
            }
        }
        return false;
    }

    public int[] findPair(int[][] priority) {
        int pair = priority[0].length;
        int groomToBride[] = new int[pair];
        int brideToGroom[] = new int[pair];
        for(int i=0; i < groomToBride.length; i++){
            groomToBride[i] = -1;
        }
        for(int i=0; i < brideToGroom.length; i++){
            brideToGroom[i] = -1;
        }
        int groom ;
        int remaingGrooms = pair;
        while (remaingGrooms > 0) {
            groom = -1;
            for (int hasBride : groomToBride) {
                if (hasBride != -1) {
                    continue;
                }
                groom++;
                for (int bride : priority[groom]) {
                    if (brideToGroom[bride-pair] == -1) {
                        groomToBride[groom] = bride;
                        brideToGroom[bride-pair] = groom;
                        remaingGrooms--;
                        break;
                    } else {
                        boolean flag = checkIfNewIsBetter(priority, bride,
                                brideToGroom[bride-pair], groom);
                        if (flag) {
                            int currentGroom = brideToGroom[bride-pair];
                            brideToGroom[bride-pair] = groom;
                            groomToBride[groom] = bride;
                            groomToBride[currentGroom] = -1;
                        }
                    }
                }
            }
        }
        return groomToBride;
    }
    
    public static void main(String args[]){
        int priority[][] = {{5,4,7,6},
                           {4,5,6,7},
                           {5,4,6,7},
                           {5,4,7,6},
                           {0,1,2,3},
                           {0,1,3,2},
                           {0,3,1,2},
                           {0,1,2,3}};
        _154_StableMarriageProblem smp = new _154_StableMarriageProblem();
        int[] result = smp.findPair(priority);
        for(int i=0; i < result.length; i++){
            System.out.println(i + " " + result[i]);
        }
    }

}

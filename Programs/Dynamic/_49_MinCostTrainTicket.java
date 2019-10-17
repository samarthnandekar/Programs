package Dynamic;

/*
Find the minimum cost to reach destination using a train
There are N stations on route of a train. The train goes from station 0 to N-1. The ticket cost for all pair of stations (i, j) is given where j is greater than i.
 Find the minimum cost to reach the destination.
Consider the following example:

Input: 
cost[N][N] = { {0, 15, 80, 90},
              {INF, 0, 40, 50},
              {INF, INF, 0, 70},
              {INF, INF, INF, 0}
             };
There are 4 stations and cost[i][j] indicates cost to reach j 
from i. The entries where j < i are meaningless.

Output:
The minimum cost is 65
The minimum cost can be obtained by first going to station 1 
from 0. Then from station 1 to station 3.
https://www.geeksforgeeks.org/find-the-minimum-cost-to-reach-a-destination-where-every-station-is-connected-in-one-direction/
 */
public class _49_MinCostTrainTicket {

	public int minCost(int ticket[][]){
        assert ticket != null && ticket.length > 0 && ticket.length == ticket[0].length;
        int T[] = new int[ticket.length];
        int T1[] = new int[ticket.length];
        T1[0] = -1;
        for(int i=1; i < T.length; i++){
            T[i] = ticket[0][i];
            T1[i] = i-1;
        }
        
        for(int i=1; i < T.length; i++){
            for(int j=i+1; j < T.length; j++){
                if(T[j] > T[i] + ticket[i][j]){
                    T[j] = T[i] + ticket[i][j];
                    T1[j] = i;
                }
            }
        }
        
        //printing actual stations
        int i = ticket.length-1;
        while(i != -1){
            System.out.print(i + " ");
            i = T1[i];
        }
        System.out.println();
        return T[ticket.length-1];
    }
    
    public static void main(String args[]){
        int input[][] = {{0, 15, 80, 90},
                         {-1, 0,  40, 50},
                         {-1, -1,  0,  70},
                         {-1, -1,  -1,  0}};
        _49_MinCostTrainTicket mctt = new _49_MinCostTrainTicket();
        System.out.println(mctt.minCost(input));
    }
}

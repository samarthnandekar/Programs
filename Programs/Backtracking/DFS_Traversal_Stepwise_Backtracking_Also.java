package Backtracking;

/*
 https://www.geeksforgeeks.org/print-the-dfs-traversal-step-wise-backtracking-also/
 
Print the DFS traversal step-wise (Backtracking also)
Given a graph, the task is to print the DFS traversal of a graph which includes the every step including the backtracking.

                           (0)
                        /      \
                     (1)        (2)--- (4)
                    /  \        /   \ 
                  (5)  (6)     (3)--(9)
                       /  \    \    /
                      7--- 8     10
1st step:- 0 -> 1
2nd step:- 1 -> 5
3rd step:- 5 -> 1 (backtracking step)
4th step:- 1 -> 6...
and so on till all the nodes are visited.
 
Dfs step-wise(including backtracking) is:
0 1 5 1 6 7 8 7 6 1 0 2 4 2 9 3 10
                         
 */
public class DFS_Traversal_Stepwise_Backtracking_Also {

}

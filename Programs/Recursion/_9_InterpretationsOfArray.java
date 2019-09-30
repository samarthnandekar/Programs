package Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 https://www.geeksforgeeks.org/find-all-possible-interpretations/

 Find all possible interpretations of an array of digits
 Consider a coding system for alphabets to integers where ‘a’ is represented as 1, ‘b’ as 2, .. ‘z’ as 26. Given an array of digits (1 to 9) as input,
 write a function that prints all valid interpretations of input array.

Examples:- 
Input: {1, 1}
Output: ("aa", 'k") 
[2 interpretations: aa(1, 1), k(11)]

Input: {1, 2, 1}
Output: ("aba", "au", "la") 
[3 interpretations: aba(1,2,1), au(1,21), la(12,1)]

Input: {9, 1, 8}
Output: {"iah", "ir"} 
[2 interpretations: iah(9,1,8), ir(9,18)]


not covered- Samarth

Asked:- facebook
 */
public class _9_InterpretationsOfArray {

	public static void main(String[] args) {
	
	        int arr[] = {1,2,1};
	        _9_InterpretationsOfArray ioa = new _9_InterpretationsOfArray();
	        //ioa.interpret(arr);
	        printAllInterpretations(arr);
	    }
	
	public void interpret(int arr[]){
        char t[][] = new char[arr.length][2];
        for(int i=0; i < arr.length; i++){
            for(int j=0; j < 2; j++){
                t[i][j] = '0';
            }
        }
        printArray(t);
        System.out.println("--------------");
        for(int l=1; l <=2; l++){
            for(int i=0; i <= arr.length -l ; i++){
                int j = i + l-1;
                t[i][l-1] = getRepresentation(i == j ? arr[i] : arr[i]*10 +arr[j]);
            }
        }
        printArray(t);
        System.out.println("--------------");
        List<Character> result = new ArrayList<Character>();
        interpret(arr.length,0,result,t);
    }
	
	static void printArray(char [][] arr)
	{
		int row=arr.length;
		for(int i=0;i<arr.length;i++)
		{
			for(int j=0;j<2;j++)
			{
				System.out.print(arr[i][j] + "  ");
			}
			System.out.println("");
		}
	}
    
    private void interpret(int len,int pos,List<Character> result,char[][] t){
        if(pos== len){
            print(result);
            return;
        }
        if(t[pos][0] != '0'){
            result.add(t[pos][0]);
            interpret(len,pos+1,result,t);
            result.remove(result.size()-1);
        }
        
        if(pos+1 < len && t[pos][1] != '0'){
            result.add(t[pos][1]);
            interpret(len, pos+2, result, t);
            result.remove(result.size()-1);
        }
            
    }
    
    private void print(List<Character> result){
        for(int i=0; i < result.size(); i++){
            System.out.print(result.get(i) + " ");
        }
        System.out.println();
    }
    
    private char getRepresentation(int number){
        if(number > 26 || number <= 0){
            return '0';
        }
        return (char)('a' + number -1);
    }
    
    // *******************  Second method   *******************
    private static final String[] alphabet = {"", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", 
                                              "s", "t", "u", "v", "w", "x", "v", "z"}; 
      
     // Method to create a binary tree which stores all interpretations  of arr[] in lead nodes 
    public static Node createTree(int data, String pString, int[] arr) { 
  
        // Invalid input as alphabets maps from 1 to 26 
        if (data > 26)  
            return null; 
  
        // Parent String + String for this node 
        String dataToStr = pString + alphabet[data]; 
  
        Node root = new Node(dataToStr); 
  
        // if arr.length is 0 means we are done 
        if (arr.length != 0) { 
            data = arr[0]; 
  
            // new array will be from index 1 to end as we are consuming first index with this node 
            int newArr[] = Arrays.copyOfRange(arr, 1, arr.length); 
  
            // left child 
            root.left = createTree(data, dataToStr, newArr); 
  
            // right child will be null if size of array is 0 or 1 
            if (arr.length > 1) { 
  
                data = arr[0] * 10 + arr[1]; 
  
                // new array will be from index 2 to end as we  
                // are consuming first two index with this node 
                newArr = Arrays.copyOfRange(arr, 2, arr.length); 
  
                root.right = createTree(data, dataToStr, newArr); 
            } 
        } 
        return root; 
    } 
  
    // To print out leaf nodes 
    public static void printleaf(Node root) { 
        if (root == null)  
            return; 
  
        if (root.left == null && root.right == null)  
            System.out.print(root.getDataString() + "  "); 
          
        printleaf(root.left); 
        printleaf(root.right); 
    } 
  
    // The main function that prints all interpretations of array 
    static void printAllInterpretations(int[] arr) { 
  
        // Step 1: Create Tree 
        Node root = createTree(0, "", arr); 
  
        // Step 2: Print Leaf nodes 
        printleaf(root); 
  
        System.out.println();  // Print new line 
    } 
}

class Node { 
	  
    String dataString; 
    Node left; 
    Node right; 
  
    Node(String dataString) { 
        this.dataString = dataString; 
        //Be default left and right child are null.  
    } 
  
    public String getDataString() { 
        return dataString; 
    } 
} 
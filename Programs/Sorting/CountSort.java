package Sorting;

import java.util.HashMap;
import java.util.TreeMap;

public class CountSort {

	private static int TOTAL = 10;


	 static public void sort1(int arr[]) {

	        int count[] = new int[TOTAL];
	        int output[] = new int[arr.length];
	        for (int i = 0; i < arr.length; i++) {
	            count[arr[i]]++;
	        }
	        
	        for(int i=1; i < TOTAL; i++){
	            count[i] += count[i-1];
	        }
	        
	        for(int i=0; i <arr.length; i++){
	            output[count[arr[i]]-1] = arr[i];
	            count[arr[i]]--;
	        }
	        
	        for(int i=0; i < arr.length; i++){
	            arr[i] = output[i];
	        }
	    }
	 
	 // Sorting using hashMap
	 static public void sort1_hashMap(int arr[]) {
		 
		 TreeMap<Integer,Integer> keyCount= new TreeMap<Integer,Integer>();
		 
		 
		 
		 
	 }
	 
	

	    public static void main(String args[]) {
	        int arr[] = { 6, 1, 6, 7, 3, 1 };
	       
	        sort1(arr);
	        for (int i = 0; i < arr.length; i++) {
	            System.out.print(arr[i] + "  ");
	        }
	    }
}

package Recursion;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

/*
 
  Given an input with duplicate characters generate a shuffle which does not have 
  two duplicate characters together
  
  Do regular permutation with repetition with additional constraint of keeping
  duplicates away from each other.
  
 */
public class _8_AlternateShuffle {
	
	public static void main(String args[]) {
		_8_AlternateShuffle fs = new _8_AlternateShuffle();
		char result[] = fs.shuffle("bbcdaaaaa".toCharArray());
		for(char ch : result) { 
			System.out.print(ch);
		}
		
		System.out.println("*************");
		rearrangeString("bbcdaaaaa");
	}
	
	public char[] shuffle(char input[]){
		char result[] = new char[input.length];
		
		//create a map of character to its frequency.
		Map<Character, Integer> map = new HashMap<Character,Integer>();
		for(int i=0; i < input.length; i++)
		{
			Integer count  = map.putIfAbsent(input[i], 1);
			if(count != null) {
				count++;
				map.put(input[i], count);
			}
		}
		
		char newInput[] = new char[map.size()];
		int freq[] = new int[map.size()];
		
		//create a new char array and freq array from map.
		int index = 0;
		for(Entry<Character,Integer> entry :  map.entrySet())
		{
			newInput[index] = entry.getKey();
			freq[index] = entry.getValue();
			index++;
		}
		//assuming char with ASCII value 0 does not exists in the input
		shuffleUtil(newInput,freq, result, 0, (char)0);
		return result;
	}
	
	//regular permutation code. If we do find a permutation which satisfies the constraint then return true and stop the process.
	private boolean shuffleUtil(char input[], int freq[], char result[], int pos, char lastVal) {
		if(pos == result.length)
		{
			return true;
		}
		
		for(int i=0; i < input.length; i++)
		{
			if(lastVal == input[i]) {
				continue;
			}
			if(freq[i] == 0) { 
				continue;
			}
			freq[i]--;
			result[pos] = input[i];
			if(shuffleUtil(input, freq, result, pos+1, input[i])){
				return true;
			}
			//freq[i]++;
		}
		return false;
	}

	
	/*
	 * https://www.geeksforgeeks.org/rearrange-characters-string-no-two-adjacent/
	 
	 Rearrange characters in a string such that no two adjacent are same
	Given a string with repeated characters, task is rearrange characters in a string so that no two adjacent characters are same.
	
	Note : It may be assumed that the string has only lowercase English alphabets.
	
	Examples:
	
	Input: aaabc 
	Output: abaca 
	
	Input: aaabb
	Output: ababa 
	
	Input: aa 
	Output: Not Possible
	
	Input: aaaabc 
	Output: Not Possible
	
	 */
	
	// Function to rearrange character of a string so that no char repeat twice  Time complexity : O(n log n)

    static int MAX_CHAR = 26;  
    static void rearrangeString(String str) 
    { 
           int n = str.length(); 

           // Store frequencies of all characters in string 
           int[] count = new int[MAX_CHAR]; 
             
           for (int i = 0; i < n; i++) 
                count[str.charAt(i) - 'a']++; 

            // Insert all characters with their frequencies into a priority_queue  
            PriorityQueue<Key> pq = new PriorityQueue<>(new KeyComparator()); 
            for (char c = 'a'; c <= 'z'; c++) { 
                 int val = c - 'a'; 
                 if (count[val] > 0) 
                     pq.add(new Key(count[val], c)); 
            } 
                 
            // 'str' that will store resultant value 
            str = "" ; 

            // work as the previous visited element initial previous element be. ( '#' and it's frequency '-1' ) 
            Key prev = new Key(-1, '#'); 

            // traverse queue 
            while (pq.size() != 0) { 
              
                   // pop top element from queue and add it to string. 
                   Key k = pq.peek(); 
                   pq.poll(); 
                   str = str + k.ch; 

                   // If frequency of previous character is less than zero that means it is useless, we need not to push it  
                   if (prev.freq > 0) 
                       pq.add(prev); 

                   // make current character as the previous 'char' decrease frequency by 'one' 
                   (k.freq)--; 
                    prev = k; 
            }

            // If length of the resultant string and original string is not same then string is not valid 
            if (n != str.length()) 
                System.out.println(" Not valid String "); 
            else
                System.out.println(str); 
    } 
}



class KeyComparator implements Comparator<Key> { 
	  
    // Overriding compare()method of Comparator 
    public int compare(Key k1, Key k2) 
    { 
           if (k1.freq < k2.freq) 
               return 1; 
           else if (k1.freq > k2.freq) 
               return -1; 
           return 0; 
    } 
} 

class Key { 
    int freq; // store frequency of character 
    char ch; 
    Key(int val, char c)  
    { 
        freq = val;  
        ch = c; 
    } 
} 
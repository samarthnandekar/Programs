package Dynamic;

import java.util.HashMap;
import java.util.Map;

/*
 https://www.geeksforgeeks.org/palindrome-partitioning-dp-17/
 
 
Mobile Numeric Keypad Problem:- Given the mobile numeric keypad. You can only press buttons that are up, left, right or down to the current button. 
                                You are not allowed to press bottom row corner buttons (i.e. * and # ).

Given a number N, find out the number of possible numbers of given length.

Examples:
For N=1, number of possible numbers would be 10 (0, 1, 2, 3, …., 9)
For N=2, number of possible numbers would be 36
Possible numbers: 00,08 11,12,14 22,21,23,25 and so on.
If we start with 0, valid numbers will be 00, 08 (count: 2)
If we start with 1, valid numbers will be 11, 12, 14 (count: 3)
If we start with 2, valid numbers will be 22, 21, 23,25 (count: 4)
If we start with 3, valid numbers will be 33, 32, 36 (count: 3)
If we start with 4, valid numbers will be 44,41,45,47 (count: 4)
If we start with 5, valid numbers will be 55,54,52,56,58 (count: 5)
………………………………
………………………………

We need to print the count of possible numbers.

 */
public class _56_Mobile_Numeric_Keypad_Problem {

	public int numberOfCombination(int k, int input[][]) {
		if (input == null || input.length == 0) {
			throw new IllegalArgumentException();
		}
		Map<Integer, Integer> t = new HashMap<Integer, Integer>();
		Map<Integer, Integer> t1 = new HashMap<Integer, Integer>();

		// put all the values in t1 map
		for (int i = 0; i < input.length; i++) {
			for (int j = 0; j < input[i].length; j++) {
				if (input[i][j] < 0) {
					continue;
				}
				t1.put(input[i][j], 1);   // initialize with one
			}
		}

		for (int x = 1; x < k; x++) { // for length
			for (int i = 0; i < input.length; i++) {
				for (int j = 0; j < input[i].length; j++) {
					if (input[i][j] < 0) {
						continue;
					}
					findNeighborsAndPopulateMap(i, j, input, t, t1);
				}
			}
			copyMap(t, t1);
			t.clear();
		}
		
		// take the count of all keys
		int count = 0;
		for (int i : t1.keySet()) {
			count += t1.get(i);
		}
		return count;
	}

	private void copyMap(Map<Integer, Integer> t, Map<Integer, Integer> t1) {
		for (Integer i : t.keySet()) {
			int c = t.get(i);
			t1.put(i, c);
		}
	}

	private void findNeighborsAndPopulateMap(int x, int y, int input[][],Map<Integer, Integer> t, Map<Integer, Integer> t1) {
		updateMap(input, x, y, x - 1, y, t, t1);
		updateMap(input, x, y, x, y - 1, t, t1);
		updateMap(input, x, y, x, y, t, t1);
		updateMap(input, x, y, x, y + 1, t, t1);
		updateMap(input, x, y, x + 1, y, t, t1);
	}

	private void updateMap(int input[][], int x, int y, int i, int j,Map<Integer, Integer> t, Map<Integer, Integer> t1) {
		
		if (i < 0 || i >= input.length || j < 0 || j >= input[x].length || input[i][j] < 0) {
			return;
		}
		Integer c = t.get(input[x][y]);
		if (c == null) {
			c = 0;
		}
		c += t1.get(input[i][j]);
		t.put(input[x][y], c);
	}

	public static void main(String args[]) {
		int input[][] = {{ 1, 2, 3 },
				         { 4, 5, 6 },
				         { 7, 8, 9 },
				         { -1, 0, -1}};
		_56_Mobile_Numeric_Keypad_Problem pdn = new _56_Mobile_Numeric_Keypad_Problem();
		System.out.println(pdn.numberOfCombination(2, input));
	}
}

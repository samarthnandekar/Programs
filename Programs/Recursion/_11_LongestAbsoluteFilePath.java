package Recursion;

import java.util.Stack;

/*
 388. Longest Absolute File Path
 
Suppose we abstract our file system by a string in the following manner: The string "dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext" represents:

dir
    subdir1
    subdir2
        file.ext
The directory dir contains an empty sub-directory subdir1 and a sub-directory subdir2 containing a file file.ext.

The string "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext" represents:

dir
    subdir1
        file1.ext
        subsubdir1
    subdir2
        subsubdir2
            file2.ext
The directory dir contains two sub-directories subdir1 and subdir2. subdir1 contains a file file1.ext and an empty second-level sub-directory subsubdir1. subdir2 contains a second-level sub-directory subsubdir2 containing a file file2.ext.

We are interested in finding the longest (number of characters) absolute path to a file within our file system. For example, in the second example above, the longest absolute path is "dir/subdir2/subsubdir2/file2.ext", and its length is 32 (not including the double quotes).

Given a string representing the file system in the above format, return the length of the longest absolute path to file in the abstracted file system. If there is no file in the system, return 0.

Note:
The name of a file contains at least a . and an extension.
The name of a directory or sub-directory will not contain a ..
Time complexity required: O(n) where n is the size of the input string.

Notice that a/aa/aaa/file1.txt is not the longest file path, if there is another path aaaaaaaaaaaaaaaaaaaaa/sth.png.

*/

/*
 
 Find longest absolute path in file system indicated by \n and \t.
 *
 * Solution 1:
 * Create queue of file and its level. Then recurse from root towards file. Use level
 * to decide if next word in queue is in same level (so no more recursion) or next level so
 * going deep in recursion.
 *
 * Solution 2(iterative):
 * Keep pushing elements into stack till you either reach a file with . or a file whose number of tabs is less than
 * top of stack. If you reach file with extension then update the max. Otherwise keep popping from stack till number of tabs
 * at top of stack becomes less than current file. Maintain current length during push and pop.
 *
 * Time complexity O(n)
 * Space complexity O(n)
 
 https://leetcode.com/problems/longest-absolute-file-path/

 */

public class _11_LongestAbsoluteFilePath {

	public static void main(String[] args) {
		
		String inputStr="dir\\n\\tsubdir1\\n\\tsubdir2\\n\\t\\tfile.ext";
		String inputStr2="dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext";
		_11_LongestAbsoluteFilePath obj= new _11_LongestAbsoluteFilePath();
		int path=obj.lengthLongestPathIterative(inputStr2);
		System.out.println(path);

	}
	
	
	public int lengthLongestPathIterative(String input) {
        if (input.length() == 0) {
            return 0;
        }
        String[] tokens = input.split("\n");
        Stack<String> stack = new Stack<>();
        Stack<Integer> stack1 = new Stack<>();
        int len = 0;
        int max = 0;
        for (String token : tokens) {
            int level = 0;
            int i;
            for (i = 0; i < token.length(); i++) 
            {
                if (token.charAt(i) == '\t') {
                    level++;
                } else {
                    break;
                }
            }
            token = token.substring(i);
            while (!stack1.isEmpty() && level <= stack1.peek()) {
                stack1.pop();
                String data = stack.pop();
                len -= data.length() + 1; //+1 to account for '\' between folders files
            }
            if (token.contains(".")) {
                max = Math.max(max, len + token.length());
            } else {
                stack1.push(level);
                stack.push(token);
                len += token.length() + 1; //+1 to accoutn for '\' between folders files
            }
        }
        return max;
    }

}



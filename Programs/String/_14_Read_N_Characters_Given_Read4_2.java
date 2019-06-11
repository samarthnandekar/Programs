package String;

/*
https://cheonhyangzhang.wordpress.com/2016/12/22/158-leetcode-java-read-n-characters-given-read4-ii-call-multiple-times-add-to-list-questioneditorial-solution-hard/

Problem:
The API: int read4(char *buf) reads 4 characters at a time from a file.

The return value is the actual number of characters read. For example, it returns 3 if there is only 3 characters left in the file.
By using the read4 API, implement the function int read(char *buf, int n) that reads n characters from the file.

Note:- The read function may be called multiple times.

Thoughts :- The difference between this question and the first version is that the read() function will be called multiple times.
            The trouble here will be as the following example if using the first version solution: file: “abcdefg”

read(3) read(2) read(2) should be “abc” “de” “fg”
but using first version solution it will print “abc” “ef” “”

This is because when you use read4() to read, the pointer to read file has already moved to “e” after the first call of read4(). So it’s not correct
any more.

In order to solve, we need to persist the characters that has been already read by using read4 but it’s not put into the result of read().

In the solution below, I am using a buf4[] to store the characters read by using read4 and also a buf4Size and buf4Index to keep track of the size 
of the buf4 and the next character to use in buf4[].


google, facebook
 */
public class _14_Read_N_Characters_Given_Read4_2 extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    private char[] buf4 = new char[4];
    private int buf4Index = 4;
    private int buf4Size = 4;
    public int read(char[] buf, int n) {
        int i = 0;
        while (i < n) {
            if (buf4Index >= buf4Size) {
               buf4Size = read4(buf4);
               buf4Index = 0;
               if (buf4Size == 0) {
                   break;
               }
            }
            buf[i] = buf4[buf4Index];
            buf4Index ++;
            i ++;
        }
        return i;
    }
    
    /*
     * int remainSize = 0;
	   int remainIndex = 0;
	   char[] remainBuf = new char[4];
		
	   public int read(char[] buf, int n)
	   {
		    if (n <= 0) {
		        return 0;
		    }
		
		    int index = 0;
		    while (index < n) {
		        while (remainIndex < remainSize) {
		            buf[index++] = remainBuf[remainIndex++];
		        }
		
		        if (remainIndex >= remainSize) {
		            remainIndex = 0;
		            remainSize = read4(remainBuf);
		        }
		
		        if (remainSize == 0) {
		            break;
		        }
		    }
		
		    return index;
		}
     */
}

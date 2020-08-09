package String;

/*

316. Remove Duplicate Letters
Given a string which contains only lowercase letters, remove duplicate letters so that every letter appear once and only once.
You must make sure your result is the smallest in lexicographical order among all possible results.

Example 1:    Input:"bcabc"         Output: "abc"
Example 2:    Input:"cbacdcbc"     Output: "acdb"

*/
public class _29_Remove_Duplicate_Letters {

	public static void main(String[] args) {
		
     String input1="bcabcsswwwgghh";
     _29_Remove_Duplicate_Letters obj= new _29_Remove_Duplicate_Letters();
     String ans=obj.removeDuplicateLetters(input1);
     System.out.println(ans);
     
      ans=obj.removeDuplicate(input1);
     System.out.println(ans);
	}

	public String removeDuplicateLetters(String s) {
        int [] cnt = new int [26];
        for (int i = 0; i < s.length(); i++){
            cnt[s.charAt(i) - 'a']++;
        }

        int pos = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(pos) > s.charAt(i)) 
            	pos = i;
            if (--cnt[s.charAt(i) - 'a'] == 0) break;
        }

        return s.length() == 0 ? "": s.charAt(pos) + removeDuplicateLetters(s.substring(pos + 1).replaceAll("" + s.charAt(pos), ""));
    }
	
	// 
	public String removeDuplicate(String s)
	{
		int [] cnt = new int [26];
		for (int i = 0; i < s.length(); i++){
            cnt[s.charAt(i) - 'a']++;
        }
		
		String ans=new String();
		int con=97;
		for(int i=0;i<26;i++)
		{
			if(cnt[i]>0)
			{
				char v=(char) (i+con);
				ans=ans+v;
			}
		}

		return ans;
	}
}

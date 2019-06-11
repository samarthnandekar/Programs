package String;

/*
 
 You are given a string which has numbers and letters. Numbers occupy all odd positions and letters even positions.
 You need to transform this string such that all letters move to front of array, and all numbers at the end. 

The relative order of the letters and numbers needs to be preserved 

I need to do this in O(n) time and O(1) space. 

eg: a1b2c3d4 -> abcd1234 , x3y4z6 -> xyz346 

Asked in google

***** Not covered:- ***** 

 */
public class _10_CycleLeaderIteration {

	public static void main(String args[]){
        String str = "1a2b3c4d5e";
        char[] str1 = str.toCharArray();
        _10_CycleLeaderIteration cli = new _10_CycleLeaderIteration();
        cli.iterate(str1, 0, str1.length);
        for(char ch: str1){
            System.out.print(ch + " ");
        }
    }
	
	//assumption that size is going to be 3^k +1 from start to end
    public void iterate(char str[],int start,int end){
        int len = end - start +1;
        int power = 1;
        while(power < len){
            int index = power;
            int newIndex = -1;
            char temp = str[start+index];
            char temp1;
            while(newIndex != power){
                if(index % 2 ==0){
                    newIndex = index/2;
                }else{
                    newIndex = len/2 + index/2;
                }
                temp1 = str[start + newIndex];
                str[start+newIndex] = temp;
                temp = temp1;
                index = newIndex;
            }
            power = power*3;        
        }
    }

}

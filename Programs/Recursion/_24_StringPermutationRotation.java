package Recursion;

public class _24_StringPermutationRotation {

	public static void main(String[] args)
	{

		String str = "CBA";
		_24_StringPermutationRotation sp = new _24_StringPermutationRotation();
        sp.permute(str.toCharArray(),0);
	}
	
	private void swap(char arr[],int i, int j)
	{
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] =temp;
    }
    
    
    public void permute(char[] str,int pos){
        if(pos == str.length){
            printArray(str);
            return;
        }
        for(int i=pos; i < str.length; i++){
            swap(str,pos,i);
            permute(str,pos+1);
            swap(str,pos,i);
        }
    }
    private void printArray(char str[])
    {
        for(int i=0; i< str.length; i++){
            System.out.print(str[i]);
        }
        System.out.print("\n");
    }

}

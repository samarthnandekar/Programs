package MultiArray;

/*
 * You are given an n x n 2D matrix representing an image.
 * Rotate the image by 90 degrees (clockwise).
 *
 * https://leetcode.com/problems/rotate-image/
 */

public class _1_RotateImage {

	public void rotate(int[][] matrix) {
        int length = matrix.length-1;
       
        for(int i=0;i < matrix.length/2;i++)
        {
            for(int j=i; j < length-i; j++)
            {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[length-j][i];
                matrix[length-j][i] = matrix[length-i][length-j];
                matrix[length-i][length-j] = matrix[j][length-i];
                matrix[j][length-i] = temp;
            }
        }
    }

    private void print(int arr[][]){
        for(int i=0; i < arr.length; i++){
            for(int j=0; j < arr.length; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.print("\n");
        }
    }

    public static void main(String args[]){

        int matrix[][] = {{1,2,3,4},
        		          {5,6,7,8},
        		          {9,10,11,12},
        		          {13,14,15,16}};
        
        _1_RotateImage ti = new _1_RotateImage();
        ti.rotate(matrix);
        ti.print(matrix);
    }
}

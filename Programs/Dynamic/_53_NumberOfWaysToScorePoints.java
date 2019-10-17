package Dynamic;

public class _53_NumberOfWaysToScorePoints {

	//in this version to make 3 - 1,2 is same as 2,1.
    //This is similar to coin changing problem  ******** Simple solution can foid in this one.
    public int version1(int score[],int total){
        int T[] = new int[total+1];
        T[0] = 1;
        for(int i=0; i < score.length; i++){
            for(int j=1; j <= total; j++){
                if(score[i] <= j){
                    T[j] += T[j-score[i]];
                }
            }
        }
        return T[total];
    } 
    
    //in this version to make 3 - 1,2 and 2,1 are counted different.
    //This is same as fibo series only that fibo series looks at last 2 numbers and here we look back k values
    public int version2(int score[],int total){
        int T[] = new int[total+1];
        T[0] = 1;
        for(int i=1; i <= total ; i++){
            for(int j=0; j < score.length; j++){
                if(score[j] <= i){
                    T[i] += T[i-score[j]];
                }
            }
        }
        return T[total];
    }
    
    public static void main(String args[]){
        int score[] = {1,2,3};
        _53_NumberOfWaysToScorePoints now = new _53_NumberOfWaysToScorePoints();
        System.out.println(now.version1(score, 4));
        System.out.println(now.version2(score, 4));
    }
}

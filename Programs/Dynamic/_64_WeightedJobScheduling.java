package Dynamic;

import java.util.Arrays;
import java.util.Comparator;

/**
 * http://www.cs.princeton.edu/courses/archive/spr05/cos423/lectures/06dynamic-programming.pdf
 * Given set of jobs with start and end interval and profit, how to maximize profit such that 
 * jobs in subset do not overlap.
 */
public class _64_WeightedJobScheduling {

	/**
     * Sort the jobs by finish time.
     * For every job find the first job which does not overlap with this job
     * and see if this job profit plus profit till last non overlapping job is greater
     * than profit till last job.
     * @param jobs
     * @return
     */
    public int maximum(Jobw[] jobs){
        int T[] = new int[jobs.length];
        FinishTimeComparator comparator = new FinishTimeComparator();
        Arrays.sort(jobs, comparator);
        
        T[0] = jobs[0].profit;
        for(int i=1; i < jobs.length; i++){
            T[i] = Math.max(jobs[i].profit, T[i-1]);
            for(int j=i-1; j >=0; j--){
                if(jobs[j].end <= jobs[i].start){
                    T[i] = Math.max(T[i], jobs[i].profit + T[j]);
                    break;
                }
            }
        }
        int maxVal = Integer.MIN_VALUE;
        for (int val : T) {
            if (maxVal < val) {
                maxVal = val;
            }
        }
        return maxVal;
    }
    
    public static void main(String args[]){
    	Jobw jobs[] = new Jobw[6];
    	 jobs[0] = new Jobw(2,5,6);
        jobs[1] = new Jobw(1,3,5);
        jobs[2] = new Jobw(4,6,5);
        jobs[3] = new Jobw(6,7,4);
        jobs[4] = new Jobw(5,8,11);
        jobs[5] = new Jobw(7,9,2);
        _64_WeightedJobScheduling mp = new _64_WeightedJobScheduling();
        System.out.println(mp.maximum(jobs));
    }


}
import java.util.*;

class job_scheduling
{
    class Job 
    {
        int st;
        int en;
        int profit;
        public Job(int st, int en, int profit) 
        {
            this.st = st;
            this.en = en;
            this.profit = profit;
        }
    }
    
    public int scheduling(int[] st, int[] en, int[] profit) 
    {
        int n = st.length;
        Job[] jobs = new Job[n];

        for (int i = 0; i < n; i++) {
            jobs[i] = new Job(st[i], en[i], profit[i]);
        }
        Arrays.sort(jobs, Comparator.comparingInt(job -> job.en));

        int[] dp = new int[n];
        dp[0] = jobs[0].profit;
        for (int i = 1; i < n; i++) {
            int cprof = jobs[i].profit;

            int ji = binary(jobs, i);
            if (ji != -1) {
                cprof += dp[ji];
            }

            
            dp[i] = Math.max(cprof, dp[i - 1]);
        }
        return dp[n - 1];
    }

    private int binary(Job[] jobs, int index) {
        int low = 0, high = index - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (jobs[mid].en <= jobs[index].st) {
                if (mid + 1 <= high && jobs[mid + 1].en <= jobs[index].st) {
                    low = mid + 1;
                } else {
                    return mid;
                }
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        job_scheduling s = new job_scheduling();
        int[] st = {1, 2, 3, 3};
        int[] en = {3, 4, 5, 6};
        int[] profit = {50, 10, 40, 70};

        int mp = s.scheduling(st, en, profit);
        System.out.println("Maximum profit: " + mp);
    }
}

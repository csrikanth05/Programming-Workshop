import java.util.Scanner;

public class string
{
    public static int min_edit(String w1, String w2) 
    {
        int m = w1.length();
        int n = w2.length();
        int[][] dp = new int[m + 1][n + 1];
        
        for (int i = 0; i <= m; i++) 
        {CLE
            for (int j = 0; j <= n; j++) 
            {
                if (i == 0) 
                {
                    dp[i][j] = j;
                }
                else if (j == 0) 
                {
                    dp[i][j] = i;
                }
                else if (w1.charAt(i - 1) == w2.charAt(j - 1)) 
                {
                    dp[i][j] = dp[i - 1][j - 1];
                }
                else 
                {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j - 1],
                                Math.min(dp[i - 1][j],
                                         dp[i][j - 1]));
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) 
    {
        Scanner s = new Scanner(System.in);
        String w1 = s.nextLine();
        String w2 = s.nextLine();
        
        int result = min_edit(w1, w2);
        System.out.println("Minimum number of operations: " + result);
    }
}

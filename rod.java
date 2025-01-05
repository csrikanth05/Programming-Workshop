public class rod
{
  public static int cut(int[] p)
  {
    int n = p.length;
    int[] dp = new int[n+1];
    for(int i = 1; i <= n; i++) 
    {
      for (int j = 1; j <=i; j++) 
      {
        dp[i] = Math.max(dp[i], p[j-1] + dp[i-j]);
      }
    }
    
    return dp[n];
  }
     
  public static void main(String[] args) 
  {
    int[] price = {3,5,8,9,10,17};
    System.out.println("Maximum obtainable value is " + cut(price));
  }
}

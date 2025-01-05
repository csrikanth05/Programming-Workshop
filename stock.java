public class stock
{
  public static int stock_profit(int prices[], int fee)
  {
    int s = prices.length;
    int profit = 0;
    int have = -1*prices[0];
    
    for(int i = 1; i<s; i++)
    {
      profit = Math.max(profit, have+prices[i]-fee);
      have = Math.max(have, profit-prices[i]);
    }
    return profit;
  }
  
  public static void main(String[]args)
  {
    int [] prices = {1,3,2,8,4,9};
    System.out.println("Maximum Profit: " + stock_profit(prices, 2));
  }
}

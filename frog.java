import java.util.Scanner;

public class frog
{
  static final int m = 1000000007;
  
  public static int count_paths(int n)
  {
    if (n==0)
       return 1;
    if (n==1)
       return 1;
    if (n==2)
       return 2;
       
    int [] dyn = new int[n+1];
    dyn[0] = 1;
    dyn[1] = 1;
    dyn[2] = 2;
    
    for(int i = 3; i<=n; i++)
    {
    dyn[i] = (dyn[i-1] + dyn[i-2] + dyn[i-3])%m;
    }
    return dyn[n];
  }
  
  public static void main(String [] args)
  {
    Scanner s = new Scanner(System.in);
    System.out.println("Total Steps: ");
    int n = s.nextInt();
    System.out.println("Total number of ways: " + count_paths(n));
  }
}
    

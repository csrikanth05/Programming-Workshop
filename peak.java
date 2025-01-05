import java.util.*;

public class peak 
{
    static int find(int ar[], int n)
    {
        if (n == 1)
            return 0;
        if (ar[0] >= ar[1])
            return 0;
        if (ar[n-1] >= ar[n - 2])
            return n-1;
            
        for (int i = 1; i < n-1; i++) 
        {
            if (ar[i] >= ar[i-1] && ar[i] >= ar[i+1])
                return i;
        }
        return 0;
    }
   
    public static void main(String[] args)
    {
        int ar[] = {10,20, 15, 2, 23, 90, 67 };
        int n = ar.length;
        System.out.println(ar[find(ar,n)]);
    }
}


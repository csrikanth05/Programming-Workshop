import java.util.*;

class party
{
	static void maxguest(int ar[], int ex[],int n) 
	{ 
	 Arrays.sort(ar);
	 Arrays.sort(ex);

	int gin = 1, maxg = 1, t = ar[0];
	int i = 1, j = 0;

	while (i < n && j < n)
	{
	    if (ar[i] <= ex[j])
	    {
	      gin++;
	      if (gin > maxg)
	      {
		      maxg = gin;
		      t = ar[i];
	      }
		    i++;
	    }
	    else
	    {
		    gin--;
		    j++;
	    }
	}

	System.out.println("Maximum Number of Guests = "+ maxg + " at t " +t);
	}
	public static void main(String[] args)
	{
		int ar[] = {1,2,9,5,5};
		int ex[] = {4,5,12,9,12};
		int n = ar.length;
		maxguest(ar, ex, n);
	}
}


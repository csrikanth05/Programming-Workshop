import java.io.*;
import java.lang.*;
import java.util.*;

class activity
{
    public static void max_activities(int s[], int f[], int n)
    {
        int i, j;
        int count = 1;
        i = 0;

        for (j = 1; j < n; j++) 
        {
            if (s[j] >= f[i]) 
            {
                i = j;
                count++;
            }
        }
        System.out.println("Maximum number of activities: " + count);
    }

    public static void main(String[] args)
    {
        int s[] = {1,3,2,5};
        int f[] = {2,4,3,6};
        int n = s.length;
        max_activities(s, f, n);
    }
}


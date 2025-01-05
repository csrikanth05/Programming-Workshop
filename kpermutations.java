import java.util.Scanner;

class kpermutation 
{
    public static void print(char[] a, int k) 
    {
        permute(a, 0, k);
    }

    public static void permute(char[] a, int start, int k) 
    {
        if (start == k) 
        {
            for (int i = 0; i < k; i++) 
            {
                System.out.print(a[i]);
            }
            System.out.print(" ");
            System.out.println();
        } 
        else 
        {
            for (int i = start; i < a.length; i++) 
            {
                swap(a, start, i);
                permute(a, start + 1, k);
                swap(a, start, i);
            }
        }
    }

    public static void swap(char[] a, int i, int j) 
    {
        char temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) 
    {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = s.nextInt();
        System.out.print("Enter k: ");
        int k = s.nextInt();

        if (k > n || n <= 0 || k <= 0) 
        {
            System.out.println("Invalid values for n or k.");
            return;
        }

        char[] a = new char[n];
        for (int i = 0; i < n; i++) 
        {
            a[i] = (char) ('a' + i);
        }
        print(a, k);
    }
}

package Practice;

import java.util.ArrayList;

public class KthODDEVEN {
    static int findK(int n, int k)
    {
        ArrayList<Integer> a = new ArrayList<Integer>(n);

        // insert all the odd
        // numbers from 1 to n.
        for (int i = 1; i < n; i++)
            if (i % 2 == 1)
                a.add(i);

        // insert all the even
        // numbers from 1 to n.
        for (int i = 1; i < n; i++)
            if (i % 2 == 0)
                a.add(i);

        return (a.get(k - 1));
    }

    // Driver code
    public static void main(String[] args)
    {
        int n = 10, k = 6;
        System.out.println(findK(n, k));
    }
}


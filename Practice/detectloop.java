package Practice;
import java.util.*;

public class detectloop {
    public static int minDays(int n) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        if (n <= 1)
            return n;
        if (map.containsKey(n))
            return map.get(n);
        int days = Math.min(minDays(n / 2) + n % 2 + 1, minDays(n / 3) + n % 3 + 1);
        map.put(n, days);
        return days;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ans = minDays(n);
        System.out.println(ans);
    }
}
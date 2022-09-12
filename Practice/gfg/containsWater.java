package Practice.gfg;

public class containsWater {
        public static int maxArea(int[] height) {
            int ans = 0;
            int l = 0;
            int r = height.length - 1;

            while (l < r) {
                int minHeight = Math.min(height[l], height[r]);
                ans = Math.max(ans, minHeight * (r - l));
                if (height[l] < height[r])
                    ++l;
                else
                    --r;
            }

            return ans;
        }

    public static void main(String[] args) {
        int arr[] = {6,5,4,8,6,9,2};
        int ans = maxArea(arr);
        System.out.println(ans);
    }
}

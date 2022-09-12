package Alpha.Arrays;

public class TrappedWater {
    public static int trappedRainWater(int height[] , int n){
        //Calculate Left Max Boundry - Arr
        int[] leftMaxBound = new int[n];
        leftMaxBound[0] = height[0];
        for (int i = 1; i < n; i++) {
            leftMaxBound[i] = Math.max(height[i] , leftMaxBound[i-1]);
        }

        //Calculate Right Max Boundry - Arr
        int[] rightMAxBound = new int[n];
        rightMAxBound[n-1] = height[n-1];
        for (int i = n-2 ; i >= 0 ; i--){
            rightMAxBound[i] = Math.max(height[i], rightMAxBound[i+1]);
        }
        //Loop
        int trappedRainWater = 0;
        for (int i = 0 ; i < n ; i++){
            //WaterLevel = min(L max Bound... , R max Bound.....)
            int waterlevel = Math.min(leftMaxBound[i], rightMAxBound[i]);
            //TrappedWater += waterLevel - Heght[i]
             trappedRainWater += waterlevel-height[i];
        }
        return trappedRainWater;
    }
    public static void main(String[] args) {
        int height[] = {4,2,0,3,2,5};
        int n = height.length;
        int ans = trappedRainWater(height , n);
        System.out.println(ans);
    }
}

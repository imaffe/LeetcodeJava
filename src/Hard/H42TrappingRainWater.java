package Hard;

import java.util.Arrays;

public class H42TrappingRainWater {
    public int trap(int[] height) {
        int len = height.length;
        int sum = 0 ;
        if (len == 0) return 0;
        for (int i = 0 ; i < len; i++) {
            sum += height[i];
        }

        // we count from both sides
        int max = 0;
        int maxLeft = 0;
        int maxRight = 0;
       for (int i = 0 ; i < len;i ++) {
           if(height[i] > max) {
               max = height[i];
               maxLeft = i;
               maxRight = i;
           } else if (height[i] == max) {
               maxRight = i;
           }
       }

       // left
       int curLeft = 0;
       int leftSum = 0;
       for (int i = 0; i < maxLeft; i++) {
           if (height[i] <= curLeft) {
               leftSum += curLeft;
           } else {
               curLeft = height[i];
               leftSum += curLeft;
           }
       }

       // middle
       int middleSum = (maxRight - maxLeft + 1) * max;

       int curRight = 0;
       int rightSum = 0;
       for (int i = len - 1; i > maxRight; i--) {
           if (height[i] <= curRight) {
               rightSum += curRight;
           } else {
               curRight = height[i];
               rightSum += curRight;
           }
       }

       return leftSum + middleSum + rightSum - sum;
    }
}

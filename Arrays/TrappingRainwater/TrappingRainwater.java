public class TrappingRainwater {
    public int trap(int[] height) {
        int n = height.length;
        if (n == 0) return 0;

        int[] leftMax = new int[n];
        int[] rightMax = new int[n];

        // Fill leftMax array - stores the max height to the left of current index
        leftMax[0] = height[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }

        // Fill rightMax array - stores the max height to the right of current index
        rightMax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }

        // Calculate water trapped at each index
        int water = 0;
        for (int i = 0; i < n; i++) {
            // Minimum of max heights on both sides minus current height
            water += Math.min(leftMax[i], rightMax[i]) - height[i];
        }

        return water;
    }
}

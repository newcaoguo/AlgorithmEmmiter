package com.company;

public class ContainerWithMostWater {
    /**
     * Initially
     * we consider the area constituting the exterior most lines.
     * Now, to maximize the area, we need to consider the area
     * between the lines of larger lengths.
     * If we try to move the pointer at the longer line inwards,
     * we won't gain any increase in area,
     * since it is limited by the shorter line.
     * But moving the shorter line's pointer
     * could turn out to be beneficial,
     * as per the same argument,
     * despite the reduction in the width.
     * This is done since a relatively longer line obtained
     * by moving the shorter line's pointer
     * might overcome the reduction in area caused by the width reduction.
     */
    public int maxArea(int[] height) {
        int maxarea = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            int tmparea = Math.min(height[left], height[right]) * (right - left);
            maxarea = Math.max(maxarea, tmparea);
            if (height[left] < height[right]) left++;
            else right--;
        }
        return maxarea;
    }

}

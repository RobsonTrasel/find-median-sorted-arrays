package com.robsonf;

public class Main {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int m = nums1.length;
        int n = nums2.length;
        int halfLen = (m + n + 1) / 2;
        int imin = 0, imax = m;

        while (imin <= imax) {
            int i = (imin + imax) / 2;
            int j = halfLen - i;

            if (i < m && nums2[j - 1] > nums1[i]) {
                imin = i + 1;
            } else if (i > 0 && nums1[i - 1] > nums2[j]) {
                imax = i - 1;
            } else {
                int maxLeft;
                if (i == 0) {
                    maxLeft = nums2[j - 1];
                } else if (j == 0) {
                    maxLeft = nums1[i - 1];
                } else {
                    maxLeft = Math.max(nums1[i - 1], nums2[j - 1]);
                }

                if ((m + n) % 2 == 1) {
                    return maxLeft;
                }

                int minRight;
                if (i == m) {
                    minRight = nums2[j];
                } else if (j == n) {
                    minRight = nums1[i];
                } else {
                    minRight = Math.min(nums1[i], nums2[j]);
                }

                return (maxLeft + minRight) / 2.0;
            }
        }

        throw new IllegalArgumentException("Arrays aren't sorted or valid");
    }

    public static void main(String[] args) {
        Main m = new Main();

        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        double result = m.findMedianSortedArrays(nums1, nums2);
        System.out.println("A mediana é: " + result);

        int[] nums1_2 = {1, 2};
        int[] nums2_2 = {3, 4};
        double result2 = m.findMedianSortedArrays(nums1_2, nums2_2);
        System.out.println("A mediana é: " + result2);
    }
}

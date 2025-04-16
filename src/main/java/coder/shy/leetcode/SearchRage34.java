package coder.shy.leetcode;

import java.util.Arrays;
import java.util.Collections;

public class SearchRage34 {
    public static void main(String[] args) {
        //int[] range = searchRange(new int[]{10, 10, 10, 10, 10}, 10);
        //System.out.println(Arrays.toString(range));

        int[] nums = new int[]{5, 7, 7, 8, 8, 10};
        int first = getBound(nums, 8, true);
        int last  = getBound(nums, 8, false);
        System.out.println(first + " " + last);
    }
    public static int getBound(int[] nums, int target, boolean first) {
        int low = 0;
        int high = nums.length - 1;
        int bound = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int value = nums[mid];
            if (value == target) {
                bound = mid;
                if(first) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else if (target < value) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return bound;
    }

    public static int[] searchRange(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int value = nums[mid];
            if (value == target) {
                return getRange(nums, target, mid);
            } else if (target < value) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return new int[]{-1, -1};
    }

    private static int[] getRange(int[] nums, int target, int mid) {
        int left = mid;
        int right = mid;
        for (int i = mid + 1; i <= nums.length - 1; i++) {
            if (nums[i] != target)
                break;
            right++;
        }
        for (int i = mid - 1; i >= 0; i--) {
            if (nums[i] != target)
                break;
            left--;
        }
        return new int[]{left, right};
    }
}

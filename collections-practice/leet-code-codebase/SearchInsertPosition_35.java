package week4;
import java.util.*;
public class SearchInsertPosition_35 {

	public static void main(String[] args) {
		int[] nums = {1,3,4,6};
		int target = 5;
		System.out.println(searchInsert(nums, target));
	}
	
    public static int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int mid = 0;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] > target) right = mid - 1;
            else left = mid + 1;
        }
        return left;
    }
}


package week4.part2;
import java.util.*;
public class SummaryRanges_228 {

	public static void main(String[] args) {
		int[] nums = {0, 1, 2, 4, 5, 7, 8, 9};
		
		System.out.println("sorted ranges: " + summaryRanges(nums));
	}
	
	public static List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < nums.length;) {
            int j = i + 1;
            while (j < nums.length && nums[j] - nums[j - 1] == 1) {
                j++;
            }
            if (nums[i] != nums[j-1]) {                
                list.add(nums[i] + "->" + nums[j-1]);
                i = j;
            }
            else list.add(nums[i++] + "");
        }
        return list;
    }
}


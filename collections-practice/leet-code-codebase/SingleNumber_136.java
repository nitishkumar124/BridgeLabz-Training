package week4.part2;
import java.util.*;
public class SingleNumber_136 {

	public static void main(String[] args) {
		int[] nums = {0,1,2,1,2};
		System.out.println("element NOT appearing twice: " + singleNumber(nums));
	}
	
	public static int singleNumber(int[] nums) {
        int num = 0;
        for (int i : nums) {
            num = num ^ i;
        }
        return num;
    }
}


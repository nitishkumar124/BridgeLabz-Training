package week9;
import java.util.*;

public class RangeSumQuerry_Immutable_303 {

    private int[] prefix;

    public RangeSumQuerry_Immutable_303(int[] nums) {
        prefix = new int[nums.length + 1];

        for (int i = 0; i < nums.length; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }
    }

    public int sumRange(int left, int right) {
        return prefix[right + 1] - prefix[left];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of the array : ");
        int n = sc.nextInt();

        int[] nums = new int[n];

        System.out.println("Enter the elements of the array : ");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        RangeSumQuerry_Immutable_303 solution =
                new RangeSumQuerry_Immutable_303(nums);

        System.out.print("Enter the left index : ");
        int left = sc.nextInt();

        System.out.print("Enter the right index : ");
        int right = sc.nextInt();

        int result = solution.sumRange(left, right);

        System.out.println("Sum of the range [" + left + ", " + right + "] is: " + result);

        sc.close();
    }
}

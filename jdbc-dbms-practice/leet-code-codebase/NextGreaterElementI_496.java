package week9;
import java.util.*;
public class NextGreaterElementI_496 {
	public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();

        for(int num : nums2){
            while(!stack.isEmpty() && stack.peek() < num){
                map.put(stack.pop(),num);
            }
            stack.push(num);
        }

        while(!stack.isEmpty()){
            map.put(stack.pop(), -1);
        }
        int[] result = new int[nums1.length];
        for(int i = 0; i < nums1.length; i++){
            result[i] = map.get(nums1[i]);
        }
        return result;
    }
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the size of the first array : ");
		int n1 = sc.nextInt();
		int[] nums1 = new int[n1];
		System.out.println("Enter the elements of the first array : ");
		for (int i = 0; i < n1; i++) {
			nums1[i] = sc.nextInt();
		}
		System.out.print("Enter the size of the second array : ");
		int n2 = sc.nextInt();
		int[] nums2 = new int[n2];
		System.out.println("Enter the elements of the second array : ");
		for (int i = 0; i < n2; i++) {
			nums2[i] = sc.nextInt();
		}
		NextGreaterElementI_496 solution = new NextGreaterElementI_496();
		int[] result = solution.nextGreaterElement(nums1, nums2);
		System.out.println("Next greater elements for nums1 in nums2: " + Arrays.toString(result));
		sc.close();
	}
}

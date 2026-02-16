package week9;
import java.util.*;
public class GroupAnagrams_49 {
	public List<List<String>> groupAnagrams(String[] strs){
		Map<String, List<String>> map = new HashMap<>();

		for (String str : strs) {
			char[] chars = str.toCharArray();
			Arrays.sort(chars);
			String sortedStr = new String(chars);

			if (!map.containsKey(sortedStr)) {
				map.put(sortedStr, new ArrayList<>());
			}
			map.get(sortedStr).add(str);
		}
		return new ArrayList<>(map.values());
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the number of strings : ");
		int n = sc.nextInt();
		sc.nextLine(); 
		String[] strs = new String[n];
		System.out.println("Enter the strings : ");
		for (int i = 0; i < n; i++) {
			strs[i] = sc.nextLine();
		}
		GroupAnagrams_49 solution = new GroupAnagrams_49();
		List<List<String>> result = solution.groupAnagrams(strs);
		System.out.println("Grouped Anagrams: " + result);
		sc.close();
	}
}

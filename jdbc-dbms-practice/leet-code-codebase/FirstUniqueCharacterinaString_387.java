package week9;

public class FirstUniqueCharacterinaString_387 {
	 public int firstUniqChar(String s) {
	        int[] freq = new int[26];  
	        
	        for(int i = 0; i < s.length(); i++){
	            freq[s.charAt(i) - 'a']++;
	        }
	        
	        for(int i = 0; i < s.length(); i++){
	            if(freq[s.charAt(i) - 'a'] == 1){
	                return i;
	            }
	        }
	        
	        return -1;
	    }
	public static void main(String[] args) {
		FirstUniqueCharacterinaString_387 solution = new FirstUniqueCharacterinaString_387();

		String s1 = "leetcode";
		System.out.println("Input: " + s1);
		System.out.println("Output: " + solution.firstUniqChar(s1)); 

		String s2 = "loveleetcode";
		System.out.println("Input: " + s2);
		System.out.println("Output: " + solution.firstUniqChar(s2)); 

		String s3 = "aabb";
		System.out.println("Input: " + s3);
		System.out.println("Output: " + solution.firstUniqChar(s3)); 
	}
}

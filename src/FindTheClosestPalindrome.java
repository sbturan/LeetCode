
public class FindTheClosestPalindrome {
	public static void main(String[] args) {
		System.out.println(nearestPalindromic("8997"));
	}
	public static String nearestPalindromic(String n) {
		char[] charArray = n.toCharArray();
		for(int i=n.length()/2-1;i>-1;i--) {
			if(charArray[i]!=charArray[n.length()-1-i]) {
				charArray[n.length()-1-i]=charArray[i];
			}
		}
		if(charArray[charArray.length/2]>'5') {
			roundUp(charArray);
		}
		return new String(charArray);
	}
	private static void roundUp(char[] charArray) {
		
	}
}


/*Given an integer n, find the closest integer (not including itself), which is a palindrome.

The 'closest' is defined as absolute difference minimized between two integers.

Example 1:
Input: "123"
Output: "121"
Note:
The input n is a positive integer represented by string, whose length will not exceed 18.
If there is a tie, return the smaller one as answer.*/
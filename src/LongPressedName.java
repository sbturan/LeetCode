
public class LongPressedName {
	public static void main(String[] args) {
		System.out.println(new LongPressedName().isLongPressedName("alexx", "alleex") );
	}
	public boolean isLongPressedName(String name, String typed) {

		int i = 0, j = 0;
		while (i < name.length() && j < typed.length()) {
			if (name.charAt(i) != typed.charAt(j)) {
				return false;
			}
			int k = i;
			while (k < name.length() && name.charAt(k) == name.charAt(i)) {
				k++;
			}
			int l = j;
			while (l < typed.length() && typed.charAt(l) == typed.charAt(j)) {
				l++;
			}
			if (k - i > l - j) {
				return false;
			}
			i = k;
			j = l;
		}
		return i == name.length() && j == typed.length();
	}
}

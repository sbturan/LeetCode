package inhertance;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ReorderDatainLogFiles {
	public static void main(String[] args) {
	//	String[] result = new ReorderDatainLogFiles().reorderLogFiles(new String[] {"j mo", "5 m w", "g 07", "o 2 0", "t q h"});
		String[] result = new ReorderDatainLogFiles().reorderLogFiles(new String[] {"dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"});
		for(String s:result) {
			System.out.println(s+" ");
		}
	}
	public String[] reorderLogFiles(String[] logs) {
		List<String> digits = new ArrayList<>();
		List<String> letters = new ArrayList<>();
		for (String s : logs) {
			String[] split = s.split(" ");
			if (Character.isDigit(split[1].charAt(0))) {
				digits.add(s);
			} else {
				letters.add(s);
			}
		}
		letters.sort(new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				String substr1=o1.substring(o1.indexOf(" ")+1);
				String substr2=o2.substring(o2.indexOf(" ")+1);
				if(substr1.equals(substr2)) {
					return o1.compareTo(o2);
				}
				return substr1.compareTo(substr2);
			}
			
		});
		letters.addAll(digits);
 		return letters.toArray(new String[0]);
	}
}

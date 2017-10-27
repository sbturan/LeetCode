public class JudgeRouteCircle {
	public boolean judgeCircle(String moves) {

		char[] charArray = moves.toCharArray();
		int ver = 0;
		int hor = 0;
		for (char c : charArray) {
			if (c == 'U') {
				hor++;
			} else if (c == 'D') {
				hor--;
			} else if (c == 'R') {
				ver++;
			} else {
				ver--;
			}
		}
		
		return ver==0&&hor==0;
	}
}

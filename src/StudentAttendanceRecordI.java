

public class StudentAttendanceRecordI {

	public static void main(String[] args) {

	}

	public boolean checkRecord(String s) {

		char[] charArray = s.toCharArray();
		
		int counta = 0;
		for (int i=0;i<charArray.length;i++) {
			
			char c=charArray[i];
			if (c == 'A') {
				if (counta == 1)
					return false;
				counta++;
			} else if (c == 'L') {
				 if(i>0&&i<charArray.length-1&&charArray[i-1]=='L'&&charArray[i+1]=='L')
					 return false;
			}
		}
		return true;
	}

}


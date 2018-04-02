
public class FirstBadVersion {
	public static void main(String[] args) {
		
		FirstBadVersion f=new FirstBadVersion();
		System.out.println(f.firstBadVersion(2));
	}

	public int firstBadVersion(int n) {
		return helper(1, n);
	}

	int helper(int left, int right) {
         if(left>=right) return left;
		int curIndex = left+(right-left)/2;
		boolean res = isBadVersion(curIndex);
		if (res) {
			return helper(1, curIndex);
		} else {
			return helper(curIndex + 1, right);
		}
	}
    
	boolean isBadVersion(int version) {
		boolean versions[] = new boolean[] { true, true};
		return versions[version-1];
	}
}

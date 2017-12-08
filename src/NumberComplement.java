
public class NumberComplement {
	public static void main(String[] args) {
		 NumberComplement nc=new NumberComplement();
		 System.out.println(nc.findComplement(1));
	}
	public int findComplement(int num) {
			return num^(int)(Math.pow(2,Integer.toBinaryString(num).length())-1);
         
	}
}

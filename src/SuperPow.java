import java.util.HashMap;

public class SuperPow {
	public static void main(String[] args) {
		SuperPow s=new SuperPow();
		System.out.println(s.superPow(2147483647, new int[] {2,0,0}));
		//System.out.println(s.superPow(3, new int[] {2,0,0}));
	}

    public int superPow(int a, int[] b) {
        return superPowerSub(a, b, b.length-1);
    }
    
    /* 递归方法
    a^[1,2,3,4] = pow(a^[1,2,3], 10) * pow(a, 4)
    a^[1,2,3] = pow(a^[1,2], 10) * pow(a, 3)
    a^[1,2] = pow(a^[1], 10) * pow(a, 2)
    a^[1] = pow(a, 1)
    */
    public int superPowerSub(int a, int[] b, int index) {
        if (index == 0)
            return pow(a, b[index]) % 1337;
        int pre = superPowerSub(a, b, index-1);
        return (pow(pre, 10) * pow(a, b[index])) % 1337;
    }
    
    
    public int pow(int x, int n) {
        if (n == 0)
            return 1;
        if (n == 1)
            return x % 1337;
        int half = pow(x, n/2); 
        if(n%2==0)  
            return (half*half) % 1337;  
        else  
            return (((half*half) % 1337) *(x % 1337)) % 1337; 
    }


}

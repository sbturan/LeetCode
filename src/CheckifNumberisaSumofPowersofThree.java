public class CheckifNumberisaSumofPowersofThree{
    public static void main(String[] args) {
        System.out.println(new CheckifNumberisaSumofPowersofThree().checkPowersOfThree(1));
    }
    public boolean checkPowersOfThree(int n) {
        int x=1;
        while(x*3<=n){
            x*=3;
        }
        return helper(n-x,x/3);
    }
    private boolean helper(int n,int three){
        if(n<0|| (three==0&&n>0))
            return false;
        if(n<2)
            return true;
        while(three>n){
            three/=3;
        }
        return helper(n-three,three/3);
    }
}

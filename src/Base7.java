
public class Base7 {
    public String convertToBase7(int num) {
        int number=Math.abs(num);
        StringBuilder sb=new StringBuilder("");
        while(number>0) {
        	sb.append(number%7);
        	number/=7;
        }
        if(num<0) sb.append("-");
        if(sb.length()==0) sb.append("0");
        return sb.reverse().toString();
    }
}

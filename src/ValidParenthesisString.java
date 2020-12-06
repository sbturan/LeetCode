import java.util.ArrayList;
import java.util.List;

public class ValidParenthesisString {
    public static void main(String[] args) {
        System.out.println(new ValidParenthesisString()
                .checkValidString("(())((())()()(*)(*()(())())())()()((()())((()))(*"));
        System.out.println(new ValidParenthesisString()
                .checkValidString("((*)"));

    }
    public boolean checkValidString(String s) {
        List<Integer> starIndexes=new ArrayList<>();
        List<Integer> openIndexes=new ArrayList<>();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c=='('){
                openIndexes.add(i);
            }else if(c==')'){
                if(openIndexes.isEmpty()){
                    if(starIndexes.isEmpty()){
                        return false;
                    }
                    starIndexes.remove(starIndexes.size()-1);
                }else{
                    openIndexes.remove(openIndexes.size()-1);
                }
            }else{
                starIndexes.add(i);
            }
        }
        if(openIndexes.size()==0)
            return true;
        for(int i=openIndexes.size()-1;i>-1;i--){
            if(starIndexes.isEmpty() || openIndexes.get(i)>starIndexes.get(starIndexes.size()-1))
                return false;
            starIndexes.remove(starIndexes.size()-1);
        }
        return true;
    }
}

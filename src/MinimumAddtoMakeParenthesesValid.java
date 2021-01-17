public class MinimumAddtoMakeParenthesesValid {
    public int minAddToMakeValid(String S) {
      int result=0;
      int state=0;
      for(int i=0;i<S.length();i++){
          if(S.charAt(i)=='('){
              state++;
          }else{
              if(state==0){
                  result++;
              }else{
                  state--;
              }
          }
      }
      return result+state;
    }
}

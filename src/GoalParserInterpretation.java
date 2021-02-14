public class GoalParserInterpretation {
    public String interpret(String command) {
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<command.length();i++){
            char c = command.charAt(i);
            if(c =='G'){
                sb.append(c);
            }else if(c==')'){
                if(command.charAt(i-1)=='('){
                    sb.append('o');
                }else{
                    sb.append("al");
                }
            }
        }
        return sb.toString();
    }
}

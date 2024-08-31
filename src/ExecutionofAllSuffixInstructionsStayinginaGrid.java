public class ExecutionofAllSuffixInstructionsStayinginaGrid {
    public static void main(String[] args) {
        System.out.println(new ExecutionofAllSuffixInstructionsStayinginaGrid().executeInstructions(
                3,
                new int[]{0,1},
                "RRDDLU"
        ));
    }
    public int[] executeInstructions(int n, int[] startPos, String s) {
        int[] result=new int[s.length()];
        for(int i=0;i<result.length;i++){
            int x=startPos[0];
            int y=startPos[1];
            int j=i;
            while(j<s.length()&&x<n&&y<n&&x>-1&&y>-1){
                char c=s.charAt(j);
                if(c=='R'){
                    y++;
                }else if (c=='L'){
                    y--;
                }else if(c=='U'){
                    x--;
                }else{
                    x++;
                }
                j++;
            }
            result[i]=j-i;
        }
        return result;
    }
}

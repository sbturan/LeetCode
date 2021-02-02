public class PushDominoes {
    public static void main(String[] args) {
        System.out.println(new PushDominoes().pushDominoes(".L.R...LR..L.."));
    }
    public String pushDominoes(String dominoes) {
        int N = dominoes.length();
        int[] right=new int[N];
       int riDes=0;
       for(int i = 0; i< N; i++){
           char cur = dominoes.charAt(i);
           if(cur =='L'){
                riDes=0;
            }else if(cur=='R'){
               riDes=N;
           }else {
               riDes--;
           }
           right[i]=riDes;
       }
       char[] result=new char[N];
       int leDes=0;
       for(int i = N -1; i>-1; i--){
           char cur = dominoes.charAt(i);
           if(cur =='L'){
               leDes=N;
           }else if(cur=='R'){
               leDes=0;
           }else {
               leDes--;
           }
           result[i]='.';
           if (right[i]>0 && right[i] > leDes ) {
               result[i]='R';
           }else if( leDes>0 && leDes > right[i]){
               result[i]='L';
           }
       }

       return String.valueOf(result);
    }
}

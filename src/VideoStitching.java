public class VideoStitching {
    public static void main(String[] args) {
        System.out.println(new VideoStitching()
        .videoStitching(new int[][]{{16,18},{16,20},{3,13},{1,18},{0,8},{5,6},{13,17},{3,17},{5,6}},15));
//        System.out.println(new VideoStitching()
//                .videoStitching(new int[][]{{0,1},{1,2}},5));
    }
    public int videoStitching(int[][] clips, int T) {
       int[] arr=new int[T+1];
       for(int i[]:clips){
           if(i[0]<=T)
           arr[i[0]]=Math.max(arr[i[0]],i[1]);
       }
       int result=0;
       int cur=0,before=-1;
       while(cur<T){
           int max=0;
           int temp=cur;
           while(temp>before ){
               max= Math.max(max,arr[temp]);
               temp--;
           }
           if(max==0)
               return -1;
           before=cur;
           cur=max;
           result++;
       }
       return result;
    }
}

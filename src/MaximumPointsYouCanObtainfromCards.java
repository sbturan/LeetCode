public class MaximumPointsYouCanObtainfromCards {
    public static void main(String[] args) {
        System.out.println(new MaximumPointsYouCanObtainfromCards()
        .maxScore(new int[]{96,90,41,82,39,74,64,50,30},8));
    }
    public int maxScore(int[] cardPoints, int k) {
         int remain=cardPoints.length-k;
         int total=0;
         int min=Integer.MAX_VALUE;
         int cur=0,i=0,j=0;
         while(j<cardPoints.length){
             if(j-i==remain){
                 min= Math.min(min,cur);
                 cur-=cardPoints[i++];
             }
             total+=cardPoints[j];
             cur+=cardPoints[j++];
         }
        if(j-i==remain){
            min= Math.min(min,cur);
        }
         return total-min;
    }
}

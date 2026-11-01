public class MaximumNumberofEatenApples {
    public static void main(String[] args) {
        new MaximumNumberofEatenApples().eatenApples(new int[]{3,0,0,0,0,2},new int[]{3
                ,0,0,0,0,2});
    }

    public int eatenApples(int[] apples, int[] days) {
        int[] rotDays=new int[20001];
        int cur=0;
        int result=0;
        int i=0;
        while(i<apples.length||cur>0){
            if(i<apples.length)
                cur+=apples[i];
            cur-=rotDays[i];
            if(i<apples.length&&days[i]+i<rotDays.length)
                rotDays[days[i]+i]+=apples[i];
            if(cur>0){
                result++;
                cur--;
            }
            i++;
        }

        return result;
    }
}

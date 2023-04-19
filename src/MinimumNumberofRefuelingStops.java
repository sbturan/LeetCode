public class MinimumNumberofRefuelingStops {
    public static void main(String[] args) {
        System.out.println(new MinimumNumberofRefuelingStops().minRefuelStops(100,1,new int[][]{{10,100}}));

    }
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        if(startFuel>=target)
            return 0;
        int sIndex=stations.length==0?-1:0;
        if(sIndex==-1 || stations[0][0]>startFuel)
            return -1;
        int result=helper(target,0,startFuel,sIndex,stations);
        return result==Integer.MAX_VALUE?-1:result;
    }
    private int helper(int target,int current,int fuel,int sIndex,int[][] stations){
        if(current+fuel>=target){
            return 0;
        }
        if( sIndex>=stations.length||sIndex==-1||fuel<0){
            return Integer.MAX_VALUE;
        }
        int result=helper(target,stations[sIndex][0],fuel-stations[sIndex][0]+(sIndex==0?0:stations[sIndex-1][0]),sIndex+1,stations);
        int r2=helper(target,stations[sIndex][0],fuel-stations[sIndex][0]+(sIndex==0?0:stations[sIndex-1][0])+stations[sIndex][1],sIndex+1,stations);
        if(r2!=Integer.MAX_VALUE)
            r2++;
        return Math.min(result,r2);
    }
}

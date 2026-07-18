public class CarFleetII {
    public static void main(String[] args) {
        System.out.println(new CarFleetII().getCollisionTimes(
                new int[][]{{3,4},{5,4},{6,3},{9,1}}
        ));
    }

    public double[] getCollisionTimes(int[][] cars) {
        double[] result=new double[cars.length];
        result[result.length-1]=-1;
        double[] nextGroup=new double[]{cars[cars.length-1][0],cars[cars.length-1][1]};
        for(int i=cars.length-2;i>-1;i--){
            double timeToNextGroup=Integer.MAX_VALUE;
            double timeToNextCar=Integer.MAX_VALUE;
            if(cars[i][1]>cars[i+1][1]){
                timeToNextCar=1d*(cars[i+1][0]-cars[i][0])/(cars[i][1]-cars[i+1][1]);
            }
            if(cars[i][1]>nextGroup[1]){
                timeToNextGroup=1d*(nextGroup[0]-cars[i][0])/(cars[i][1]-nextGroup[1]);
            }
            if(timeToNextGroup==Integer.MAX_VALUE && timeToNextCar==Integer.MAX_VALUE){
                nextGroup[0]=cars[i][0];
                nextGroup[1]=cars[i][1];
                result[i]=-1;
            }else if(timeToNextGroup>timeToNextCar){
                result[i]=timeToNextCar;
                nextGroup[0]=(cars[i][1]*timeToNextCar)+cars[i][0];
            }else{
                result[i]=timeToNextGroup;
                nextGroup[0]=(cars[i][1]*timeToNextGroup)+cars[i][0];
            }
        }
        return result;
    }
}

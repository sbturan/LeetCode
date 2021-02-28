public class AverageWaitingTime {
    public static void main(String[] args) {
        System.out.println(new AverageWaitingTime()
        .averageWaitingTime(new int[][]{{1,2},{2,5},{4,3}}));
    }
    public double averageWaitingTime(int[][] customers) {
        double total=0;
        int currentTime=0;
        for(int i=0;i< customers.length;i++){
            currentTime= Math.max(currentTime,customers[i][0]);
            currentTime+=customers[i][1];
            total+=currentTime-customers[i][0];
        }
        return total/(customers.length*1d);
    }
}

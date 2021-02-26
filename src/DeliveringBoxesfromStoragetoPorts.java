import java.util.ArrayList;
import java.util.List;

public class DeliveringBoxesfromStoragetoPorts {
    public static void main(String[] args) {
        System.out.println(new DeliveringBoxesfromStoragetoPorts()
        .boxDelivering(new int[][]{{2,4},{2,5},{3,1},{3,2},{3,7},{3,1},{4,4},{1,3},{5,2}},
                5,5,7));
    }
    public int boxDelivering(int[][] boxes, int portsCount, int maxBoxes, int maxWeight) {
        List<int[]> mergedBoxes=new ArrayList<>();
        int i=0;
        while(i<boxes.length){
            int total=boxes[i][1];
            int j=i+1;
            while (j<boxes.length && boxes[i][0]==boxes[j][0] && j-i+1<=maxBoxes && total+boxes[j][1]<=maxWeight){
                total+=boxes[j][1];
                j++;
            }
            mergedBoxes.add(new int[]{boxes[i][0],total,j-i});
            i=j;
        }
        int result=0;
        int curWeight=0;
        int curCount=0;
        int prevPort=-1;
        for( i=0;i<mergedBoxes.size();i++){
            int[] curBox = mergedBoxes.get(i);
            curWeight+=curBox[1];
            curCount+=curBox[2];
             if(curBox[0]!=prevPort)
                 result++;
             prevPort=curBox[0];
            if(i==mergedBoxes.size()-1 || curWeight+mergedBoxes.get(i + 1)[1]>maxWeight || curCount+mergedBoxes.get(i + 1)[2]>maxBoxes){
                result+=1;
                curWeight=0;
                curCount=0;
                prevPort=-1;
            }
        }
        return result;
    }


}

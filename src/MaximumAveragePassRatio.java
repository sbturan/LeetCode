import java.util.Comparator;
import java.util.PriorityQueue;

public class MaximumAveragePassRatio {
    public static void main(String[] args) {
        System.out.println(new MaximumAveragePassRatio().maxAverageRatio(new int[][]{{1,2},{3,5},{2,2}},2));
    }
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<int[]> q=new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                double diffo1=(((o1[0]+1)*1d)/(o1[1]+1))-
                        (((o1[0])*1d)/(o1[1]));
                double diffo2=(((o2[0]+1)*1d)/(o2[1]+1))-
                        (((o2[0])*1d)/(o2[1]));
                return Double.compare(diffo2,diffo1);
            }
        });
        for(int[] i:classes)
            q.add(i);
        for(int i=1;i<=extraStudents;i++){
            int[] poll = q.poll();
            poll[0]++;
            poll[1]++;
            q.add(poll);
        }
        double total=0;
        for(int[] i:q)
            total+=(i[0]*1d)/(i[1]);
        return total/classes.length;
    }
}

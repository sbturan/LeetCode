import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathwithAlternatingColors {
    // unresolved
    public static void main(String[] args) {
        Arrays.stream(new ShortestPathwithAlternatingColors().shortestAlternatingPaths(
                6,new int[][]{{3,4},{1,5},{1,0},{5,3},{2,1},{2,0},{0,3},{1,2},{5,2},{1,4},{1,3},{5,0},{4,5},{5,5},{3,3}},
                new int[][]{{2,5},{3,0},{1,2},{4,3},{3,4},{0,4},{5,0},{5,2},{1,0},{0,2}}
        )).forEach(i-> System.out.print(i+ " "));
    }
    public int[] shortestAlternatingPaths(int n, int[][] red_edges, int[][] blue_edges) {
        HashSet[] red=new HashSet[n];
        HashSet[] blue=new HashSet[n];
        Integer[][] dpRed=new Integer[n][n];
        Integer[][] dpBlue=new Integer[n][n];
        for(int i[]:red_edges){
            if(red[i[0]]==null){
                red[i[0]]=new HashSet<Integer>();
            }
            red[i[0]].add(i[1]);
        }
        for(int i[]:blue_edges){
            if(blue[i[0]]==null){
                blue[i[0]]=new HashSet<Integer>();
            }
            blue[i[0]].add(i[1]);
        }

        int[] result=new int[n];

        for(int i=1;i<n;i++){
            boolean isRed=true;
            for(int j=0;j<2;j++){
                isRed=!isRed;
                Queue q=new LinkedList(isRed?red[0]:blue[0]);
                int level=0;
                boolean reached=false;
                boolean curRed=isRed;
                while (q.isEmpty()&&!reached){
                    level++;
                    int size=q.size();

                    for(int k=0;k<size;k++){

                    }
                }
                if(reached)
                    result[i]=level;
                else
                    result[i]=-1;
            }
        }
       return result;
    }

}

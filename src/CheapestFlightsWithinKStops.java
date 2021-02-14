import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CheapestFlightsWithinKStops {
    public static void main(String[] args) {
        System.out.println(new CheapestFlightsWithinKStops().
                findCheapestPrice(3,new int[][]{{0,1,100},{1,0,50},{1,2,100},{0,2,500}},0,2,1));
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        ArrayList<int[]>[] arr=new ArrayList[n];
        for(int i=0;i<flights.length;i++){
            if(arr[flights[i][0]]==null)
                arr[flights[i][0]]=new ArrayList<int[]>();
            arr[flights[i][0]].add(new int[]{flights[i][1],flights[i][2]});
        }
        int level=0;
        Queue<int[]> q=new LinkedList<>();
        if(arr[src]==null)
            return -1;
        for(int i=0;i<arr[src].size();i++){
            int[] cur=arr[src].get(i);
            q.add(new int[]{cur[0],cur[1]});
        }
        int result=Integer.MAX_VALUE;
        Integer[] visited=new Integer[n];
        while(!q.isEmpty()&&level<=K){
             int size=q.size();
             for(int i=0;i<size;i++){
                 int[] poll = q.poll();
                 if(poll[0]==dst){
                     result=Math.min(result,poll[1]);
                 }else if(arr[poll[0]]!=null){
                     ArrayList<int[]> dest = arr[poll[0]];
                     for(int[] j:dest){
                         if(visited[j[0]]==null ||visited[j[0]]>j[1]+poll[1]){
                             q.add(new int[]{j[0],j[1]+poll[1]});
                             visited[j[0]]=j[1]+poll[1];
                         }

                     }
                 }
             }
            level++;
        }
        return result==Integer.MAX_VALUE?-1:result;
    }
}

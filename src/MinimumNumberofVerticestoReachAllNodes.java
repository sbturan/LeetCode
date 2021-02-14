import java.util.*;

public class MinimumNumberofVerticestoReachAllNodes {
    public static void main(String[] args) {
        System.out.println(new MinimumNumberofVerticestoReachAllNodes()
        .findSmallestSetOfVertices(6, Arrays.asList(Arrays.asList(0,1),Arrays.asList(0,2),Arrays.asList(2,5),Arrays.asList(3,4),Arrays.asList(4,2))//new int[][]{{0,1},{0,2},{2,5},{3,4},{4,2}}
        ));
    }
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        boolean[] reachable=new boolean[n];
        for(List<Integer> i:edges){
            reachable[i.get(1)]=true;
        }
        List<Integer> result=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(!reachable[i])
                result.add(i);
        }
        return result;
    }
}
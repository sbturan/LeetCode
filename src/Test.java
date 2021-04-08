import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;

public class Test {
    public static int[] GetMaxSum(int a[]) {
        int total = 0;
        int result = 0;
        int i = 0;
        int maxI = 0, maxJ = 0;
        int j = 0;
        while (j < a.length) {
            total += a[j];
            if (total < 0) {
                i = j + 1;
                total = 0;
            }
            if (total > result) {
                result = total;
                maxI = i;
                maxJ = j;
            }
            j++;
        }
        int resultArr[] = new int[maxJ - maxI + 1];
        System.arraycopy(a, maxI, resultArr, 0, resultArr.length);
        return resultArr;
    }

    // Driver code
    public static void main(String args[]) {
        /*Arrays.stream(GetMaxSum(new int[]{1, -2, 2, 4, 5, -1, 10, -5})).forEach(i -> System.out.print(i + " "));
        System.out.println();*/
//        longestSubarray(new int[]{10,1,2,4,7,2},5);
        //System.out.println(removeDuplicates("yfttttfbbbbnnnnffbgffffgbbbbgssssgthyyyy",4));



    }
    public static int longestSubarray(int[] A, int limit) {
        Deque<Integer> maxd = new ArrayDeque<>();
        Deque<Integer> mind = new ArrayDeque<>();
        int i = 0, j;
        for (j = 0; j < A.length; ++j) {
            while (!maxd.isEmpty() && A[j] > maxd.peekLast()) maxd.pollLast();
            while (!mind.isEmpty() && A[j] < mind.peekLast()) mind.pollLast();
            maxd.add(A[j]);
            mind.add(A[j]);
            if (maxd.peek() - mind.peek() > limit) {
                if (maxd.peek() == A[i]) maxd.poll();
                if (mind.peek() == A[i]) mind.poll();
                ++i;
            }
        }
        return j - i;
    }

    class Node{
        int x;
        int y;
        int powTotal;
        public Node(int x,int y){
            this.x=x;
            this.y=y;
            this.powTotal=(int)(Math.pow(x,2)+Math.pow(y,2));
        }
    }
    public int[][] kClosest(int[][] points, int k) {
        // max x^2 + y^2
        PriorityQueue<Node> q=new PriorityQueue<Node>((i, j)->j.powTotal-i.powTotal);
        for(int[] i:points){
            Node cur=new Node(i[0],i[1]);
            if(q.size()<k){
                q.add(cur);
            }else if(q.peek().powTotal>cur.powTotal){
                q.poll();
                q.add(cur);
            }
        }
        int[][] result=new int[k][2];
        for(int i=0;i<k;i++){
            Node cur=q.poll();
            result[i]=new int[]{cur.x,cur.y};
        }
        return result;

    }
}
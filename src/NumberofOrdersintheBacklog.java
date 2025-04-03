import java.util.PriorityQueue;

public class NumberofOrdersintheBacklog {
    public static void main(String[] args) {
        System.out.println(new NumberofOrdersintheBacklog().getNumberOfBacklogOrders(
                new int[][]{{26,7,0},{16,1,1},{14,20,0},{23,15,1},{24,26,0},{19,4,1},{1,1,0}}
        ));
    }

    public int getNumberOfBacklogOrders(int[][] orders) {
        PriorityQueue<int[]> sells=new PriorityQueue<>((i, j)->i[0]-j[0]);
        PriorityQueue<int[]> buys=new PriorityQueue<>((i,j)->j[0]-i[0]);
        for(int o[]:orders){
            if(o[2]==0){
                if(sells.isEmpty()||sells.peek()[0]>o[0]){
                    buys.add(o);
                }else{
                    int rem=o[1];
                    int[] current=sells.peek();
                    while(rem>0&&current!=null&&current[0]<=o[0]){
                        sells.poll();
                        if(rem>=current[1]){
                            rem-=current[1];
                            current=sells.peek();
                        }else{
                            current[1]-=rem;
                            sells.add(current);
                            rem=0;
                        }
                    }
                    if(rem>0){
                        buys.add(new int[]{o[0],rem,0});
                    }
                }
            }else{
                if(buys.isEmpty()||buys.peek()[0]<o[0]){
                    sells.add(o);
                }else{
                    int rem=o[1];
                    int[] current=buys.peek();
                    while(rem>0&&current!=null&&current[0]>=o[0]){
                        buys.poll();
                        if(rem>=current[1]){
                            rem-=current[1];
                            current=buys.peek();
                        }else{
                            current[1]-=rem;
                            buys.add(current);
                            rem=0;
                        }
                    }
                    if(rem>0){
                        sells.add(new int[]{o[0],rem,1});
                    }
                }
            }
        }
        long result=0;
        for(int i[]:sells){
            result+=i[1]*1L;
        }
        for(int i[]:buys){
            result+=i[1];
        }

        return (int)(result%1000000007);
    }
}

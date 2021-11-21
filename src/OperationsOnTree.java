import java.util.ArrayList;
import java.util.List;

public class OperationsOnTree {
    // ["LockingTree","lock","unlock","unlock","lock","upgrade","lock"]
      //      [[[-1,0,0,1,1,2,2]],[2,2],[2,3],[2,2],[4,5],[0,1],[0,1]]
    public static void main(String[] args) {
        LockingTree lockingTree = new OperationsOnTree().new LockingTree(new int[]{-1,0,0,1,1,2,2});
        lockingTree.lock(2,2);
        lockingTree.unlock(2,3);
        lockingTree.unlock(2,2);
        lockingTree.lock(4,5);
        lockingTree.upgrade(0,1);
        lockingTree.lock(0,1);
    }
    class LockingTree {
        private int[] locked ;
        private List[] leafs;
        private int[] case2;
        private int[] parent;
        public LockingTree(int[] parent) {
            locked=new int[parent.length];
            leafs=new List[parent.length];
            case2=new int[parent.length];
            this.parent=parent;
            for(int i=0;i<locked.length;i++){
                locked[i]=-1;
            }
            boolean seen[]=new boolean[parent.length];
            for(int i:parent){
                if(i>-1)
                    seen[i]=true;
            }
            for(int i=0;i<seen.length;i++){
                if(!seen[i] && parent[i]>-1){
                    fillPaths(i,parent[i],parent);
                }
            }
        }
        private void fillPaths(int leaf,int curNode,int[] parents){
            if(leafs[curNode]==null){
                leafs[curNode]=new ArrayList();
            }
            leafs[curNode].add(leaf);
            if (parents[curNode]!=-1) {
                fillPaths(leaf,parents[curNode],parents);
            }
        }

        public boolean lock(int num, int user) {
            if(locked[num]==-1){
                locked[num]=user;
                int cur = parent[num];
                while(cur>-1){
                    case2[cur]++;
                    cur=parent[cur];
                }
                return true;
            }

            return false;
        }

        public boolean unlock(int num, int user) {
            if(user!=-2 && locked[num]!=user)
                return false;
            locked[num]=-1;
            int cur = parent[num];
            while(cur>-1){
                case2[cur]--;
                cur=parent[cur];
            }
            return true;
        }

        public boolean upgrade(int num, int user) {
            if(locked[num]>-1)
                return false;
            if(case2[num]<1)
                return false;
            int cur = parent[num];
            while(cur>-1){
                if(locked[cur]>-1)
                    return false;
                cur=parent[cur];
            }

            List<Integer >leaf = leafs[num];
            lock(num,user);
            for(int i:leaf){
                cur=i;
                while(cur!=num){
                    unlock(cur,-2);
                    cur=parent[cur];
                }
            }
            return true;
        }
    }
}

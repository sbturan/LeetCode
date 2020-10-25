import java.util.HashMap;
import java.util.Map;

public class SnapshotArray {
    public static void main(String[] args) {
        SnapshotArray sa =new SnapshotArray(1);
        sa.set(0,15);
        sa.snap();
        sa.snap();
        sa.snap();
        System.out.println(sa.get(0,2));
    }
    Map<Integer,Map<Integer,Integer>> snaps;

    int snapcnt=0;
    public SnapshotArray(int length) {

        snaps=new HashMap<>();
        snaps.put(snapcnt,new HashMap<>());

    }

    public void set(int index, int val) {

        snaps.get(snapcnt).put(index,val);


    }

    public int snap() {


        Map<Integer,Integer> map=new HashMap<>();
        map.putAll(snaps.get(snapcnt));
        snapcnt++;

        snaps.put(snapcnt,map);


        return snapcnt-1;
    }

    public int get(int index, int snap_id) {
        Integer i=snaps.get(snap_id).get(index);
        if(i==null)
        {
            return 0;
        }
        return  i;
    }
}

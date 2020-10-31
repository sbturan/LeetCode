import java.util.ArrayList;

public class RecentCounter {
    int startIndex = 0;
    ArrayList<Integer> list;

    public RecentCounter() {
        list = new ArrayList<>();
    }

    public int ping(int t) {
        list.add(t);
        while (t - list.get(startIndex) > 3000) {
            startIndex++;
        }
        return list.size() - startIndex;
    }
}

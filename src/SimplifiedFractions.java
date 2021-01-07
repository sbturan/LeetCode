import java.util.ArrayList;
import java.util.List;

public class SimplifiedFractions {
    public static void main(String[] args) {
        System.out.println(new SimplifiedFractions().simplifiedFractions(8));
    }
    public List<String> simplifiedFractions(int n) {
        boolean[] added=new boolean[10000];
        List<String> result = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                int num = i * 10000 / j;
                if(!added[num]){
                    result.add(i + "/" + j);
                    added[num]=true;
                }
            }
        }
        return result;
    }
}

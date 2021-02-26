import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FilterRestaurantsbyVeganFriendlyPriceAndDistance {
    public List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {
        List<int[]> result = new ArrayList<>();
        for (int i[] : restaurants) {
            if (i[3] <= maxPrice && i[4] <= maxDistance && (i[2] & veganFriendly) == veganFriendly) {
                result.add(new int[]{i[0], i[1]});
            }
        }
        Collections.sort(result, ((o1, o2) -> o1[1] == o2[1] ? o2[0] - o1[0] : o2[1] - o1[1]));
        List<Integer> resultInt = new ArrayList<>();
        for (int i = 0; i < result.size(); i++) {
            resultInt.add(result.get(i)[0]);
        }
        return resultInt;
    }
}

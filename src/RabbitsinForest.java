
public class RabbitsinForest {
	public int numRabbits(int[] answers) {

		if (answers == null || answers.length == 0)
			return 0;
		int[] count = new int[1001];
		int ret = 0, max = 0;
		for (int a : answers) {
			max = Math.max(a, max);
			count[a]++;
		}
		for (int i = 0; i <= max; i++) {
			if (count[i] != 0)
				ret += (i + 1) * ((count[i] - 1) / (i + 1) + 1);
		}
		return ret;
	}
}
/*
 * Examples: Input: answers = [1, 1, 2] Output: 5 Explanation: The two rabbits
 * that answered "1" could both be the same color, say red. The rabbit than
 * answered "2" can't be red or the answers would be inconsistent. Say the
 * rabbit that answered "2" was blue. Then there should be 2 other blue rabbits
 * in the forest that didn't answer into the array. The smallest possible number
 * of rabbits in the forest is therefore 5: 3 that answered plus 2 that didn't.
 * 
 * Input: answers = [10, 10, 10] Output: 11
 * 
 * Input: answers = [] Output: 0
 */

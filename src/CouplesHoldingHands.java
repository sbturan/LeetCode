public class CouplesHoldingHands {
    public static void main(String[] args) {
        System.out.println(new CouplesHoldingHands().miniSwapsArray(
                new int[]{0,2,4,6,7,1,3,5}
        ));
    }
    public int miniSwapsArray(int[] row) {
        int result = 0;
        int[] pos = new int[row.length];
        for (int i = 0; i < row.length; i++) {
            pos[row[i]] = i;
        }
        for (int i = 0; i < row.length; i += 2) {
            int pair = (row[i] &1)==0 ? (row[i] + 1) : (row[i] - 1);
            if (row[i + 1] != pair) {
                row[pos[pair]] = row[i + 1];
                pos[row[i + 1]] = pos[pair];
                result++;
            }
        }
        return result;
    }

}

public class MinimumCosttoMoveChipstoTheSamePosition {
    public int minCostToMoveChips(int[] position) {
        int odds = 0;
        for (int i = 0; i < position.length; i++) {
            odds+=position[i] & 1;
        }
        return Math.min(odds, position.length - odds);
    }
}

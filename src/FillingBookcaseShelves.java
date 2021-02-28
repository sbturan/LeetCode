public class FillingBookcaseShelves {
    public int minHeightShelves(int[][] books, int shelf_width) {
        return helper(books, shelf_width, 0, 0, 0, new Integer[books.length]);
    }

    private int helper(int[][] books, int shelf_width, int index, int currentWidth, int currentHeight, Integer dp[]) {
        if (index == books.length) {
            return 0;
        }
        int result = Integer.MAX_VALUE;
        int[] curBook = books[index];
        if (currentWidth + curBook[0] <= shelf_width) {
            int heightDiff = currentHeight >= curBook[1] ? 0 : curBook[1] - currentHeight;
            result = helper(books, shelf_width, index + 1, currentWidth + curBook[0], currentHeight + heightDiff, dp) + heightDiff;
        }
        if(dp[index]==null){
            dp[index]= helper(books, shelf_width, index + 1, curBook[0], curBook[1], dp) + curBook[1];
            result= Math.min(result,dp[index]);
        }else{
            result= Math.min(result,dp[index]);
        }
        return result;
    }

}

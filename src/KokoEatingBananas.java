public class KokoEatingBananas {
    public static void main(String[] args) {
        System.out.println(new KokoEatingBananas().minEatingSpeed(new int[]{332484035,524908576,855865114,632922376,222257295,690155293,112677673,679580077,337406589,290818316,877337160,901728858,679284947,688210097,692137887,718203285,629455728,941802184},
                823855818));
        System.out.println(new KokoEatingBananas().minEatingSpeed2(new int[]{332484035,524908576,855865114,632922376,222257295,690155293,112677673,679580077,337406589,290818316,877337160,901728858,679284947,688210097,692137887,718203285,629455728,941802184},
                823855818));

    }
    public int minEatingSpeed2(int[] piles, int h) {
        // Initalize the left and right boundaries
        int left = 1, right = 1;
        for (int pile : piles) {
            right = Math.max(right, pile);
        }

        while (left < right) {
            System.out.println(2+" "+left+" "+right);
            // Get the middle index between left and right boundary indexes.
            // hourSpent stands for the total hour Koko spends.
            int middle = (left + right) / 2;
            int hourSpent = 0;

            // Iterate over the piles and calculate hourSpent.
            // We increase the hourSpent by ceil(pile / middle)
            for (int pile : piles) {
                hourSpent += Math.ceil((double) pile / middle);
            }

            // Check if middle is a workable speed, and cut the search space by half.
            if (hourSpent <= h) {
                right = middle;
            } else {
                left = middle + 1;
            }
        }

        // Once the left and right boundaries coincide, we find the target value,
        // that is, the minimum workable eating speed.
        return right;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int max=-1;
        for(int i:piles){
            max=Math.max(i,max);
        }

        return binarySearch(piles,h,1,max);
    }
    private int binarySearch(int[] piles, int h,int start,int end){
        System.out.println(start + " "+ end);
        if(start>=end)
            return end;
        int mid=(start+end)/2;
        if(canEatWithSpeed(piles,h,mid)){
            return binarySearch(piles,h,start,mid);
        }
        return binarySearch(piles,h,mid+1,end);
    }
    private boolean canEatWithSpeed(int[] piles, int h,int k){
        int hourSpent = 0;

        // Iterate over the piles and calculate hourSpent.
        // We increase the hourSpent by ceil(pile / middle)
        for (int pile : piles) {
            hourSpent += Math.ceil((double) pile / k);
        }
        return hourSpent <= h;
    }
}

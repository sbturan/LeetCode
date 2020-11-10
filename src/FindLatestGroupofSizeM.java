public class FindLatestGroupofSizeM {
    public static void main(String[] args) {
        System.out.println(new FindLatestGroupofSizeM().findLatestStep(
                new int[]{3,5,1,2,4}, 1
        ));
    }

    public int findLatestStep(int[] arr, int m) {
        int result = -1;
        int groupSizes[] = new int[arr.length];
        int start[] = new int[arr.length];
        int end[] = new int[arr.length];
        int count = 0;
        int maxLength=-1;
        for (int i = 0; i < arr.length; i++) {
            int curIndex = arr[i] - 1;
            int currentLength = 1 + (curIndex > 0 ? groupSizes[curIndex - 1] : 0) + (curIndex < arr.length - 1 ? groupSizes[curIndex + 1] : 0);
            groupSizes[curIndex] = currentLength;
            if (currentLength == m)
                count++;
            if (curIndex > 0 && groupSizes[curIndex - 1] > 0 && curIndex < arr.length - 1 && groupSizes[curIndex + 1] > 0) {
                if (groupSizes[curIndex - 1] == m)
                    count--;
                if (groupSizes[curIndex + 1] == m)
                    count--;
                groupSizes[start[curIndex - 1]] = currentLength;
                groupSizes[end[curIndex + 1]] = currentLength;
                end[curIndex - 1] = end[curIndex + 1];
                start[curIndex + 1] = start[curIndex - 1];
                end[start[curIndex - 1]] = end[curIndex + 1];
                start[end[curIndex + 1]] = start[curIndex - 1];
            } else if (curIndex > 0 && groupSizes[curIndex - 1] > 0) {
                if (groupSizes[curIndex - 1] == m)
                    count--;
                groupSizes[start[curIndex - 1]] = currentLength;
                start[curIndex] = start[curIndex - 1];
                end[curIndex] = curIndex;
                end[start[curIndex - 1]] = curIndex;
            } else if (curIndex < arr.length - 1 && groupSizes[curIndex + 1] > 0) {
                if (groupSizes[curIndex + 1] == m)
                    count--;
                groupSizes[end[curIndex + 1]] = currentLength;
                start[curIndex] = curIndex;
                end[curIndex] = end[curIndex + 1];
                start[end[curIndex + 1]] = curIndex;
            } else {
                start[curIndex] = curIndex;
                end[curIndex] = curIndex;
            }
            maxLength=Math.max(maxLength,currentLength);
            if (count > 0)
                result = i + 1;
            if(maxLength>m&&maxLength+m>=arr.length)
                return result;

        }
        return result;
    }
}

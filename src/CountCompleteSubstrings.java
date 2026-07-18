public class CountCompleteSubstrings {
    public static void main(String[] args) {
        System.out.println(new CountCompleteSubstrings().countCompleteSubstrings(
                "igigee",2
        ));
    }

    public int countCompleteSubstrings(String word, int k) {
        int result=0;
        char[] arr=word.toCharArray();
        int start=arr.length-1;
        int end=start;
        int[] charCounts=new int[26];
        int prevResult=0;
        char prevChar='a';
        while(start>-1){
            if(start!=arr.length-1&&Math.abs(arr[start]-arr[start+1])>2){
                charCounts=new int[26];
                end=start;
            }else{
                charCounts[arr[start]-'a']++;
                if(checkArr(charCounts,k)){
                    int currentResult=1;
                    if(Math.abs(arr[end]-prevChar)<3){
                        currentResult+=prevResult;
                    }
                    result+=currentResult;
                    prevResult=currentResult;
                    charCounts=new int[26];
                    prevChar=arr[start];
                    end=start-1;
                }
            }
            start--;
        }
        return result;
    }
    private boolean checkArr(int[] charCounts,int k){
        for(int i:charCounts){
            if(i!=0&&i!=k)
                return false;
        }
        return true;
    }
}

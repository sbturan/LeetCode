public class FruitIntoBasket {
    public static void main(String[] args) {
        System.out.println(new FruitIntoBasket().totalFruit(new int[]{2,3,3,3,3,2,2,3,3,2}));
    }

    public int totalFruit(int[] fruits) {
        int [] arr=new int[fruits.length];
        int i=0;
        while(i<fruits.length){
            int j=i+1;
            while(j<fruits.length&&fruits[i]==fruits[j]){
                j++;
            }
            arr[i]=j-i;
            i=j;
        }
        int result=0;
        for( i=0;i<arr.length;i++){
            if(i>0&&fruits[i]==fruits[i-1])
                continue;
            int nextIndex=i+arr[i];
            if(nextIndex==arr.length){
                result=Math.max(result,arr[i]);
            }else{
                int self=fruits[i];
                int next=fruits[nextIndex];
                int sum=arr[i];
                while(nextIndex<arr.length&&(fruits[nextIndex]==self||fruits[nextIndex]==next)){
                    sum+=arr[nextIndex];
                    nextIndex+=arr[nextIndex];
                }
                result=Math.max(result,sum);
            }
        }
        return result;
    }
}

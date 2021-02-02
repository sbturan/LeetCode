public class RLEIterator {
    public static void main(String[] args) {
        RLEIterator rleIterator = new RLEIterator(new int[]{3, 8, 0, 9, 2, 5});
        System.out.println(rleIterator.next(2));
        System.out.println(rleIterator.next(1));
        System.out.println(rleIterator.next(1));
        System.out.println(rleIterator.next(1));
    }

    int[] arr;
    int index;
    public RLEIterator(int[] A) {
       this.arr=A;
       index=0;
    }

    public int next(int n) {
        while(index<arr.length&&n-arr[index]>0){
              n-=arr[index];
              index+=2;
        }
        if(index>=arr.length){
            return -1;
        }
        arr[index]-=n;
        return arr[index+1];
    }
}

public class FindTheLengthOfTheLongestCommonPrefix {
    public static void main(String[] args) {
        System.out.println(new FindTheLengthOfTheLongestCommonPrefix().longestCommonPrefix(
                new int[]{1,10,100},
                new int[]{1000}
        ));
    }
    class Node{
        Node[] arr=new Node[10];
    }
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        Node head=new Node();
        for(int i:arr1){
            String str=String.valueOf(i);
            Node temp=head;
            for(Character c:str.toCharArray()){
                int val=(int)(c-'0');
                if(temp.arr[val]==null){
                    temp.arr[val]=new Node();
                }
                temp=temp.arr[val];
            }
        }
        int result=0;
        for(int i:arr2){
            int length=0;
            char[] chars=String.valueOf(i).toCharArray();
            int k=0;
            Node cur=head;
            while(k<chars.length&&cur.arr[(int)(chars[k]-'0')]!=null){
                length++;
                cur=cur.arr[(int)(chars[k]-'0')];
                k++;
            }

            result=Math.max(result,length);
        }
        return result;
    }
}

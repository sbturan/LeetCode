import java.util.*;

public class CountTripletsThatCanFormTwoArraysOfEqualXOR {

    public static void main(String[] args) {
        System.out.println(new CountTripletsThatCanFormTwoArraysOfEqualXOR()
                .countTriplets(new int[]{1,1,1,1,1}));
    }
    public int countTriplets(int[] arr) {
        int[] suffix=new int[arr.length+1];
        for(int i=arr.length-1;i>-1;i--){
            suffix[i]=suffix[i+1]^arr[i];
        }
        List<Map<Integer,Integer>> list=new ArrayList<>();
        for(int i=0;i<arr.length;i++){
            Map<Integer,Integer> map=new HashMap<>();
            map.put(arr[i],1);
            for(int j=i+1;j<arr.length;j++){
                int key=suffix[i]^suffix[j+1];
                map.put(key,map.getOrDefault(key,0)+1);
            }
            list.add(map);
        }
        int result=0;
        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                int r=suffix[i]^suffix[j];
                result+=list.get(j).getOrDefault(r,0);
            }
        }
        return result;
    }

}

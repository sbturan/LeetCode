public class KthSymbolinGrammar {
    public static void main(String[] args) {
        System.out.println(new KthSymbolinGrammar().kthGrammar(4,5));
    }
    public int kthGrammar(int N, int K) {
       return helper(K-1);
    }
    private int helper(int K){
        if(K<2){
            return K;
        }
        return helper(K/2)^(K&1);
    }

}
// ROW 4 -> 01 10 10 01 -> X Y Y X
// row 5 -> 01 10 10 01 10 01 01 10 ->X Y Y X  Y X X Y
// row 6 -> 01 10 10 01 10 01 01 10 10 01 01 10 01 10 10 01 -> X Y Y X   X Y Y X   Y X X Y   X Y Y X
// ROW 7 -> 01 10 10 01 10 01 01 10 10 01 01 10 01 10 10 01 10 01 01 10 01 10 10 01 01 10 10 01 10 01 01 10
// ->X Y Y X   X Y Y X   Y X X Y   X Y Y X   Y X X Y   X Y Y X   X Y Y X   X Y X X Y
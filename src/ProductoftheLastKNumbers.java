import java.util.ArrayList;
import java.util.List;

public class ProductoftheLastKNumbers {
    public static void main(String[] args) {
        ProductOfNumbers p=new ProductoftheLastKNumbers().new ProductOfNumbers();
        p.add(3);
        p.add(0);
        p.add(2);
        p.add(5);
        p.add(4);
        System.out.println(p.getProduct(2));
        System.out.println(p.getProduct(3));
        System.out.println(p.getProduct(4));
        p.add(8);
        System.out.println(p.getProduct(2));
    }
    class ProductOfNumbers {
        List<Integer> list;
        public ProductOfNumbers() {
          list=new ArrayList<>();
          list.add(1);
        }

        public void add(int num) {
            if(num==0){
                list=new ArrayList<>();
                list.add(1);
                return;
            }
            list.add(list.get(list.size()-1)*num);
        }

        public int getProduct(int k) {
            int size = list.size();
            if(k> size -1)
                return 0;
         return list.get(size -1)/list.get(size -k-1);
        }
    }
}

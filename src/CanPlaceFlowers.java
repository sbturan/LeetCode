
public class CanPlaceFlowers {
	public static void main(String[] args) {
		CanPlaceFlowers c=new CanPlaceFlowers();
		System.out.println(c.canPlaceFlowers(new int[] {1,0,0,0,0,1}, 2));
	}
	public boolean canPlaceFlowers(int[] flowerbed, int n) {
             
		for(int i=0;i<flowerbed.length&&n>0;i++) {
			if(flowerbed[i]==0) {
				if((i==flowerbed.length-1||flowerbed[i+1]==0)) {
					n--;
					flowerbed[i++]=1;
				}else {
					i+=2;
				}
			}else{
                i++;
            }
		}
		
		return n==0;
	} 
}

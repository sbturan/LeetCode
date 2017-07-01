
public class IntegertoRoman {
	 int[] numbers=new int[]{1000,900,500,400,100,90,50,40,10,9,5,4,1};
		String[] romans=new String[]{"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
	    	public String intToRoman(int num) {
			    StringBuilder result=new StringBuilder();
		         rcrv(result,num,0);
		         return result.toString();
		 }
		private void rcrv(StringBuilder result,int num,int index){
			if(index>12||num==0){
				return ;
			}
			if(num==1){
				result.append("I");
				return;
			}
			Integer cur=numbers[index];
			while(num<cur){
				index++;
				cur=numbers[index];
			}
			if(num==cur){
				result.append(romans[index]);
				return;
			}
			int mod=num/cur;
			for(int i=0;i<mod;i++){
				result.append(romans[index]);
			}
			rcrv(result, num-(mod*cur), index);
		}
}

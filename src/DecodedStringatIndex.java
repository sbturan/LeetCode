
public class DecodedStringatIndex {
	public static void main(String[] args) {
		DecodedStringatIndex d=new DecodedStringatIndex();
//		System.out.println(d.decodeAtIndex("vzpp636m8y",2920));
//		System.out.println(d.decodeAtIndex("ha22",5));
//		System.out.println(d.decodeAtIndex("leet2code3",10));
//		System.out.println(d.decodeAtIndex("a2345678999999999999999",1));
//		System.out.println(d.decodeAtIndex("abc",1));
//		System.out.println(d.decodeAtIndex("a2b3c4d5e6f7g8h9",3));
		System.out.println(d.decodeAtIndex("cpmxv8ewnfk3xxcilcmm68d2ygc88daomywc3imncfjgtwj8nrxjtwhiem5nzqnicxzo248g52y72v3yujqpvqcssrofd99lkovg",480551547));
		
		
		
	} // leetleetcode leetleetcode leetleetcode
    public String decodeAtIndex(String S, int K) {
       int i=0;
       long currentLenght=0;
       char[] charArray = S.toCharArray();
       MyString currentString=null;
       while(i<charArray.length&&currentLenght<K) {
    	   StringBuilder text=new StringBuilder((charArray[i]));
    	   int j=i;
    	   while(j<charArray.length&&charArray[j]>57) {
    		   text.append(charArray[j++]);
    	   }
    	   int count=1;
    	   while(j<charArray.length&&charArray[j]<58) {
    		   count*=((int)charArray[j++]-'0');
    	   }
    	   i=j;
    	   currentString=new MyString(text.toString(), Math.max(1, count), currentString);
    	   currentLenght=currentString.length;
       }
       return currentString.getCharAt(K-1);
    }
     class MyString{
    	private  MyString previous;
    	private String text;
    	private int count;
    	private long length;
    	public MyString(String text,int count,MyString previous) {
    		this.count=count;
    		this.text=text;
    		this.previous=previous;
    		if(previous!=null) {
    			length=previous.length;
    		}
    		length=(length+text.length())*count;
    	}
    	public String getCharAt(int k) {
    		long actualLength=length/count;
    		k=(int)(k%(actualLength));
    		if(previous==null) {
    			return String.valueOf(text.charAt(k));
    		}
    		long previousLength=previous.length;
    		if(k>=previousLength) {
    			return String.valueOf(this.text.charAt((int)(k-previousLength)));
    		}
    		return previous.getCharAt(k);
    	}
    }

}

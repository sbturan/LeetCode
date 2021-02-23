public class DayoftheYear {
    public int dayOfYear(String date) {
        int year=Integer.valueOf(date.substring(0,4));
        int month=Integer.valueOf(date.substring(5,7));
        int day=Integer.valueOf(date.substring(8,10));
        int result=0;
        for(int i=1;i<month;i++){
            result+=30;
            if((i<8&&i%2==1)||(i>7&&i%2==0)){
                result++;
            }
        }
        if(month>2){
            result-=2;
            if(year>1900 && year%4==0)
                result++;
        }
        return result+day;
    }
}

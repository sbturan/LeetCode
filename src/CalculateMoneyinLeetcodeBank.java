public class CalculateMoneyinLeetcodeBank {
    public int totalMoney(int n) {
        int mod = n % 7;
        int count=n/7;
        return (count*28)+(count*(count-1)/2*7) + (mod*(mod+1)/2 + (count*mod));
    }
}

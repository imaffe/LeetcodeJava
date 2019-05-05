package Medium;

public class M343IntegerBreak {
    public int integerBreak(int n) {
        if (n == 0) return 0;
        else if(n == 1) return 1;
        else if (n == 2) return 1;
        else ;

        int numberOfThree = n / 3;
        int remain = n % 3;

        if (remain == 0) {
            return (int)Math.pow(3,numberOfThree);
        } else if (remain == 1) {
            return (int)Math.pow(3,numberOfThree - 1) * 4;
        } else {
            return (int)Math.pow(3,numberOfThree) * 2;
        }
    }
}

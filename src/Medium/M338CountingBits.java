package Medium;

public class M338CountingBits {
    public int[] countBits(int num) {
        int [] numBits = new int[num + 1];
        numBits[0] = 0;
        numBits[1] = 1;
        int pow = 1;
        while ((1 << (pow + 1)) - 1 < num) {
            int base = 1 << pow;
            for (int i = base; i < (1<<(pow + 1)); i++) {
                numBits[i] = numBits[i%base] + 1;
            }
            pow++;
        }

        int base = 1 << (pow);
        for (int i = base; i <= num; i++) {
            numBits[i] = numBits[i%base] + 1;
        }

        return numBits;
    }
}

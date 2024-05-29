public class Coin {
    private static final int[] DENOM = {5000, 1000, 500, 100,75, 50, 20, 10, 5, 2, 1};
    public static void findMinDenom(int amount) {
        int[] count = new int[DENOM.length];
        for (int i = 0; i < DENOM.length; i++) {
            if (amount >= DENOM[i]) {
                count[i] = amount / DENOM[i];
                amount = amount % DENOM[i];
            }
        }
        System.out.println("currency required is:");
        for (int i = 0; i < DENOM.length; i++) {
            if (count[i] != 0) {
                System.out.println(DENOM[i] + " : " + count[i]);
            }
        }
    }
    public static void main(String[] args) {
        int amount = 1988;
        findMinDenom(amount);
    }
}
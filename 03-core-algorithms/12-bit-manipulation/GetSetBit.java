public class GetSetBit {

    public static void main(String[] args) {
        int n = 5; // Binary: 0101
        int pos = 2;

        // Get the bit at position pos
        int bit = getBit(n, pos);
        System.out.println("Bit at position " + pos + ": " + bit);

        // Set the bit at position pos
        n = setBit(n, pos);
        System.out.println("Number after setting bit at position " + pos + ": " + n);
    }

    static int getBit(int n, int pos) {
        return (n & (1 << pos)) != 0 ? 1 : 0;
    }

    static int setBit(int n, int pos) {
        return n | (1 << pos);
    }
}

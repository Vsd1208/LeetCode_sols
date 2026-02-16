class Solution {
    public int reverseBits(int n) {
        String bin = String.format("%32s", Integer.toBinaryString(n)).replace(' ', '0');
        String revBin = new StringBuilder(bin).reverse().toString();
        return (int) Long.parseLong(revBin, 2);
    }
}

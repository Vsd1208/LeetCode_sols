class Solution {
    private int waviness(String num){
        if(num.length() < 3) return 0;

        int count = 0;

        for(int i = 1; i < num.length() - 1; i++){
            int ch1 = num.charAt(i-1) - '0';
            int ch2 = num.charAt(i) - '0';
            int ch3 = num.charAt(i+1) - '0';

            if(ch1 < ch2 && ch2 > ch3) count++;
            if(ch1 > ch2 && ch2 < ch3) count++;
        }

        return count;
    }

    public int totalWaviness(int num1, int num2) {
        int count = 0;

        for(int i = num1; i <= num2; i++){
            count += waviness(String.valueOf(i));
        }

        return count;
    }
}
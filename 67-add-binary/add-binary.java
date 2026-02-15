class Solution {
    public String addBinary(String a, String b) {
        String ab="";
        String bd="",ad="";
        int carry=0;
        if(a.length()>b.length()){
           for(int i=0;i<a.length()-b.length();i++)
              bd+="0";
        }
        bd+=b;
        if(a.length()<b.length()){
           for(int i=0;i<b.length()-a.length();i++)
              ad+="0";
        }
        ad+=a;
        for(int i=bd.length()-1;i>=0;i--){
            char ch=ad.charAt(i);
            char ch1=bd.charAt(i);
            int num=ch-'0';
            int num1=ch1-'0';
            int sum=0;
            sum=num+num1+carry;
            ab += (char) ((sum % 2) + '0'); 
            carry = sum / 2; 
        }
        if(carry>0)
        ab+='1';
        String reversed = new StringBuilder(ab).reverse().toString();
        return reversed;
    //     long sum = 0;

    //     for (int i = 0; i < a.length(); i++) {
    //         char ch = a.charAt(i);
    //         int num = ch - '0';
    //         sum += num * (1L << (a.length() - 1 - i));
    //     }

    //     for (int i = 0; i < b.length(); i++) {
    //         char ch = b.charAt(i);
    //         int num = ch - '0';
    //         sum += num * (1L << (b.length() - 1 - i));
    //     }

    //     if (sum == 0) return "0";

    //     StringBuilder s = new StringBuilder();
    //     while (sum != 0) {
    //         s.append(sum % 2);
    //         sum /= 2;
    //     }
    // return s.reverse().toString();
    }
}
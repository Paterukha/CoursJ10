package files.HW.HW82.utils;

import java.math.BigInteger;



public class Fibonacci {

    public BigInteger getFibonacciNumber(long n){
        if (n == 0){
            return BigInteger.valueOf(0);
        } else if (n == 1){
            return BigInteger.valueOf(1);
        } else {
            BigInteger a = BigInteger.valueOf(0);
            BigInteger b = BigInteger.valueOf(1);
            for (long i = 2; i <= n; i++){
                //b = a + b;
                //a = b - a;
                b = a.add(b);
                a = b.subtract(a);
            }
            return b;
        }
    }

    public String getFibonacciRow(long n){
        final String NUMBER0 = "0";
        final String NUMBER1 = "0, 1";
        final int countEndOfLine = 5;
        if (n == 0){
            return NUMBER0;
        } else if (n == 1){
            return NUMBER1;
        } else {
            BigInteger a = BigInteger.valueOf(0);
            BigInteger b = BigInteger.valueOf(1);
            String result = NUMBER1;
            for (long i = 2; i <= n; i++){
                b = a.add(b);
                a = b.subtract(a);
                if (i%countEndOfLine == 0) {
                    result += ",\n" + b.toString();
                    } else {
                    result += ", " + b.toString();
                }
            }
            return result;
        }
    }

    public boolean isNumber(String string) {
        if (string == null) return false;
        return string.matches("^-?\\d+$");
    }

    public boolean isNegative(Long n){
        return ((n < 0)?true:false);
    }

    public boolean checkString(String string){
        return ((isNumber(string)&&(!isNegative(Long.parseLong(string))))?true:false);
    }
}

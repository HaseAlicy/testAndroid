package com.example.haseyuuki.fujitsuchizaihase;

/**
 * Created by TAKUYA on 2016/09/11.
 */
public class ItoA {
    public static String convert(int x, int base) {
        boolean negative = false;
        String s = "";
        if (x == 0)
            return "0";
        negative = (x < 0);
        if (negative)
            x = -1 * x;
        while (x != 0) {
            s = (x % base) + s; // add char to front of s
            x = x / base; // integer division gives quotient
        }
        if (negative)
            s = "-" + s;
        return s;
    } // convert

    public static void main(String[] args) // test
    {
        int x = 16;
        int base = 2;
        System.out.println(convert(x, base));

        base = 10;
        System.out.println(convert(x, base));
    }

} // end class itoa


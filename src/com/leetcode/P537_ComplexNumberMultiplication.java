package com.leetcode;

/**
 * Created by xiaoyuan on 27/06/2017.
 */
public class P537_ComplexNumberMultiplication {

    public String complexNumberMultiply(String a, String b) {

        String[] aArr = a.replaceAll("i", "").split("\\+");
        String[] bArr = b.replaceAll("i", "").split("\\+");

        int x1 = Integer.parseInt(aArr[0]);
        int y1 = Integer.parseInt(aArr[1]);
        int x2 = Integer.parseInt(bArr[0]);
        int y2 = Integer.parseInt(bArr[1]);

        int A = x1*x2 - y1*y2;
        int B = x1*y2 + x2*y1;


        return A + "+" + B + "i";
    }

    public static void main(String[] args) {
        System.out.println(new P537_ComplexNumberMultiplication().complexNumberMultiply("5+-42i", "10+12i"));
    }

}

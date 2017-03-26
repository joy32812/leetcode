package com.leetcode;

/**
 * Created by xiaoyuan on 26/03/2017.
 * CARE: 1.0  1
 */
public class P165_CompareVersionNumbers {

    public int compareVersion(String version1, String version2) {
        String[] aArr = version1.split("\\.");
        String[] bArr = version2.split("\\.");

        int la = aArr.length - 1;
        int lb = bArr.length - 1;
        for (;la > 0; la-- ) {
            if (aArr[la].length() > 0 && Integer.parseInt(aArr[la]) != 0) {
                break;
            }
        }

        for (;lb > 0; lb --) {
            if (bArr[lb].length() > 0 && Integer.parseInt(bArr[lb]) != 0) {
                break;
            }
        }

        int a = 0;
        int b = 0;
        while (a <= la && b <= lb) {
            int va = 0;
            if (aArr[a].length() > 0) {
                va = Integer.parseInt(aArr[a]);
            }

            int vb = 0;
            if (bArr[b].length() > 0) {
                vb = Integer.parseInt(bArr[b]);
            }

            a++;
            b++;


            if (va > vb) {return 1;}
            if (va < vb) {return -1;}
        }

        if (a == la + 1 && b == lb + 1) {return 0;}
        if (a == la + 1) {return -1;}
        return 1;

    }

    public static void main(String[] args) {
        System.out.println(new P165_CompareVersionNumbers().compareVersion("1", "0"));

        System.out.println(new P165_CompareVersionNumbers().compareVersion("1.0.0", "1.0"));

        System.out.println(new P165_CompareVersionNumbers().compareVersion("1.0.2.1", "1.0.2"));
    }

}

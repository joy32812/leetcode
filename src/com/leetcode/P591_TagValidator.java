package com.leetcode;

/**
 * Created by xiaoyuan on 22/09/2017.
 */
public class P591_TagValidator {

    public boolean isValid(String code) {

        return okayTag(code);
    }


    boolean okayTag(String s) {


        int n = s.length();
        if (s.charAt(0) != '<' || s.charAt(n - 1) != '>') {return false;}

        int l = 1;
        int r = n - 2;
        int cnt = 0;
        StringBuilder sa = new StringBuilder();
        StringBuilder sb = new StringBuilder();
        while (l < r) {
            char a = s.charAt(l);
            char b = s.charAt(r);

            if (a == '>') {
                if (cnt == 0) return false;
                if (b != '/') return false;
                if (s.charAt(r - 1) != '<') return false;

                String x = sa.toString();
                String y = sb.reverse().toString();
                if (!x.equals(y)) return false;
                sa = new StringBuilder();
                sb = new StringBuilder();

                return okayContext(s.substring(l + 1, r - 1));
            } else if (!Character.isUpperCase(a) || !Character.isUpperCase(b)) {
                return false;
            } else {
                sa.append(a);
                sb.append(b);

                cnt++;
                if (cnt > 9) return false;
            }

            l++;
            r--;
        }

        return false;
    }

    boolean okayCData(String s) {

        return s.indexOf("<![CDATA[") == 0;
    }

    String removeCDData(String s) {
        int n = s.length();

        // check cdData first

        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < n) {
            if (s.charAt(i) == '<') {
                if (i + 1 >= n) return "";
                if (s.charAt(i + 1) == '!') {
                    int p = s.substring(i).indexOf("]]>");
                    if (p == -1) return "*";

                    if (!okayCData(s.substring(i).substring(0, p + 3))) return "*";
                    i = i + p + 2;
                } else {
                    sb.append(s.charAt(i));
                }
            } else {
                sb.append(s.charAt(i));
            }

            i++;
        }


        return sb.toString();
    }

    boolean okayContext(String s) {
        s = removeCDData(s);
        if (s.equals("*")) return false;

        int n = s.length();
        int i = 0;

        while (i < n) {

            if (s.charAt(i) == '<') {
                if (i + 1 >= n) return false;
                int cnt = 1;
                int p = -1;
                for (int j = i + 1; j < n; j++) {
                    if (s.charAt(j) == '<') {
                        if (j + 1 >= n) return false;
                        if (s.charAt(j + 1) == '/') {
                            cnt--;
                            if (cnt == 0) {
                                p = j;
                                break;
                            }
                        } else {
                            cnt++;
                        }
                    }
                }

                if (p == -1) return false;

                int k = p + 1;
                for (;k < n; k++) {
                    if (s.charAt(k) == '>') break;
                }

                if (k == n) return false;

                if (!okayTag(s.substring(i, k + 1))) return false;
                i = k;

            }

            i++;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(new P591_TagValidator().isValid("<DIV><YFSYYS><UVBNIQ><XPMXUNT><WNGMV><OJJGQREMT><Z><GEJDP><LIQS><NCVYU><RAS><UYFKCJCDN><NA><POJVYT><Z><TDC><VUIZQC><BNANGX><TOF><MR>MK</MR></TOF></BNANGX></VUIZQC></TDC></Z></POJVYT></NA></UYFKCJCDN></RAS></NCVYU></LIQS></GEJDP></Z></OJJGQREMT></WNGMV></XPMXUNT></UVBNIQ></YFSYYS></DIV>"));
        System.out.println(new P591_TagValidator().isValid("<A><A>456</A>  <A> 123  !!  <![CDATA[<![cdata]>]]>  123 </A>   <A><![CDATA[</A>]]>  </A>  <A>123</A></A>"));
        System.out.println(new P591_TagValidator().isValid("<A><A>456</A>  <A> 123  !!  <![CDATA[]]>  123 </A>   <A>123</A></A>"));
        System.out.println(new P591_TagValidator().isValid("<A><A>/A></A></A>"));
        System.out.println(new P591_TagValidator().isValid("<DIV>This is the first line <![CDATA[<div>]]></DIV>"));
        System.out.println(new P591_TagValidator().isValid("<DIV>>>  ![cdata[]] <![CDATA[<div>]>]]>]]>>]</DIV>"));
        System.out.println(new P591_TagValidator().isValid("<A>  <B> </A>   </B>"));
        System.out.println(new P591_TagValidator().isValid("<DIV>  div tag is not closed  <DIV>"));
        System.out.println(new P591_TagValidator().isValid("<DIV>  unmatched <  </DIV>"));
        System.out.println(new P591_TagValidator().isValid("<DIV> closed tags with invalid tag name  <b>123</b> </DIV>"));
        System.out.println(new P591_TagValidator().isValid("<DIV> unmatched tags with invalid tag name  </1234567890> and <CDATA[[]]>  </DIV>"));
        System.out.println(new P591_TagValidator().isValid("<DIV>  unmatched start tag <B>  and unmatched end tag </C>  </DIV>"));
    }
}

package com.leetcode;

import java.util.HashSet;
import java.util.Set;


/**
 * easy
 * just find the final short email address
 */

public class P929_UniqueEmailAddresses {


    public int numUniqueEmails(String[] emails) {
        if (emails == null || emails.length == 0) return 0;

        Set<String> emailSet = new HashSet<>();
        for (String email : emails) {
            emailSet.add(getShortEmail(email));
        }

        return emailSet.size();
    }

    String getShortEmail(String email) {
        String[] emailSplit = email.split("@");

        String local = "";
        String old = emailSplit[0];
        for (int i = 0; i < old.length(); i++) {
            if (old.charAt(i) == '.') {
                continue;
            } else if (old.charAt(i) == '+') {
                break;
            } else {
                local += old.charAt(i);
            }
        }

        return local + "@" + emailSplit[1];
    }


    public static void main(String[] args) {
        System.out.println(new P929_UniqueEmailAddresses().numUniqueEmails(new String[]{"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"}));
    }

}

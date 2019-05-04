package com.leetcode;

public abstract class P470_ImplementRand10UsingRand7 {

    abstract public int rand7();

    public int rand10() {

        long now = 0;
        for (int i = 0; i < 10; i ++) {
            now = now * 7 + rand7() - 1;
        }

        return (int) (now / 28247525) + 1;
    }


}

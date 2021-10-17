package com.leetcode

/**
 * brute force
 */
class Bank(balance: LongArray) {

    val n = balance.size
    val B = balance

    fun transfer(account1: Int, account2: Int, money: Long): Boolean {
        if (account1 > n || account2 > n) return false
        if (B[account1 - 1] < money) return false

        B[account1 - 1] -= money
        B[account2 - 1] += money
        return true
    }

    fun deposit(account: Int, money: Long): Boolean {
        if (account > n) return false

        B[account - 1] += money
        return true
    }

    fun withdraw(account: Int, money: Long): Boolean {
        if (account > n) return false
        if (B[account - 1] < money) return false

        B[account - 1] -= money
        return true
    }

}

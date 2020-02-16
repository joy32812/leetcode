package com.leetcode

class ProductOfNumbers() {

    private var prodList = mutableListOf(1)

    fun add(num: Int) {
        if (num == 0) {
            prodList = mutableListOf(1)
        } else {
            prodList.add(prodList.last() * num)
        }
    }

    fun getProduct(k: Int): Int {
        val n = prodList.size
        if (k >= n) return 0
        return prodList[n - 1] / prodList[n - k - 1]
    }

}
package com.leetcode

import java.util.*

/**
 * TreeMap
 */
class StockPrice() {

    val time2Price = TreeMap<Int, Int>()
    val price2Cnt = TreeMap<Int, Int>()

    fun update(timestamp: Int, price: Int) {
        if (timestamp in time2Price) {
            val oldPrice = time2Price[timestamp]!!

            price2Cnt[oldPrice] = price2Cnt[oldPrice]!! - 1
            if (price2Cnt[oldPrice]!! == 0) price2Cnt.remove(oldPrice)
        }

        time2Price[timestamp] = price
        price2Cnt[price] = (price2Cnt[price] ?: 0) + 1
    }

    fun current(): Int {
        return time2Price.lastEntry().value
    }

    fun maximum(): Int {
        return price2Cnt.lastKey()
    }

    fun minimum(): Int {
        return price2Cnt.firstKey()
    }

}

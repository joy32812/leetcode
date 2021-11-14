package com.leetcode

import java.util.*

fun reverseEvenLengthGroups(head: ListNode?): ListNode? {

    val ans = mutableListOf<ListNode>()
    val nums = LinkedList<ListNode>()
    var cur = head
    while (cur != null) {
        nums += cur
        cur = cur.next
    }


    fun work(l: Int) {
        val len = Math.min(l, nums.size)

        val tmp = mutableListOf<ListNode>()
        repeat(len) { tmp += nums.poll() }

        if (len % 2 == 1) {
            ans.addAll(tmp)
        } else {
            ans.addAll(tmp.reversed())
        }
    }

    var len = 1
    while (nums.isNotEmpty()) {
        work(len)
        len ++
    }

    for (i in ans.indices) {
        if (i == ans.size - 1) {
            ans[i].next = null
            break
        }
        ans[i].next = ans[i + 1]
    }

    return ans[0]
}

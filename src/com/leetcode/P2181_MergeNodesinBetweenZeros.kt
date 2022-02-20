package com.leetcode

/**
 * one pass
 */
fun mergeNodes(head: ListNode?): ListNode? {

    val dummy = ListNode(0)
    var cur = dummy

    var now = head!!.next
    var sum = 0
    while (now != null) {
        sum += now.`val`

        if (now.`val` == 0) {
            cur.next = ListNode(sum)
            cur = cur!!.next
            sum = 0
        }

        now = now.next
    }

    return dummy.next
}

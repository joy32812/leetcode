package com.leetcode

/**
 * easy
 */
fun swapNodes(head: ListNode?, k: Int): ListNode? {

    val values = mutableListOf<ListNode>()
    var root = head
    while (root != null) {
        values += root
        root = root.next
    }

    var l = k - 1
    var r = values.size - k
    var tmp = values[l].`val`
    values[l].`val` = values[r].`val`
    values[r].`val` = tmp

    return head
}

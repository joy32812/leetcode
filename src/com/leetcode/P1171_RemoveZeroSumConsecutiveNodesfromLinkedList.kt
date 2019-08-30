package com.leetcode


internal fun removeZeroSumSublists(head: ListNode?): ListNode? {

    val dummy = ListNode(0)
    dummy.next = head

    var now : ListNode?= dummy
    var map = mutableMapOf<Int, ListNode>()
    var sum = 0
    while (now != null) {
        sum += now.`val`
        if (sum in map) {

            var current = map[sum]!!.next
            var curSum = sum
            while (current != now) {
                curSum += current.`val`
                map.remove(curSum)
                current = current.next
            }
            map[sum]!!.next = now.next

        } else {
            map[sum] = now
        }
        now = now.next
    }


    return dummy.next
}

fun main() {
    val n1 = ListNode(1)
    val n2 = ListNode(2)
    val n3 = ListNode(-3)
    val n4 = ListNode(3)
    val n5 = ListNode(1)

    n1.next = n2
    n2.next = n3
    n3.next = n4
    n4.next = n5

    println(removeZeroSumSublists(n1))
}
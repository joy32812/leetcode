
class Solution {

    // Result with carry.
    data class Result(val head: ListNode?, val carry: Int)
    fun doDouble(head: ListNode?): Result {
        if (head == null) return Result(null, 0)

        val (newHead, carry) = doDouble(head.next)

        val sum = head.`val` * 2 + carry
        val newCarry = sum / 10
        val newNode = ListNode(sum % 10)
        newNode.next = newHead

        return Result(newNode, newCarry)
    }


    fun doubleIt(head: ListNode?): ListNode? {
        val result = doDouble(head)
        if (result.carry == 0) return result.head

        val newNode = ListNode(result.carry)
        newNode.next = result.head
        return newNode
    }
}

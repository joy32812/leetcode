/**
 * recursive solution.
 */
fun removeNodes(head: ListNode?): ListNode? {

    var max = Int.MIN_VALUE

    fun dfs(head: ListNode?): ListNode? {
        if (head == null) return null
        val next = dfs(head.next)
        if (head.`val` >= max) {
            max = head.`val`
            head.next = next
            return head
        } else {
            return next
        }
    }

    return dfs(head)

}

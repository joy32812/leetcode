package com.leetcode


class P1650_LowestCommonAncestorofaBinaryTreeIII {


    class Node(var `val`: Int) {
    		var left: TreeNode? = null
    		var right: TreeNode? = null
    		var parent: Node? = null
    }

    fun lowestCommonAncestor(p: Node?, q: Node?): Node? {
        val parents = mutableSetOf<Node>()
        var current = p
        while (current != null) {
            parents.add(current)
            current = current.parent
        }

        current = q
        while (current != null) {
            if (current in parents) return current
            current = current.parent
        }

        return null
    }

    fun lowestCommonAncestor2(p: Node?, q: Node?): Node? {
        var a = p
        var b = q

        while (a != b) {
            a = if (a == null) q else a.parent
            b = if (b == null) p else b.parent
        }

        return a
    }

}


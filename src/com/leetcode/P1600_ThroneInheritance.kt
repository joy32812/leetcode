package com.leetcode

/**
 * DFS, SET, MAP
 */
class ThroneInheritance(kingName: String) {
    var currentKing = ""

    class KingNode(name: String, val children: MutableList<String>, var alive: Boolean) {}
    val nameMap = mutableMapOf<String, KingNode>()

    init {
        currentKing = kingName
        nameMap[kingName] = KingNode(kingName, mutableListOf(), true)
    }

    fun birth(parentName: String, childName: String) {
        nameMap[childName] = KingNode(childName, mutableListOf(), true)
        nameMap[parentName]!!.children += childName
    }

    fun death(name: String) {
        nameMap[name]!!.alive = false
    }

    var order = mutableListOf<String>()
    var visited = mutableSetOf<String>()
    fun dfs(now: String) {
        val nowNode = nameMap[now]!!
        visited.add(now);

        if (nowNode.alive) order.add(now);

        for (s in nowNode.children) {
            if(!visited.contains(s)) dfs(s)
        }
    }

    fun getInheritanceOrder(): List<String> {
        order = mutableListOf()
        visited = mutableSetOf()
        dfs(currentKing)
        return order.toList()
    }

}

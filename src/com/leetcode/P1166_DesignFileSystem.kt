package com.leetcode

class FileSystem() {

    data class PathNode(val value: Int, val children: MutableMap<String, PathNode>)

    val rootPath = PathNode(0, mutableMapOf())
    fun create(path: String, value: Int): Boolean {
        val pathList = path.split("/").filter { it != null && it.isNotEmpty() }

        var nowPath = rootPath

        for (i in 0 until pathList.size - 1) {
            val p = pathList[i]
            if (p !in nowPath.children) return false
            nowPath = nowPath.children[p]!!
        }

        if (pathList.last() in nowPath.children) return false
        nowPath.children[pathList.last()] = PathNode(value, mutableMapOf())
        return true
    }

    fun get(path: String): Int {
        val pathList = path.split("/").filter { it != null && it.isNotEmpty() }

        var nowPath = rootPath
        for (p in pathList) {
            if (p !in nowPath.children) return -1
            nowPath = nowPath.children[p]!!
        }
        return nowPath.value
    }

}

fun main() {

    val path = "/a/b/c"
    val split = path.split("/").filter { it != null && it.isNotEmpty() }
    println(split)

}
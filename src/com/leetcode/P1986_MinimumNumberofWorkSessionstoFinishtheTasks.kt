package com.leetcode

/**
 * mask
 */
fun minSessions(tasks: IntArray, sessionTime: Int): Int {
    tasks.sort()
    val n = tasks.size
    var ans = Int.MAX_VALUE

    fun dfs(visited: BooleanArray, left: Int, sessionNum: Int) {
        if (sessionNum >= ans) return
        if (visited.all { it }) {
            ans = Math.min(ans, sessionNum)
            return
        }

        if (left == 0) {
            dfs(visited, sessionTime, sessionNum + 1)
            return
        }

        var found = false
        var last = Int.MIN_VALUE
        for (i in tasks.indices) {
            if (visited[i]) continue
            if (left >= tasks[i] && tasks[i] != last) {
                last = tasks[i]
                found = true
                visited[i] = true
                dfs(visited, left - tasks[i], sessionNum)
                visited[i] = false
            }
        }

        if (!found) {
            dfs(visited, sessionTime, sessionNum + 1)
        }

    }

    dfs(BooleanArray(n), sessionTime, 1)
    return ans
}


package com.leetcode



data class Visit(val name: String, val time: Int, val site: String)
fun mostVisitedPattern(username: Array<String>, timestamp: IntArray, website: Array<String>): List<String> {

    val visitList = mutableListOf<Visit>()
    for (i in 0 until username.size) {
        visitList.add(Visit(username[i], timestamp[i], website[i]))
    }

    visitList.sortBy { it.time }

    val cntMap = mutableMapOf<String, HashSet<String>>()
    visitList.groupBy { it.name }.filterValues { it.size >= 3 }.forEach {
        (name, visits) ->
        for (i in 0 until visits.size) {
            for (j in i + 1 until visits.size) {
                for (k in j + 1 until visits.size) {
                    val key = visits[i].site + "_" + visits[j].site + "_" + visits[k].site
                    if (key !in cntMap) cntMap[key] = hashSetOf()
                    cntMap[key]!!.add(name)
                }
            }
        }
    }

    val max = cntMap.values.maxBy { it.size }!!.size
    return cntMap.filterValues { it.size == max }.keys.min()!!.split("_").toList()
}

fun main() {

    println(mostVisitedPattern(
            arrayOf("h","eiy","cq","h","cq","txldsscx","cq","txldsscx","h","cq","cq"),
            intArrayOf(527896567,334462937,517687281,134127993,859112386,159548699,51100299,444082139,926837079,317455832,411747930),
            arrayOf("hibympufi","hibympufi","hibympufi","hibympufi","hibympufi","hibympufi","hibympufi","hibympufi","yljmntrclw","hibympufi","yljmntrclw")
    ))

}
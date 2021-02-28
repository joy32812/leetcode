package com.leetcode


/**
 * easy
 */
fun countMatches(items: List<List<String>>, ruleKey: String, ruleValue: String): Int {
    return items.count { (ruleKey == "type" && ruleValue == it[0]) || (ruleKey == "color" && ruleValue == it[1]) || ruleKey == "name" && ruleValue == it[2] }
}

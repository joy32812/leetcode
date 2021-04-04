package com.leetcode

/**
 * two points. move the points until one list is empty.
 */
fun areSentencesSimilar(sentence1: String, sentence2: String): Boolean {
    val split1 = sentence1.split(" ")
    val split2 = sentence2.split(" ")

    var ll = 0
    while (ll < split1.size && ll < split2.size && split1[ll] == split2[ll]) ll ++

    var r1 = split1.size - 1
    var r2 = split2.size - 1

    while (r1 >= 0 && r2 >= 0 && split1[r1] == split2[r2]) {
        r1 --
        r2 --
    }

    return ll > r1 || ll > r2
}

fun main() {

}

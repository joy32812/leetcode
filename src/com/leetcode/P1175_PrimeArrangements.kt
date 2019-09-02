package com.leetcode


fun numPrimeArrangements(n: Int): Int {

    fun isPrime(x: Int): Boolean = if (x <= 1) false else (2 until x).none { x % it == 0 }
    val primeNum = (2..n).count { isPrime(it) }

    val mod = 1_000_000_000 + 7
    return (1..primeNum).plus(1..n - primeNum).fold(1L) {acc, i -> acc * i % mod }.toInt()
}


fun main() {

    println(numPrimeArrangements(5))
    println(numPrimeArrangements(100))

}

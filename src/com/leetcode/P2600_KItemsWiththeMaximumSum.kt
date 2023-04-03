fun kItemsWithMaximumSum(numOnes: Int, numZeros: Int, numNegOnes: Int, k: Int): Int {

    if (k <= numOnes + numZeros) return minOf(k, numOnes)

    return numOnes - (k - numOnes - numZeros)
}

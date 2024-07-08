fun numberOfAlternatingGroups(colors: IntArray): Int {

    val n = colors.size

    // Add two more elements to the array to avoid checking the boundaries
    val arr = colors + colors

    return (1..n).count { i -> arr[i] != arr[i - 1] && arr[i] != arr[i + 1] }
}
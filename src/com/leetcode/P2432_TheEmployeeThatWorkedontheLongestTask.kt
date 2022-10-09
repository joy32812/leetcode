/**
 * brute force.
 */
fun hardestWorker(n: Int, logs: Array<IntArray>): Int {

    var ans = 0
    var workTime = 0

    var lastEnd = 0
    for ((worker, leaveTime) in logs) {
        if (leaveTime - lastEnd > workTime || (leaveTime - lastEnd == workTime && worker < ans)) {
            ans = worker
            workTime = leaveTime - lastEnd
        }
        lastEnd = leaveTime
    }

    return ans
}

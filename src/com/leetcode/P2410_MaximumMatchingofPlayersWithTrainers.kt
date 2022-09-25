/**
 * greedy.
 */
fun matchPlayersAndTrainers(players: IntArray, trainers: IntArray): Int {

    players.sort()
    trainers.sort()

    var ans = 0
    var i = 0
    var j = 0
    while (i < players.size && j < trainers.size) {
        if (players[i] <= trainers[j]) {
            ans++
            i++
            j++
        } else {
            j++
        }
    }

    return ans
}

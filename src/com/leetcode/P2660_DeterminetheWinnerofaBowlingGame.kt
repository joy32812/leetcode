fun isWinner(player1: IntArray, player2: IntArray): Int {

    fun getScore(player: IntArray): Int {
        var score = 0

        for (i in player.indices) {
            score += player[i]
            if ((i - 2 >= 0 && player[i - 2] == 10) || (i - 1 >=0 && player[i - 1] == 10)) {
                score += player[i]
            }
        }

        return score
    }

    val score1 = getScore(player1)
    val score2 = getScore(player2)

    return if (score1 > score2) 1 else if (score1 < score2) 2 else 0
}

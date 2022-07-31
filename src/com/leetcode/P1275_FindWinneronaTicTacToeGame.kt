/**
 * TicTacToe
 */
fun tictactoe(moves: Array<IntArray>): String {
    val board = Array(3) { CharArray(3) { ' ' } }

    for (i in moves.indices) {
        val (r, c) = moves[i]
        board[r][c] = if (i % 2 == 0) 'X' else 'O'
    }

    fun win(player: Char): Boolean {
        for (i in 0..2) {
            if (board[i][0] == player && board[i][1] == player && board[i][2] == player) return true
            if (board[0][i] == player && board[1][i] == player && board[2][i] == player) return true
        }
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) return true
        if (board[0][2] == player && board[1][1] == player && board[2][0] == player) return true
        return false
    }


    if (win('X')) return "A"
    if (win('O')) return "B"

    if (moves.size < 9) return "Pending"

    return "Draw"
}

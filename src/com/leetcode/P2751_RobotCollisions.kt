import java.util.*

private data class Robot(val id: Int, val pos: Int, val health: Int, val direction: Char)
fun survivedRobotsHealths(positions: IntArray, healths: IntArray, directions: String): List<Int> {

    val robots = positions
        .withIndex()
        .map { Robot(it.index, it.value, healths[it.index], directions[it.index]) }
        .sortedBy { it.pos }

    val stack = Stack<Robot>()

    for (robot in robots) {
        if (stack.isEmpty() || robot.direction == 'R' || stack.peek().direction == robot.direction) {
            stack.push(robot)
            continue
        }

        var cur = robot
        while (stack.isNotEmpty() && stack.peek().direction == 'R' && cur.direction == 'L') {
            val top = stack.pop()

            cur = if (top.health > cur.health) {
                top.copy(health = top.health - 1)
            } else if (top.health < cur.health) {
                robot.copy(health = cur.health - 1)
            } else {
                robot.copy(health = 0)
            }
            if (cur.health == 0) break
        }
        if (cur.health > 0) stack.push(cur)
    }

    return stack.sortedBy { it.id }.map { it.health }
}

fun isRobotBounded(instructions: String): Boolean {
    var xDirection = 0
    var yDirection = 0
    var currDirection = 'N'
    for (instruction in instructions) {
        if (instruction == 'L') {
            when (currDirection) {
                'N' -> currDirection = 'W'
                'W' -> currDirection = 'S'
                'S' -> currDirection = 'E'
                'E' -> currDirection = 'N'
            }
        } else if (instruction == 'R') {
            when (currDirection) {
                'N' -> currDirection = 'E'
                'W' -> currDirection = 'N'
                'S' -> currDirection = 'W'
                'E' -> currDirection = 'S'
            }
        } else {
            when (currDirection) {
                'N' -> yDirection += 1
                'W' -> xDirection -= 1
                'S' -> yDirection -= 1
                'E' -> xDirection += 1
            }
        }
    }
    if ((xDirection == 0 && yDirection == 0) || currDirection != 'N') {
        return true
    }
    return false
}

fun main() {
    println(isRobotBounded("GLRLLGLL"))
}
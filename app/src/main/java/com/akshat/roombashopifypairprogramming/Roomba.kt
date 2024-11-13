package com.akshat.roombashopifypairprogramming


enum class Direction {
    UP, RIGHT, DOWN, LEFT
}

class Roomba(private val gridSize: Int = 10) {
    var x: Int = 0
    var y: Int = 0
    var direction: Direction = Direction.RIGHT

    fun moveForward() {
        when (direction) {
            Direction.UP -> if (y > 0) y-- else turnRight()
            Direction.DOWN -> if (y < gridSize - 1) y++ else turnRight()
            Direction.LEFT -> if (x > 0) x-- else turnRight()
            Direction.RIGHT -> if (x < gridSize - 1) x++ else turnRight()
        }
    }

    fun turnRight() {
        direction = when (direction) {
            Direction.UP -> Direction.RIGHT
            Direction.RIGHT -> Direction.DOWN
            Direction.DOWN -> Direction.LEFT
            Direction.LEFT -> Direction.UP
        }
    }
}
package com.akshat.roombashopifypairprogramming

import junit.framework.TestCase.assertEquals
import org.junit.Before
import org.junit.Test

class RoombaTest {
    private lateinit var roomba: Roomba

    @Before
    fun setUp() {
        roomba = Roomba()
    }

    @Test
    fun `initial position and direction`() {
        assertEquals(0, roomba.x)
        assertEquals(0, roomba.y)
        assertEquals(Direction.RIGHT, roomba.direction)
    }

    @Test
    fun `turn right changes direction clockwise`() {
        roomba.turnRight()
        assertEquals(Direction.DOWN, roomba.direction)
        roomba.turnRight()
        assertEquals(Direction.LEFT, roomba.direction)
        roomba.turnRight()
        assertEquals(Direction.UP, roomba.direction)
        roomba.turnRight()
        assertEquals(Direction.RIGHT, roomba.direction)
    }


    @Test
    fun `move forward hits right wall and turns down`() {
        roomba.x = 9
        roomba.direction = Direction.RIGHT
        roomba.moveForward()
        assertEquals(9, roomba.x)
        assertEquals(0, roomba.y)
        assertEquals(Direction.DOWN, roomba.direction)
    }

    @Test
    fun `move forward hits top wall and turns right`() {
        roomba.y = 0
        roomba.direction = Direction.UP
        roomba.moveForward()
        assertEquals(0, roomba.x)
        assertEquals(0, roomba.y)
        assertEquals(Direction.RIGHT, roomba.direction)
    }

    @Test
    fun `move forward hits bottom wall and turns up`() {
        roomba.y = 9
        roomba.direction = Direction.DOWN
        roomba.moveForward()
        assertEquals(0, roomba.x)
        assertEquals(9, roomba.y)
        assertEquals(Direction.LEFT, roomba.direction)
    }


    @Test
    fun `move forward hits left wall and turns up`() {
        roomba.x = 0
        roomba.direction = Direction.LEFT
        roomba.moveForward()
        assertEquals(0, roomba.x)
        assertEquals(0, roomba.y)
        assertEquals(Direction.UP, roomba.direction)
    }


}
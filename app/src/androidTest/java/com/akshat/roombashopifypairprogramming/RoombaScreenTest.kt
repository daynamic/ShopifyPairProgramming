package com.akshat.roombashopifypairprogramming

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import org.junit.Rule
import org.junit.Test

class RoombaScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun testInitialpositionAndDirection() {
        composeTestRule.setContent {
            RoombaApp()
        }

        composeTestRule.onNodeWithText("Position: (0, 0)\nFacing: RIGHT").assertExists()
    }

    @Test
    fun testMoveForward() {
        composeTestRule.setContent {
            RoombaApp()
        }

        composeTestRule.onNodeWithText("Move").performClick()
        composeTestRule.onNodeWithText("Position: (1, 0)\nFacing: RIGHT").assertExists()
    }

    @Test
    fun testTurnRight() {
        composeTestRule.setContent {
            RoombaApp()
        }

        composeTestRule.onNodeWithText("Turn").performClick()
        composeTestRule.onNodeWithText("Position: (0, 0)\nFacing: DOWN").assertExists()
    }

    @Test
    fun testMoveAndTurnRight() {
        composeTestRule.setContent {
            RoombaApp()
        }

        composeTestRule.onNodeWithText("Move").performClick()
        composeTestRule.onNodeWithText("Position: (1, 0)\nFacing: RIGHT").assertExists()

        composeTestRule.onNodeWithText("Turn").performClick()
        composeTestRule.onNodeWithText("Position: (1, 0)\nFacing: DOWN").assertExists()

        composeTestRule.onNodeWithText("Move").performClick()
        composeTestRule.onNodeWithText("Position: (1, 1)\nFacing: DOWN").assertExists()
    }

    @Test
    fun testWallCollisionAndTurnRight() {
        composeTestRule.setContent {
            RoombaApp()
        }

        repeat(10) {
            composeTestRule.onNodeWithText("Move").performClick()
        }

        composeTestRule.onNodeWithText("Position: (9, 0)\nFacing: DOWN").assertExists()
    }
}
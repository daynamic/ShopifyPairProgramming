package com.akshat.roombashopifypairprogramming

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.akshat.roombashopifypairprogramming.ui.theme.RoombaShopifyPairProgrammingTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RoombaShopifyPairProgrammingTheme {
                RoombaApp()
            }
        }
    }
}

@Composable
fun RoombaGrid(roombaX: Int, roombaY: Int, roombaDirection: Direction) {
    val gridSize = 10

    LazyVerticalGrid(
        columns = GridCells.Fixed(gridSize),
        modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(1f)
            .background(Color.Black)
    ) {
        items(gridSize * gridSize) { index ->
            val x = index % gridSize
            val y = index / gridSize

            Box(
                modifier = Modifier
                    .size(36.dp)
                    .background(if (x == roombaX && y == roombaY) Color.White else Color.White)
                    .padding(1.dp),
                contentAlignment = Alignment.Center
            ) {
                if (x == roombaX && y == roombaY) {
                    Text(
                        text = when (roombaDirection) {
                            Direction.UP -> "↑"
                            Direction.RIGHT -> "→"
                            Direction.DOWN -> "↓"
                            Direction.LEFT -> "←"
                        },
                        color = Color.Blue,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }


        }

    }

}

@Composable
fun RoombaApp() {
    Scaffold(modifier = Modifier.fillMaxSize()) { _ ->
        var x by remember { mutableIntStateOf(0) }
        var y by remember { mutableIntStateOf(0) }
        var direction by remember { mutableStateOf(Direction.RIGHT) }
        val roomba = remember { Roomba() }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            RoombaGrid(
                x, y, direction
            )

            Text(
                text = "Position: ($x, $y)\nFacing: $direction",
                modifier = Modifier.padding(16.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))


            Button(
                onClick = {
                    roomba.moveForward()
                    x = roomba.x
                    y = roomba.y
                    direction = roomba.direction
                },
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth()
            ) {
                Text(text = "Move")
            }

            Button(
                onClick = {
                    roomba.turnRight()
                    direction = roomba.direction
                },
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth()
            ) {
                Text(text = "Turn")
            }


        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    RoombaShopifyPairProgrammingTheme {
        RoombaApp()
    }
}
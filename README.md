### This program is representation of a Pair programming task given in an interview with Shopify

Roomba

Create a single-screen app that allows the user to move a “roomba” around a 10x10 grid. Movement is restricted to two buttons: one to move forward, and one to turn right.
Your representation of the roomba on the grid must indicate the direction that the roomba is currently facing.
The roomba cannot pass through walls; if it hits a wall, it should automatically turn right instead of moving forward.


### Solution


https://github.com/user-attachments/assets/b10a588d-e0af-4d12-a5a7-c3b04354aff6



<img width="350" alt="image" src="https://github.com/user-attachments/assets/97f2d559-0c70-4bfc-86c0-a2423a38d58d">


Explaination of Solution:-

**Roomba.kt** - model class (for movement and direction logic) 

**MainActivity.Kt** - RoombaApp composable for UI - Roomba observable using a MutableState in the UI and adjusting the code structure so that any changes to Roomba’s state are reflected immediately in the UI.


**RoombaTest:** Tests the Roomba class for correct movement and direction logic.


**RoombaScreenTest:** Uses ComposeTestRule to test initial state and button functionality in the UI.








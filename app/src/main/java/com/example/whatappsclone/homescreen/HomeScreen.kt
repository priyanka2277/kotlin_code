package com.example.whatappsclone.homescreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.CameraAlt
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.MoreHoriz
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp




val chats = listOf(

    Chat(
        name = "Andrew Parker",
        message = "What kind of strategy is better?",
        time = "11/16/19"
    ),

    Chat(
        name = "Karen Castillo",
        message = "0:14",
        time = "11/15/19"
    ),

    Chat(
        name = "Maximillian Jacobson",
        message = "Bro, I have a good idea!",
        time = "10/30/19"
    ),

    Chat(
        name ="Preeti joshi",
        message ="hello world",
        time = "10/30/10"
    ),

    Chat(
        name ="Kalpana Joshi",
        message ="hi world",
        time ="10/30/10"
    ),

    Chat(
        name ="Meenu Joshi",
        message ="hi world it s me",
        time ="10/30/10"
    ),

    Chat(
        name ="Anita paneru",
        message = "hi world its me world",
        time ="10/30/10"
    ),
    Chat(
        name ="Laxmi Paneru",
        message="hi this is the world",
        time ="10/30/10"
    )


)



@Composable
@Preview(showSystemUi = true)
fun HomeScreen() {

    Scaffold(
        bottomBar = {
            BottomNavigationBar()
        }
    ) { paddingValues ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {


            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        start = 16.dp,
                        end = 16.dp,
                        top = 12.dp
                    ),

                horizontalArrangement = Arrangement.SpaceBetween,

                verticalAlignment = Alignment.CenterVertically
            ) {

                Text(
                    text = "Edit",
                    fontSize = 16.sp,
                    color = Color.Blue
                )

                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Text(
                        text = "Chats",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(
                        modifier = Modifier.width(70.dp)
                    )

                    IconButton(
                        onClick = {}
                    ) {

                        Icon(
                            imageVector = Icons.Default.Edit,
                            contentDescription = "New message"
                        )
                    }
                }
            }



            Spacer(
                modifier = Modifier.height(15.dp)
            )




            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),

                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                Text(
                    text = "Broadcast Lists",
                    fontSize = 14.sp,
                    color = Color.Blue
                )

                Text(
                    text = "New Group",
                    fontSize = 14.sp,
                    color = Color.Blue
                )
            }


            Spacer(
                modifier = Modifier.height(8.dp)
            )




            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
            ) {

                items(chats) { chat ->

                    ChatItem(
                        chat = chat
                    )
                }
            }
        }
    }
}




@Composable
fun ChatItem(
    chat: Chat
) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                horizontal = 12.dp,
                vertical = 8.dp
            ),

        verticalAlignment = Alignment.CenterVertically
    ) {



        Box(
            modifier = Modifier
                .size(52.dp)
                .clip(CircleShape)
                .background(Color.LightGray),

            contentAlignment = Alignment.Center
        ) {

            Icon(
                imageVector = Icons.Default.Person,
                contentDescription = "Profile"
            )
        }




        Spacer(
            modifier = Modifier.width(12.dp)
        )




        Column(
            modifier = Modifier.weight(1f)
        ) {

            Text(
                text = chat.name,
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold
            )

            Spacer(
                modifier = Modifier.height(3.dp)
            )

            Text(
                text = chat.message,
                fontSize = 14.sp,
                color = Color.Gray,
                maxLines = 1
            )
        }



        Text(
            text = chat.time,
            fontSize = 12.sp,
            color = Color.Gray
        )
    }
}



@Composable
fun BottomNavigationBar() {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),

        horizontalArrangement = Arrangement.SpaceEvenly,

        verticalAlignment = Alignment.CenterVertically
    ) {

        BottomItem(
            icon = Icons.Default.Person,
            text = "Status"
        )

        BottomItem(
            icon = Icons.Default.Call,
            text = "Calls"
        )

        BottomItem(
            icon = Icons.Default.CameraAlt,
            text = "Camera"
        )

        BottomItem(
            icon = Icons.Default.MoreHoriz,
            text = "Chats"
        )

        BottomItem(
            icon = Icons.Default.Settings,
            text = "Settings"
        )
    }
}



@Composable
fun BottomItem(
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    text: String
) {

    val selected = text == "Chats"

    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Icon(
            imageVector = icon,
            contentDescription = text,

            tint = if (selected) {
                Color.Blue
            } else {
                Color.Gray
            },

            modifier = Modifier.size(22.dp)
        )

        Text(
            text = text,
            fontSize = 10.sp,

            color = if (selected) {
                Color.Blue
            } else {
                Color.Gray
            }
        )
    }
}
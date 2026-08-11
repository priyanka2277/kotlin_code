package com.example.whatappsclone.EditMessage

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


val chats = listOf(

    EditChat(
        name = "Martin Randolph",
        message = "Yes, 2m is awesome",
        time = "11/19/19",
        initials = "MR"
    ),

    EditChat(
        name = "Andrew Parker",
        message = "What kind of strategy is better?",
        time = "11/16/19",
        initials = "AP"
    ),

    EditChat(
        name = "Karen Castillo",
        message = "0:14",
        time = "11/15/19",
        initials = "KC"
    ),

    EditChat(
        name = "Maximillian Jacobson",
        message = "Bro, I have a good idea!",
        time = "10/30/19",
        initials = "MJ"
    ),

    EditChat(
        name = "Martha Craig",
        message = "Photo",
        time = "10/28/19",
        initials = "MC"
    ),

    EditChat(
        name = "Tabitha Potter",
        message = "Actually I wanted to check with you",
        time = "8/25/19",
        initials = "TP"
    ),

    EditChat(
        name = "Maisy Humphery",
        message = "Welcome, to make design process faster",
        time = "8/20/19",
        initials = "MH"
    ),

    EditChat(
        name = "Kieron Dotson",
        message = "Ok, have a good trip!",
        time = "7/29/19",
        initials = "KD"
    )
)


@Composable
@Preview(showSystemUi = true)
fun EditMessage() {


    val selectedChats = remember {
        mutableStateListOf<String>()
    }

    Scaffold(
        bottomBar = {
            BottomActionBar(
                selectedCount = selectedChats.size
            )
        }
    ) { paddingValues ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .background(Color.White)
        ) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        start = 16.dp,
                        end = 16.dp,
                        top = 12.dp
                    ),

                verticalAlignment = Alignment.CenterVertically
            ) {


                Text(
                    text = "Done",
                    color = Color(0xFF007AFF),
                    fontSize = 16.sp,
                    modifier = Modifier
                        .clickable {
                            selectedChats.clear()
                        }
                )

                Box(
                    modifier = Modifier.weight(1f),
                    contentAlignment = Alignment.Center
                ) {

                    Text(
                        text = "Chats",
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold
                    )
                }

                Spacer(
                    modifier = Modifier.width(40.dp)
                )
            }


            Spacer(
                modifier = Modifier.height(14.dp)
            )


            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        start = 12.dp,
                        end = 12.dp
                    ),

                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                Text(
                    text = "Broadcast Lists",
                    color = Color.LightGray,
                    fontSize = 14.sp
                )

                Text(
                    text = "New Group",
                    color = Color.LightGray,
                    fontSize = 14.sp
                )
            }


            Spacer(
                modifier = Modifier.height(6.dp)
            )


            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
            ) {

                items(
                    items = chats,
                    key = { chat -> chat.name }
                ) { chat ->

                    EditChatItem(
                        chat = chat,

                        selected = selectedChats.contains(
                            chat.name
                        ),

                        onClick = {

                            if (selectedChats.contains(chat.name)) {
                                selectedChats.remove(chat.name)

                            } else {
                                selectedChats.add(chat.name)
                            }
                        }
                    )
                }
            }
        }
    }
}



@Composable
fun EditChatItem(
    chat: EditChat,
    selected: Boolean,
    onClick: () -> Unit
) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                onClick()
            }
            .padding(
                horizontal = 12.dp,
                vertical = 7.dp
            ),

        verticalAlignment = Alignment.CenterVertically
    ) {


        Box(
            modifier = Modifier
                .size(20.dp)
                .border(
                    width = 1.dp,
                    color = if (selected) {
                        Color(0xFF007AFF)
                    } else {
                        Color.LightGray
                    },
                    shape = CircleShape
                )
                .background(
                    color = if (selected) {
                        Color(0xFF007AFF)
                    } else {
                        Color.Transparent
                    },
                    shape = CircleShape
                ),

            contentAlignment = Alignment.Center
        ) {

            if (selected) {

                Text(
                    text = "✓",
                    color = Color.White,
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }


        Spacer(
            modifier = Modifier.width(10.dp)
        )



        Box(
            modifier = Modifier
                .size(45.dp)
                .clip(CircleShape)
                .background(Color.LightGray),

            contentAlignment = Alignment.Center
        ) {

            Text(
                text = chat.initials,
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                color = Color.DarkGray
            )
        }


        Spacer(
            modifier = Modifier.width(10.dp)
        )


        Column(
            modifier = Modifier.weight(1f)
        ) {

            Text(
                text = chat.name,
                fontSize = 15.sp,
                fontWeight = FontWeight.SemiBold,
                maxLines = 1
            )

            Spacer(
                modifier = Modifier.height(3.dp)
            )

            Text(
                text = chat.message,
                fontSize = 12.sp,
                color = Color.Gray,
                maxLines = 1
            )
        }


        Text(
            text = chat.time,
            fontSize = 10.sp,
            color = Color.Gray
        )
    }
}



@Composable
fun BottomActionBar(
    selectedCount: Int
) {

    val enabled = selectedCount > 0

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFFF8F8F8))
            .padding(
                horizontal = 30.dp,
                vertical = 12.dp
            ),

        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {


        Text(
            text = "Archive",
            fontSize = 14.sp,

            color = if (enabled) {
                Color(0xFF007AFF)
            } else {
                Color.Gray
            },

            modifier = Modifier.clickable(
                enabled = enabled
            ) {

            }
        )



        Text(
            text = "Read All",
            fontSize = 14.sp,

            color = if (enabled) {
                Color(0xFF007AFF)
            } else {
                Color.Gray
            },

            modifier = Modifier.clickable(
                enabled = enabled
            ) {

            }
        )



        Text(
            text = "Delete",
            fontSize = 14.sp,

            color = if (enabled) {
                Color.Red
            } else {
                Color.Gray
            },

            modifier = Modifier.clickable(
                enabled = enabled
            ) {

            }
        )
    }
}
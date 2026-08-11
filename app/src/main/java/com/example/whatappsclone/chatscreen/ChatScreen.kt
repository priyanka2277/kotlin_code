package com.example.whatappsclone.chatscreen

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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.CameraAlt
import androidx.compose.material.icons.filled.Mic
import androidx.compose.material.icons.filled.VideoCall
import androidx.compose.material.icons.filled.InsertDriveFile
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
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



data class Message(
    val text: String = "",
    val time: String,
    val isSent: Boolean,
    val isFile: Boolean = false,
    val fileName: String = "",
    val fileSize: String = ""
)



val messages = listOf(

    Message(
        text = "Good bye!",
        time = "17:47",
        isSent = true
    ),

    Message(
        text = "Good morning!",
        time = "10:10",
        isSent = true
    ),

    Message(
        text = "Japan looks amazing!",
        time = "10:10",
        isSent = true
    ),

    Message(
        time = "10:15",
        isSent = true,
        isFile = true,
        fileName = "IMG_0475",
        fileSize = "2.4 MB · png"
    ),

    Message(
        time = "10:15",
        isSent = true,
        isFile = true,
        fileName = "IMG_0481",
        fileSize = "2.8 MB · png"
    ),

    Message(
        text = "Do you know what time is it?",
        time = "11:40",
        isSent = false
    ),

    Message(
        text = "It's morning in Tokyo 😎",
        time = "11:43",
        isSent = true
    ),

    Message(
        text = "What is the most popular meal in Japan?",
        time = "11:45",
        isSent = false
    ),

    Message(
        text = "Do you like it?",
        time = "11:45",
        isSent = false
    ),

    Message(
        text = "I think top two are:",
        time = "11:50",
        isSent = true
    ),

    Message(
        time = "11:51",
        isSent = true,
        isFile = true,
        fileName = "IMG_0483",
        fileSize = "2.8 MB · png"
    ),

    Message(
        time = "11:51",
        isSent = true,
        isFile = true,
        fileName = "IMG_0484",
        fileSize = "2.6 MB · png"
    )
)



@Composable
@Preview(showSystemUi = true)
fun ChatScreen() {

    var messageText by remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFEFE7DE))
    ) {



        ChatTopBar()


        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
        ) {

            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(
                        horizontal = 8.dp
                    ),

                verticalArrangement = Arrangement.Bottom
            ) {

                item {

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(
                                vertical = 8.dp
                            ),

                        horizontalArrangement = Arrangement.Center
                    ) {

                        Text(
                            text = "Fri, Jul 26",
                            fontSize = 12.sp,
                            color = Color.DarkGray,

                            modifier = Modifier
                                .background(
                                    Color(0xFFE1D9D0),
                                    RoundedCornerShape(8.dp)
                                )
                                .padding(
                                    horizontal = 10.dp,
                                    vertical = 5.dp
                                )
                        )
                    }
                }


                items(messages) { message ->

                    MessageItem(
                        message = message
                    )
                }
            }
        }



        MessageInput(
            value = messageText,

            onValueChange = {
                messageText = it
            }
        )
    }
}


@Composable
fun ChatTopBar() {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(70.dp)
            .background(Color.White)
            .padding(
                horizontal = 4.dp
            ),

        verticalAlignment = Alignment.CenterVertically
    ) {


        IconButton(
            onClick = {}
        ) {

            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "Back",
                tint = Color(0xFF007AFF)
            )
        }




        Box(
            modifier = Modifier
                .size(42.dp)
                .clip(CircleShape)
                .background(Color(0xFFB79A70)),

            contentAlignment = Alignment.Center
        ) {

            Text(
                text = "MC",
                color = Color.White,
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold
            )
        }


        Spacer(
            modifier = Modifier.width(10.dp)
        )




        Column(
            modifier = Modifier.weight(1f)
        ) {

            Text(
                text = "Martha Craig",
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = "tap here for contact info",
                fontSize = 11.sp,
                color = Color.Gray
            )
        }

        IconButton(
            onClick = {}
        ) {

            Icon(
                imageVector = Icons.Default.VideoCall,
                contentDescription = "Video Call",
                tint = Color(0xFF007AFF)
            )
        }


        // CALL BUTTON

        IconButton(
            onClick = {}
        ) {

            Icon(
                imageVector = Icons.Default.Call,
                contentDescription = "Call",
                tint = Color(0xFF007AFF)
            )
        }
    }
}




@Composable
fun MessageItem(
    message: Message
) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                vertical = 2.dp
            ),

        horizontalArrangement =
            if (message.isSent) {
                Arrangement.End
            } else {
                Arrangement.Start
            }
    ) {

        if (message.isFile) {

            FileMessage(
                message = message
            )

        } else {

            MessageBubble(
                message = message
            )
        }
    }
}



@Composable
fun MessageBubble(
    message: Message
) {

    val bubbleColor =
        if (message.isSent) {
            Color(0xFFD9FDD3)
        } else {
            Color.White
        }


    Row(
        modifier = Modifier
            .widthInSafe(250.dp)
            .background(
                color = bubbleColor,
                shape = RoundedCornerShape(
                    topStart = 10.dp,
                    topEnd = 10.dp,
                    bottomStart =
                        if (message.isSent) 10.dp else 2.dp,
                    bottomEnd =
                        if (message.isSent) 2.dp else 10.dp
                )
            )
            .padding(
                start = 10.dp,
                end = 7.dp,
                top = 6.dp,
                bottom = 4.dp
            ),

        verticalAlignment = Alignment.Bottom
    ) {

        Text(
            text = message.text,
            fontSize = 14.sp,
            color = Color.Black,

            modifier = Modifier.weight(
                1f,
                fill = false
            )
        )


        Spacer(
            modifier = Modifier.width(6.dp)
        )


        Text(
            text = message.time,
            fontSize = 9.sp,
            color = Color.Gray
        )


        if (message.isSent) {

            Text(
                text = "✓✓",
                fontSize = 9.sp,
                color = Color(0xFF39A7E8)
            )
        }
    }
}



@Composable
fun FileMessage(
    message: Message
) {

    Row(
        modifier = Modifier
            .width(220.dp)
            .background(
                Color(0xFFD9FDD3),
                RoundedCornerShape(8.dp)
            )
            .padding(8.dp),

        verticalAlignment = Alignment.CenterVertically
    ) {



        Box(
            modifier = Modifier
                .size(42.dp)
                .background(
                    Color.White,
                    RoundedCornerShape(5.dp)
                ),

            contentAlignment = Alignment.Center
        ) {

            Icon(
                imageVector = Icons.Default.InsertDriveFile,
                contentDescription = "File",
                tint = Color(0xFF5D9CEC)
            )
        }


        Spacer(
            modifier = Modifier.width(8.dp)
        )


        Column(
            modifier = Modifier.weight(1f)
        ) {

            Text(
                text = message.fileName,
                fontSize = 13.sp,
                maxLines = 1
            )

            Spacer(
                modifier = Modifier.height(2.dp)
            )

            Text(
                text = message.fileSize,
                fontSize = 9.sp,
                color = Color.Gray
            )
        }


        Column(
            horizontalAlignment = Alignment.End
        ) {

            Text(
                text = message.time,
                fontSize = 9.sp,
                color = Color.Gray
            )

            Text(
                text = "✓✓",
                fontSize = 9.sp,
                color = Color(0xFF39A7E8)
            )
        }
    }
}

@Composable
fun MessageInput(
    value: String,
    onValueChange: (String) -> Unit
) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(
                horizontal = 5.dp,
                vertical = 5.dp
            ),

        verticalAlignment = Alignment.CenterVertically
    ) {



        IconButton(
            onClick = {}
        ) {

            Icon(
                imageVector = Icons.Default.Add,
                contentDescription = "Add",
                tint = Color(0xFF007AFF)
            )
        }




        TextField(
            value = value,

            onValueChange = onValueChange,

            modifier = Modifier
                .weight(1f)
                .height(48.dp),

            placeholder = {
                Text(
                    text = ""
                )
            },

            singleLine = true,

            shape = RoundedCornerShape(
                24.dp
            ),

            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.White,
                unfocusedContainerColor = Color.White,

                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            )
        )




        IconButton(
            onClick = {}
        ) {

            Icon(
                imageVector = Icons.Default.CameraAlt,
                contentDescription = "Camera",
                tint = Color(0xFF007AFF)
            )
        }




        IconButton(
            onClick = {}
        ) {

            Icon(
                imageVector = Icons.Default.Mic,
                contentDescription = "Microphone",
                tint = Color(0xFF007AFF)
            )
        }
    }
}



private fun Modifier.widthInSafe(
    maxWidth: androidx.compose.ui.unit.Dp
): Modifier {

    return this.width(
        maxWidth
    )
}
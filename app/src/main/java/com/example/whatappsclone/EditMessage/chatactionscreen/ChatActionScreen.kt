package com.example.whatappsclone.EditMessage.chatactionscreen


import androidx.compose.foundation.background
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
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


@Composable
@Preview(showSystemUi = true)
fun ChatActionScreen() {

    var showMenu by remember {
        mutableStateOf(true)
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp)
        ) {

            Text(
                text = "Chats",
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(
                modifier = Modifier.height(20.dp)
            )

            Text(
                text = "Martin Randolph",
                fontSize = 16.sp
            )

            Spacer(
                modifier = Modifier.height(15.dp)
            )

            Text(
                text = "Andrew Parker",
                fontSize = 16.sp
            )

            Spacer(
                modifier = Modifier.height(15.dp)
            )

            Text(
                text = "Karen Castillo",
                fontSize = 16.sp
            )
        }

        if (showMenu) {

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        Color.Black.copy(
                            alpha = 0.40f
                        )
                    )
            ) {

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            start = 12.dp,
                            end = 12.dp,
                            bottom = 12.dp
                        )
                        .align(Alignment.BottomCenter)
                ) {

                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(
                                color = Color.White,
                                shape = RoundedCornerShape(
                                    12.dp
                                )
                            )
                    ) {

                        ActionItem(
                            text = "Mute",
                            onClick = {
                                showMenu = false
                            }
                        )

                        ActionDivider()

                        ActionItem(
                            text = "Contact Info",
                            onClick = {
                                showMenu = false
                            }
                        )

                        ActionDivider()

                        ActionItem(
                            text = "Export Chat",
                            onClick = {
                                showMenu = false
                            }
                        )

                        ActionDivider()

                        ActionItem(
                            text = "Clear Chat",
                            onClick = {
                                showMenu = false
                            }
                        )

                        ActionDivider()

                        ActionItem(
                            text = "Delete Chat",
                            textColor = Color.Red,
                            onClick = {
                                showMenu = false
                            }
                        )
                    }


                    Spacer(
                        modifier = Modifier.height(6.dp)
                    )

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(
                                color = Color.White,
                                shape = RoundedCornerShape(
                                    12.dp
                                )
                            )
                            .clickable {
                                showMenu = false
                            }
                            .padding(
                                vertical = 14.dp
                            ),

                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Text(
                            text = "Cancel",
                            color = Color(0xFF007AFF),
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Medium
                        )
                    }
                }
            }
        }
    }
}



@Composable
fun ActionItem(
    text: String,
    textColor: Color = Color(0xFF007AFF),
    onClick: () -> Unit
) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                onClick()
            }
            .padding(
                vertical = 14.dp
            ),

        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {

        Text(
            text = text,
            color = textColor,
            fontSize = 15.sp
        )
    }
}


@Composable
fun ActionDivider() {

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(1.dp)
            .background(
                Color(0xFFE5E5E5)
            )
    )
}
This project is a WhatsApp inspired Android chat applicaton developed using Kotlin and jetpack Compose.
The purpose of the project is to recreate the user interface and basic navigation flow of messaging application based on the provided UI/Figma designs.
the application currently focuses on creating the following screens:
Register screen
Home Screen
Edit Chats Screen
Chat Actions Screen
Indivvidual Chat Screen

Technologies Used
kotlin Main programming language
Gradle  Project/build management
git      Version control
github Source-code repository

Home/Chats Screen
it contains 
chats title
Edit button
broadcast lists
new groups 
list of conversations
bottom navigation

Edit Message Screen
The edit message screen allows the user to select conversations.
The screen contains 
done button
chats title
broadcast lists
new group
conversation list
chat selectio functionality

Chat Action Screen
Available actions include
mute
contact info
export chat
clear chat
delete chat
cancel

individual chat screen
back button
incoming messsage
outgoing message

The ui architecture
The application used Jetpack Compose and follows a composable based ui structure
Each screen is implemented as a @Composable function.

Conclusion
This project demonstrates the development of a modern Android messaging interface using Kotlin and Jetpack Compose.The application is structures into reusable composable components and separate screen packages,making it easier 
to exted the project with real messaging functionality and backend service in the future.

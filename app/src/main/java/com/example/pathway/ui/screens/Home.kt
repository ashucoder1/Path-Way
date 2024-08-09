package com.example.pathway.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun HomeScreen() {
    Box(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.padding(start = 8.dp))
        {
            Row(
                modifier = Modifier
                    .padding(top = 16.dp)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.Bottom
            ) {
                Image(
                    imageVector = Icons.Filled.Person, contentDescription = "Profile",
                    modifier = Modifier.size(50.dp)
                )
                Column(Modifier.padding(start = 4.dp, end = 60.dp))
                {
                    Text(text = "Welcome 💕")
                    Text(text = "Ashu Yadav", fontSize = 24.sp)
                }
                Image(
                    imageVector = Icons.Filled.Notifications,
                    contentDescription = "notification",
                    modifier = Modifier.size(35.dp)
                )
            }
            Card(
                modifier = Modifier
                    .padding(top = 8.dp)
                    .size(200.dp, 125.dp),
                shape = RoundedCornerShape(18.dp),
                elevation = CardDefaults.elevatedCardElevation(defaultElevation = 8.dp)
            ) {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.Cyan,
                ) {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.SpaceAround
                    ) {
                        Text(text = "Project: AI Chatbot")
                        Text(text = "Progress: 67% Completed")

                        ElevatedButton(onClick = {  },
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 4.dp, end = 4.dp, top = 8.dp),
                            shape = RoundedCornerShape(18.dp)
                        )
                        {
                            Text(text = "Click to open Project!")
                        }
                    }

                }
            }


        }

    }
}

@Composable
@Preview(showBackground = true)
fun HomeScreenPreview() {
    HomeScreen()
}
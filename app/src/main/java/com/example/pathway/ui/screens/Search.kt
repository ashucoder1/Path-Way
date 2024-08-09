package com.example.pathway.ui.screens

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pathway.LoadingAnimation
import com.example.pathway.generateFunction
import com.example.pathway.ui.theme.Brown
import com.example.pathway.ui.theme.Terracotta

@Composable
fun SearchScreen() {
    var text by remember { mutableStateOf("") }
    var output by remember { mutableStateOf("") }
    var isLoading by remember { mutableStateOf(false) }
    val context= LocalContext.current
    val rainbowColors =
        listOf<Color>(Color.Red.copy(alpha = 0.9f), Color.Green, Color.Yellow, Color.Cyan)
    val brush = remember {
        Brush.linearGradient(
            colors = rainbowColors
        )
    }
    val scrollState = rememberScrollState()
    val historyList = remember { mutableStateListOf("Food Delivery", "E-commerce", "Banking", "Travel App", "Weather") }

    Box(modifier = Modifier.fillMaxSize())
    {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 16.dp, start = 8.dp)
        )
        {
            Text(text = "Find Your Favourite App Here 💕", fontSize = 18.sp)
            OutlinedTextField(
                modifier = Modifier.padding(0.dp, 4.dp),
                value = text,
                onValueChange = { text = it },
                label = { Text(text = "Enter App Type ") },
                maxLines = 2,
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done)
            )
            Spacer(modifier = Modifier.height(4.dp))
            Button(
                onClick = { isLoading=true
                    generateFunction(text) { result ->
                        output = result
                        historyList.add(text)
                        text=""
                        isLoading=false
                        Toast.makeText(context,"Check Path Screen",Toast.LENGTH_SHORT).show()
                    } },
                elevation = ButtonDefaults.buttonElevation(4.dp),
                border = BorderStroke(3.dp, Brown),
                colors = ButtonDefaults.buttonColors(containerColor = Terracotta)
            )
            {
                Icon(imageVector = Icons.Filled.Search, contentDescription = "Search")
                Text(
                    text = "Generate with AI",
                    modifier = Modifier.padding(start = 10.dp),
                    style = TextStyle(brush)
                )
            }
            Text(
                text = "Recent Searches:", modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 24.dp, bottom = 8.dp),
                fontSize = 18.sp
            )
            Column(modifier = Modifier.verticalScroll(scrollState)) {
                historyList.forEach() { item ->
                    Text(
                        text = item,
                        modifier = Modifier.padding(bottom = 4.dp, start = 8.dp),
                        color = Color.DarkGray
                    )
                }
            }
            if (isLoading){
                LoadingAnimation()
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun SearchScreenPreview() {
    SearchScreen()
}
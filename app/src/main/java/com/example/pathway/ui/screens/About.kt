package com.example.pathway.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun AboutScreen() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            Modifier.padding(start =8.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        )
        {
            Text(
                text = "PathWay",
                fontSize = 32.sp,
                fontWeight = FontWeight.SemiBold
            )
            Spacer(modifier = Modifier.height(18.dp))
            Text(
                text = "Developed with 💖 by",
                fontSize = 28.sp,
            )
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                text = "Ashu Yadav",
                fontSize = 24.sp,
                fontStyle = FontStyle.Italic
            )
        }
        Text(
            text = "App Version - v1.1",
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(12.dp),
            fontSize = 18.sp
        )
    }

}

@Composable
@Preview(showBackground = true)
fun AboutScreenPreview() {
    AboutScreen()
}
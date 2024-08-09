package com.example.pathway.ui.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pathway.ui.theme.Manhattan

@Composable
fun HelpScreen() {
    val questionsAndAnswers = listOf(
        "What is this app about?" to "This app provides a roadmap for learning various technologies.",
        "How do I use this app?" to "Navigate through the different screens to explore tech stacks and user flows.",
        "What technologies are covered in the app?" to "The app covers front-end, back-end, database, and other technologies.",
        "Can I add my own technologies?" to "Currently, adding custom technologies is not supported.",
        "How do I track my progress?" to "You can track your progress through the user flow and roadmap sections.",
        "Is there a way to save my progress?" to "Saving progress is not yet implemented. This feature might be added in future updates.",
        "How can I contact support?" to "For support, please contact us via the 'Contact Us' section in the app.",
        "Are there any tutorials available?" to "Yes, tutorials are available in the resources section of the app.",
        "How frequently is the content updated?" to "Content updates depend on technology trends and user feedback.",
        "Can I suggest new features?" to "Feature suggestions can be submitted via the feedback form in the app."
    )


    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 8.dp, end = 8.dp,top=16.dp, bottom = 16.dp)
    )
    {
        item {
            Text(
                text = "Frequently Asked Questions",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(bottom = 16.dp)
            )
        }

        items(questionsAndAnswers.size) { index ->
            ExpandableFAQCard(
                question = questionsAndAnswers[index].first,
                answer = questionsAndAnswers[index].second
            )
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}


@Composable
fun ExpandableFAQCard(question: String, answer: String) {
    var expanded by remember { mutableStateOf(false) }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { expanded = !expanded },
        colors = CardDefaults.cardColors(containerColor = Manhattan.copy(alpha = 0.7f))
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        )
        {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = question,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier.weight(1f)
                )
                Icon(
                    imageVector = if (expanded) Icons.Filled.KeyboardArrowUp else Icons.Filled.KeyboardArrowDown,
                    contentDescription = null,
                    modifier = Modifier
                        .clickable { expanded = !expanded }
                        .size(24.dp)
                )
            }
            AnimatedVisibility(visible = expanded,
                enter = expandVertically()+ slideInVertically(initialOffsetY = {it}) + fadeIn(animationSpec = tween(delayMillis = 200)),
                exit = fadeOut(animationSpec = tween(durationMillis = 150)) + shrinkVertically()
            ) {
                Text(
                    text = answer,
                    fontSize = 16.sp,
                    modifier = Modifier.padding(top = 8.dp),
                    fontStyle = FontStyle.Italic
                )
            }

        }
    }
}

@Composable
@Preview(showBackground = true)
fun CardPreview() {
    ExpandableFAQCard(question = "question", answer = "Ans")
}
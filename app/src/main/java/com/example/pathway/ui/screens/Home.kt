package com.example.pathway.ui.screens

import androidx.compose.animation.Crossfade
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.pathway.NavRailPreview
import com.example.pathway.ui.theme.Amulet
import com.example.pathway.ui.theme.ManhattanLight
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.math.absoluteValue


@Composable
fun HomeScreen() {

    var imgList = listOf(
        "https://images.unsplash.com/photo-1723199688073-0c18e53c321b?q=80&w=1965&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D" to "Travel",
        "https://images.unsplash.com/photo-1494597564530-871f2b93ac55?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8N3x8aGVhbHRofGVufDB8fDB8fHww" to "Health",
        "https://images.unsplash.com/photo-1440404653325-ab127d49abc1?q=80&w=2070&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D" to "Movie Booking",
        "https://images.unsplash.com/photo-1511213966740-24d719a0a814?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8OHx8Z2FtZXxlbnwwfHwwfHx8MA%3D%3D" to "Gaming",
        "https://images.unsplash.com/photo-1415201364774-f6f0bb35f28f?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MTh8fG11c2ljfGVufDB8fDB8fHww" to "Music",
        "https://images.unsplash.com/photo-1460661419201-fd4cecdf8a8b?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8Mnx8QXJ0fGVufDB8fDB8fHww" to "Painting/Art",
        "https://media.istockphoto.com/id/486420378/photo/head-is-swimming-on-dance-floor.webp?b=1&s=170667a&w=0&k=20&c=lWqV2KXK9oOKM6QNImZTxIuDmMwR2duGKeCKQysaYHg=" to "Event Management",
        "https://media.istockphoto.com/id/1397185406/photo/portrait-of-woman-smiling-against-wall-with-palm-tree-shade.webp?b=1&s=170667a&w=0&k=20&c=JvQOX5ptSzgsb6mHtKU6L7DpEA4liqP1ub1M95pUB7E=" to "Clothes Store"
    )

    var item by remember { mutableStateOf(imgList.random()) }
    val couroutineScope = rememberCoroutineScope()

    val composition by rememberLottieComposition(spec = LottieCompositionSpec.Url("https://lottie.host/d0e5a156-1594-4ec4-800a-c156e6804793/N54qdXSIq3.json"))
    val progress by animateLottieCompositionAsState(
        composition,
        iterations = LottieConstants.IterateForever
    )
    val scrollState = rememberScrollState()
    LaunchedEffect(Unit) {
        while (true) {
            delay(9000)
            couroutineScope.launch {
                item = imgList.random()
            }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 8.dp, end = 8.dp)
            .verticalScroll(scrollState)
    )
    {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 32.dp),
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.End
        ) {
            Column()
            {
                Text(text = "Welcome 💕")
                Text(text = "Ashu Yadav", fontSize = 32.sp)
            }
            Image(
                imageVector = Icons.Filled.Person, contentDescription = "Profile",
                modifier = Modifier
                    .size(50.dp)
                    .padding(start = 4.dp)
            )
        }
        Crossfade(
            targetState = item,
            animationSpec = tween(durationMillis = 1000)
        ) { currentItem ->
            Card(
                modifier = Modifier
                    .padding(top = 18.dp)
                    .fillMaxWidth()
                    .height(270.dp),
                shape = CutCornerShape(18.dp),
                elevation = CardDefaults.elevatedCardElevation(defaultElevation = 10.dp),
                border = BorderStroke(3.dp, Amulet)
            ) {
                Column(modifier = Modifier.fillMaxSize()) {
                    AsyncImage(
                        model = currentItem.first,
                        contentDescription = "null",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.height(200.dp)
                    )
                    Text(
                        text = currentItem.second + " Application",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally)
                            .padding(4.dp)
                    )
                    Text(
                        text = "App Document-Report Available!!",
                        modifier = Modifier.align(Alignment.CenterHorizontally),
                        color = Color.Gray
                    )
                }
            }
        }
        Text(
            text = "Want help in development of Cool Applications ?",
            fontSize = 24.sp,
            modifier = Modifier.padding(vertical = 16.dp)
        )
        Row(
            modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            LottieAnimation(
                composition = composition, progress = { progress },
                modifier = Modifier.size(150.dp)
            )
            Column(verticalArrangement = Arrangement.SpaceBetween) {
                Row() {
                    Text(
                        text = " ● ",
                        modifier = Modifier.padding(end = 4.dp)
                    )
                    Text(
                        text = "Don't worry!\uD83D\uDE42",
                    )
                }
                Row(modifier = Modifier.padding(vertical = 8.dp)) {
                    Text(
                        text = " ● ",
                        modifier = Modifier.padding(end = 4.dp)
                    )
                    Text(
                        text = "Just get App in a single Click.",
                    )
                }
                Text(
                    modifier = Modifier
                        .padding(top = 8.dp)
                        .align(Alignment.CenterHorizontally),
                    text = "That's All ✔️",
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                )
            }

        }
        Text(
            text = "We have ideas for each of you.💡",
            fontSize = 24.sp,
            modifier = Modifier.padding(top = 18.dp, bottom = 8.dp)
        )
        Text(
            text = "Browse some ideas below :",
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(bottom = 8.dp),
            color = Color.DarkGray
        )
        AppTypeCarousel()

        AnimatedBorderCard(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 18.dp),
            shape = RoundedCornerShape(8.dp)
        )
        {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                val stepList = listOf(
                    "Start by clicking on the Search screen in Navigation.",
                    "Type the app-type you need in search bar.",
                    "Press \"Generate with AI\" and let the magic✨ happen. ",
                    "Click the Path Screen to see the results.",
                    "Ta-Daa🎊 Congrats on your first App.",
                    "Start your Dev journey afterwards."
                )
                Text(
                    text = "Follow these steps:",
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                stepList.forEachIndexed { index, step ->
                    Row(modifier = Modifier.padding(bottom = 4.dp)) {
                        Text(
                            text = "${index + 1}. ",
                            fontWeight = FontWeight.Bold,
                            fontSize = 18.sp,
                            modifier = Modifier.padding(end = 4.dp)
                        )
                        Text(
                            text = step,
                            fontSize = 18.sp,
                        )
                    }
                }
            }
        }

    }
}

@Composable
@Preview(showBackground = true)
fun HomeScreenPreview() {
    Row(modifier = Modifier.fillMaxSize()) {
        NavRailPreview()
        HomeScreen()
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun AppTypeCarousel() {
    val listItems = mutableListOf(
        "https://plus.unsplash.com/premium_photo-1670745084868-7b4f727cc934?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MXx8aGVubmF8ZW58MHx8MHx8fDA%3D" to "Henna",
        "https://images.unsplash.com/photo-1606101273945-e9eba91c0dc4?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NHx8YmFraW5nfGVufDB8fDB8fHww" to "Bakery",
        "https://images.unsplash.com/photo-1415369629372-26f2fe60c467?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8Mnx8cGV0fGVufDB8fDB8fHww" to "Pet Sitting",
        "https://images.unsplash.com/photo-1511923199659-1c16881689de?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MTB8fG1ha2V1cHxlbnwwfHwwfHx8MA%3D%3D" to "Makeup",
        "https://media.istockphoto.com/id/1495018397/photo/splendid-view-of-an-outdoor-wedding-premises.webp?b=1&s=170667a&w=0&k=20&c=5juwHbrxDa2cW2E7Pti_UItnEk3hbE_cuUNVPEyluiM=" to "Tent Service",
        "https://images.unsplash.com/photo-1653233797467-1a528819fd4f?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MTh8fGNoZWZ8ZW58MHx8MHx8fDA%3D" to "Chef Service",
    )
    listItems.shuffle()
    val pagerState = rememberPagerState(pageCount = { listItems.size })
    HorizontalPager(
        modifier = Modifier,
        state = pagerState,
        pageSize = PageSize.Fixed(270.dp),
    ) { page ->
        var (url, description) = listItems[page]
        Card(
            modifier = Modifier
                .fillMaxSize()
                .height(260.dp)
                .graphicsLayer {
                    val pageOffset =
                        ((pagerState.currentPage - page) + pagerState.currentPageOffsetFraction).absoluteValue
                    alpha = 0.85f + (1f - 0.85f) * (1f - pageOffset.coerceIn(0f, 1f))
                    val scale = 0.85f + (1f - 0.85f) * (1f - pageOffset.coerceIn(0f, 1f))
                    scaleX = scale
                    scaleY = scale

                },
            shape = CutCornerShape(18.dp),
            border = BorderStroke(3.dp, Amulet),
            elevation = CardDefaults.elevatedCardElevation(defaultElevation = 10.dp),

            ) {
            Column(
                modifier = Modifier.fillMaxSize()
            ) {
                AsyncImage(
                    model = url,
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.height(200.dp)
                )
                Button(
                    onClick = { /* Handle click here */ },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.White,  // Background color
                        contentColor = Color.Black      // Text color
                    ),
                    border = BorderStroke(2.dp, ManhattanLight),  // Border color and width
                    shape = RoundedCornerShape(8.dp),  // Rounded corners
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .padding(8.dp)
                ) {
                    Text(
                        text = "$description Application",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }

        }
    }
}

@Composable
fun AnimatedBorderCard(
    modifier: Modifier = Modifier,
    shape: Shape = RoundedCornerShape(size = 0.dp),
    borderWidth: Dp = 3.dp,
    gradient: Brush = Brush.sweepGradient(listOf(Color.Magenta, Color.Cyan)),
    animationDuration: Int = 10000,
    onCardClick: () -> Unit = {},
    content: @Composable () -> Unit
) {
    val infiniteTransition = rememberInfiniteTransition(label = "Infinite Color Animation")
    val degrees by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 360f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = animationDuration, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        ),
        label = "Infinite Colors"
    )

    Surface(
        modifier = modifier
            .clip(shape)
            .clickable { onCardClick() },
        shape = shape
    ) {
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .padding(borderWidth)
                .drawWithContent {
                    rotate(degrees = degrees) {
                        drawCircle(
                            brush = gradient,
                            radius = size.width,
                            blendMode = BlendMode.SrcIn,
                        )
                    }
                    drawContent()
                },
            color = ManhattanLight,
            shape = shape
        ) {
            content()
        }
    }
}

package com.example.pathway

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.runtime.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import kotlin.math.absoluteValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition


@Composable
fun ShowData(listItems: MutableList<String>, imageUrl: String) {
    Column() {
        listItems.forEachIndexed { index, item ->
            var imgUrl by remember { mutableStateOf("") }
            LaunchedEffect(item) {
                generateImage(item + " logo") { result -> imgUrl = result.toString() }
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            )
            {
                AsyncImage(
                    model = imgUrl,
                    contentDescription = null,
                    modifier = Modifier
                        .size(100.dp)
                        .padding(end = 8.dp),
                    contentScale = ContentScale.Crop
                )
                Text(text = item)
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ShowData2(listItems: MutableList<String>, imageUrl: String) {
    val pagerState = rememberPagerState(pageCount = { listItems.size })
    HorizontalPager(
        modifier = Modifier.padding(bottom = 16.dp),
        state = pagerState,
        pageSize = PageSize.Fixed(200.dp),
    ) { page ->
        val item = listItems[page]
        var imgUrl by remember { mutableStateOf("") }
        LaunchedEffect(item) {
            generateImage(item + " logo") { result -> imgUrl = result.toString() }
        }
        Card(modifier = Modifier
            .size(180.dp)
            .graphicsLayer {
                val pageOffset =
                    ((pagerState.currentPage - page) + pagerState.currentPageOffsetFraction).absoluteValue

                alpha = 0.8f + (1f - 0.8f) * (1f - pageOffset.coerceIn(0f, 1f))

                val scale = 0.85f + (1f - 0.85f) * (1f - pageOffset.coerceIn(0f, 1f))
                scaleX = scale
                scaleY = scale
            }
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                AsyncImage(
                    model = imgUrl,
                    contentDescription = null,
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxWidth(),
                    contentScale = ContentScale.Crop
                )
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.White)
                        .padding(8.dp)
                ) {
                    Text(
                        text = item,
                        modifier = Modifier.align(Alignment.Center)
                    )
                }
            }

        }
    }
}

@Composable
@Preview(showBackground = true)
fun ShowDataPreview() {
    ShowData2(listItems = mutableListOf("react", "android", "flutter"), imageUrl = "")
}


@Composable
fun ShowUserFlow(listItems: MutableList<String>) {
        listItems.forEach() { item ->
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = item,
                    fontSize = 18.sp,
                    modifier = Modifier.padding(bottom = 4.dp)
                )
                Icon(
                    imageVector = Icons.Filled.KeyboardArrowDown,
                    contentDescription = null,
                    modifier = Modifier
                        .size(60.dp)
                        .padding(bottom = 4.dp)
                )
            }
        }
}


@Composable
fun ShowDesignInspirationApi(listItems1: MutableList<String>, listItems2: MutableList<String>) {
    listItems1.forEach() { item ->
        Column(
            modifier = Modifier.fillMaxWidth().padding(bottom = 16.dp)
        ) {
            Text(text = " ● " + item, fontSize = 18.sp)
            Text(
                text = listItems2[listItems1.indexOf(item)], fontSize = 18.sp,
                modifier = Modifier.padding(end = 4.dp)
            )
        }
    }
}

@Composable
fun ShowRiskAndSolution(listItems1: MutableList<String>, listItems2: MutableList<String>) {
    listItems1.forEach() { item ->
        Column(
            horizontalAlignment = Alignment.Start,
            modifier = Modifier.fillMaxWidth().padding(bottom = 16.dp)
        ) {
            Row {
                Text(
                    text = "Que: ",
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    modifier = Modifier.padding(end = 4.dp)
                )
                Text(
                    text = item + "?.",
                    fontSize = 18.sp
                )
            }
            Row {
                Text(
                    text = "Ans: ",
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    modifier = Modifier.padding(end = 4.dp) // Optional, for spacing between "Ans:" and the answer
                )
                Text(
                    text = listItems2[listItems1.indexOf(item)],
                    fontSize = 18.sp,
                    modifier = Modifier.padding(bottom = 4.dp)
                )
            }
        }
    }
}

@Composable
fun ShowProjectSchedule(listItems1: MutableList<String>, listItems2: MutableList<String>) {
    Column(modifier = Modifier.padding(bottom = 16.dp)) {
        listItems1.forEach() { item ->
            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = listItems2[listItems1.indexOf(item)], fontSize = 18.sp)
                Text(text = "  :  " + item, fontSize = 18.sp)

            }
        }
    }
}

@Composable
fun ShowFeatureList(listItems: MutableList<String>) {
    Column(modifier = Modifier.padding(bottom = 16.dp)) {
        listItems.forEach() { item ->
            Row {
                Text(
                    text = " ● ",
                    fontSize = 18.sp,
                    modifier = Modifier.padding(end = 4.dp) // Optional, for spacing between bullet and text
                )
                Text(
                    text = item,
                    fontSize = 18.sp
                )
            }
        }
    }
}

@Composable
fun DrawLine() {
    Canvas(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {
        drawLine(
            color = Color.Red,
            start = Offset(0f, 0f),
            end = Offset(size.width, 0f),
            cap = StrokeCap.Round,
            strokeWidth = 25f
        )
    }
}

@Composable
fun LoadingAnimation() {
    val composition by rememberLottieComposition(LottieCompositionSpec.Url("https://lottie.host/64a308d0-6922-4320-91f6-6a647e107397/bzegjYTjRW.json"))
    val progress by animateLottieCompositionAsState(
        composition,
        iterations = LottieConstants.IterateForever
    )

    LottieAnimation(
        composition = composition,
        progress = { progress },
        modifier = Modifier
            .size(225.dp)
            .padding(start = 70.dp, bottom = 20.dp)
    )
}





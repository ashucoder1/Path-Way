package com.example.pathway

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.pathway.ui.theme.Terracotta


@Composable
fun NavRail(navController: NavController) {
    var selectedItem by remember { mutableIntStateOf(0) }
    val items = listOf("Home","Search","Path","Help","About")
    val icons = listOf(Icons.Filled.Home, Icons.Filled.Search,Icons.Filled.Create, Icons.Filled.Build, Icons.Filled.Info)

    NavigationRail(containerColor = Terracotta,
        modifier = Modifier.fillMaxHeight())
    {
        Column(
            modifier = Modifier.fillMaxHeight(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        )
        {
            items.forEachIndexed { index, item ->
                NavigationRailItem(
                    modifier = Modifier.padding(top = 4.dp, bottom = 4.dp),
                    alwaysShowLabel = false,
                    selected = selectedItem == index,
                    onClick = {
                        selectedItem = index
                        when(index){
                            0 -> navController.navigate(Screen.Home.route)
                            1 -> navController.navigate(Screen.Search.route)
                            2 -> navController.navigate(Screen.Path.route)
                            3 -> navController.navigate(Screen.Help.route)
                            4 -> navController.navigate(Screen.About.route)
                        }
                    },
                    icon = { Icon(icons[index], contentDescription = item, tint = Color.White) },
                    label = { Text(item, color = Color.White) }
                )
            }
        }

    }
}

@Composable
@Preview(showBackground = true)
fun NavRailPreview() {
    NavRail(navController = rememberNavController())
}




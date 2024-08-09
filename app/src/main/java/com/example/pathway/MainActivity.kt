package com.example.pathway

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.zIndex
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.pathway.ui.theme.PathWayTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //database
//        val db=Room.databaseBuilder(
//            applicationContext,
//            AppDatabase::class.java,"firstDB"
//        ).build()
        //val userDao=db.userDao()
        //val users: List<User> =userDao.getAll()

        setContent() {
            PathWayTheme {
                val navController = rememberNavController()
                PathWayTheme {
                    val navController = rememberNavController()
                    Row(
                        modifier = Modifier
                            .fillMaxSize()
                    ) {
                        Box(modifier = Modifier.fillMaxHeight()) {
                            NavRail(navController)
                        }
                        Box(
                            modifier = Modifier
                                .fillMaxHeight()
                        ) {
                            Image(painter = painterResource(id = R.drawable.app_bg), contentDescription = null,
                                modifier = Modifier.fillMaxSize(), contentScale = ContentScale.Crop
                            )
                            MainScreen(navController)
                        }
                    }
                }
            }
                }
            }
        }

@Composable
fun MainScreen(navController: NavController) {
    RootNavHost(navController)
}


@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    PathWayTheme {
        MainScreen(rememberNavController())
    }
}

package com.example.pathway

import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.pathway.ui.screens.AboutScreen
import com.example.pathway.ui.screens.HelpScreen
import com.example.pathway.ui.screens.HomeScreen
import com.example.pathway.ui.screens.PathScreen
import com.example.pathway.ui.screens.SearchScreen

private object Route{
    const val SEARCH="search"
    const val HOME="home"
    const val PATH="path"
    const val ABOUT="about"
    const val HELP="help"
}
sealed class Screen(val route:String){
    object Search: Screen(Route.SEARCH)
    object Home: Screen(Route.HOME)
    object Path: Screen(Route.PATH)
    object About: Screen(Route.ABOUT)
    object Help: Screen(Route.HELP)
}
////Root Nav host here////
@Composable
fun RootNavHost(navController: NavController){
    NavHost(navController as NavHostController, startDestination = Screen.Home.route,)
    {
        composable(Screen.Home.route){
            HomeScreen()
        }
        composable(
            Screen.Search.route,
            enterTransition = { slideInVertically(initialOffsetY = {it})+ fadeIn(tween()) },
            exitTransition = { slideOutVertically(targetOffsetY = {it})+ fadeOut(tween()) }
        ){
            SearchScreen()
        }
        composable(Screen.Path.route,
            enterTransition = { slideInVertically(initialOffsetY = {it})+ fadeIn(tween()) }
            ){
            PathScreen()
        }
        composable(Screen.About.route,
            enterTransition = { slideInVertically(initialOffsetY = {it})+ fadeIn(tween()) }
            ){
            AboutScreen()
        }
        composable(Screen.Help.route,
            exitTransition = { slideOutVertically(targetOffsetY = {it})+ fadeOut(tween()) }
        ){
            HelpScreen()
        }
    }
}

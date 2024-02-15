package com.example.pnavigationdrawer.navigation

import androidx.compose.material3.DrawerState
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.pnavigationdrawer.view.AboutScreen
import com.example.pnavigationdrawer.view.DetailScreen
import com.example.pnavigationdrawer.view.HomeScreen
import com.example.pnavigationdrawer.view.ProfileScreen


@Composable
fun AppNavigation(drawerState: DrawerState, navController: NavHostController) {


    NavHost(navController, startDestination = Screens.Home.name) {

        composable(Screens.Home.name) {
            HomeScreen(drawerState, navController)
        }
        composable(Screens.About.name) {
            AboutScreen(drawerState, navController)
        }
        composable(Screens.Detail.name + "/{username}/{age}", arguments = listOf(
            navArgument("username") { type = NavType.StringType },
            navArgument("age") { type = NavType.StringType }
        )) {
            DetailScreen(
                drawerState,
                navController,
                it.arguments?.getString("username"),
                it.arguments?.getString("age")
            )
        }
        composable(Screens.Profile.name) {
            ProfileScreen(drawerState, navController)
        }


    }
}
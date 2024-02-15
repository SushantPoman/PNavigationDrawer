package com.example.pnavigationdrawer.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerState
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.pnavigationdrawer.navigation.CustomAppBar


@Composable
fun AboutScreen(drawerState: DrawerState, navController: NavHostController) {

    Scaffold(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp),
        content = {paddingValues ->
            Column(modifier = Modifier.padding(paddingValues), horizontalAlignment = Alignment.CenterHorizontally) {

                Text(text = "About screen",
                    fontSize = 20.sp)


            }
        },
        topBar = {
            CustomAppBar(isHomeIcon = true, navController = navController, drawerState = drawerState, title = "About")
        })
}
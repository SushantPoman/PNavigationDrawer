package com.example.pnavigationdrawer.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerState
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.pnavigationdrawer.navigation.CustomAppBar


@Composable
fun DetailScreen(drawerState: DrawerState, navController: NavHostController, username: String?, age: String?) {


    Scaffold(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp),
        content = {paddingValues ->
            Column(modifier = Modifier.padding(paddingValues).padding(16.dp)) {

                Text(text = "Detail data:",
                    fontSize = 20.sp)

                Text(text = "$username")
                Text(text = "$age")

            }
        },
        topBar = {
            CustomAppBar(isHomeIcon = false, navController = navController, drawerState = drawerState, title = "Detail")
        })

}
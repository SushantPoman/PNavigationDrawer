package com.example.pnavigationdrawer.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.DrawerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.NavController
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomAppBar(
    isHomeIcon: Boolean, navController: NavController, drawerState: DrawerState,
    title: String
) {

    val coroutineScope = rememberCoroutineScope()

    CenterAlignedTopAppBar(
        navigationIcon = {

                IconButton(onClick = {
                    if(isHomeIcon){
                        coroutineScope.launch {
                            drawerState.open()
                        }
                    } else
                        navController.popBackStack()
                }){
                    Icon(imageVector =
                        if(isHomeIcon) Icons.Filled.Menu else Icons.Filled.ArrowBack,
                        contentDescription = "")
                }

        },
        title = { Text(text = title) })


}
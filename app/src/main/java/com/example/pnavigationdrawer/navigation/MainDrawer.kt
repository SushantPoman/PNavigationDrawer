package com.example.pnavigationdrawer.navigation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.Divider
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.launch

@Composable
fun MainDrawer(navController: NavHostController = rememberNavController()) {

    var drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val coroutineScope = rememberCoroutineScope()
    val menuList = listOf<String>(Screens.About.name, Screens.Home.name, Screens.Profile.name)

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet {

                /**
                 * Simple menu
                 * */
                /*Text(text = "Drawer Title", modifier = Modifier.padding(16.dp))
                Divider()
                NavigationDrawerItem(label = { Text(text = "Drawer Item") }, selected = false, onClick = {})*/

                /**
                 * Custom menu
                 * */
                DrawerContent(menuList) { menu ->

                    coroutineScope.launch {
                        drawerState.close()
                    }

                    navController.navigate(menu) {
                        popUpTo(menu)
                    }

                }

            }
        }) {
        AppNavigation(drawerState, navController)
    }


}

@Composable
fun DrawerContent(
    menuList: List<String>,
    onMenuClick: (String) -> Unit
) {

    Column(
        modifier = Modifier
            .fillMaxWidth(0.8f)
            .fillMaxHeight()
    ) {

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp),
            contentAlignment = Alignment.Center
        ) {

            Image(
                modifier = Modifier.size(150.dp),
                imageVector = Icons.Filled.AccountCircle,
                contentScale = ContentScale.Crop,
                contentDescription = ""
            )
        }

        Spacer(modifier = Modifier.height(12.dp))

        menuList.forEach { menu ->

            Divider()
            NavigationDrawerItem(
                label = { Text(text = menu) },
                icon = {
                       Icon(imageVector = Icons.Filled.AccountCircle, contentDescription = "")
                },

                selected = false,
                onClick = { onMenuClick(menu) })
        }
    }

}

package com.example.pnavigationdrawer.view

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Create
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.DrawerState
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.pnavigationdrawer.event.HomeEvent
import com.example.pnavigationdrawer.model.UserDetails
import com.example.pnavigationdrawer.navigation.CustomAppBar
import com.example.pnavigationdrawer.navigation.Screens
import com.example.pnavigationdrawer.viewmodel.HomeViewModel


@Composable
fun HomeScreen(drawerState: DrawerState, navController: NavHostController) {

    val homeViewModel: HomeViewModel = viewModel()
    val context = LocalContext.current

    val userList = remember {
        mutableStateListOf<UserDetails>()
    }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
            ) {

                Column(modifier = Modifier.padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally) {

                    TextField(
                        value = homeViewModel.username.value,
                        onValueChange = { homeViewModel.onEvent(HomeEvent.OnUsernameChange(it)) },
                        textStyle = TextStyle.Default,
                        placeholder = {
                            Text(text = "Please enter username")
                        }
                    )
                    TextField(
                        value = homeViewModel.age.value,
                        onValueChange = { homeViewModel.onEvent(HomeEvent.OnAgeChange(it)) },
                        textStyle = TextStyle.Default,
                        placeholder = {
                            Text(text = "Please enter age")
                        },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal)
                    )

                    Button(onClick = {
                        Toast.makeText(context, "Submitted Details", Toast.LENGTH_SHORT).show()
                        /*userList.add(
                            UserDetails(homeViewModel.username.value, homeViewModel.age.value)
                        )*/

                        /**
                         * To check how arguments passed to next screen, uncomment following code
                         * */
                        navController.navigate(Screens.Detail.name+"/"+homeViewModel.username.value+"/"+homeViewModel.age.value)

                    }) {
                        Text(text = "Submit")
                    }

                    /*LazyColumn(
                        content = {
                            items(userList) { user: UserDetails ->
                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.SpaceBetween
                                ) {
                                    Text(text = user.username)
                                    Text(text = user.age)
                                }
                            }
                        },
                        modifier = Modifier.padding(top = 20.dp).background(Color.LightGray)
                    )*/
                }
            }

        },
        topBar = {
            CustomAppBar(true, navController, drawerState, Screens.Home.name)
        },
        bottomBar = {
            BottomAppBar(modifier = Modifier.background(Color.Blue)) {
                Row(
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {

                    Text(text = "Wishlist")
                    Spacer(modifier = Modifier.width(10.dp))
                    Text(text = "Cart")
                    Spacer(modifier = Modifier.width(10.dp))
                    Text(text = "Profile")

                }
            }
        },
        floatingActionButton = {
            FloatingActionButton(onClick = {
                Toast.makeText(context, "Floating button clicked", Toast.LENGTH_SHORT).show()
            }){
                Icon(imageVector = Icons.Filled.Create, contentDescription = "")
            }
        }
    )

}
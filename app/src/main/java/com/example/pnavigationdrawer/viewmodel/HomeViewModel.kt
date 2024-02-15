package com.example.pnavigationdrawer.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.pnavigationdrawer.event.HomeEvent

class HomeViewModel : ViewModel() {

    private val _username = mutableStateOf("")
    val username: State<String> = _username


    private val _age = mutableStateOf("")
    val age: State<String> = _age


    fun onEvent(event: HomeEvent){
        when(event){
            is HomeEvent.OnUsernameChange -> {
                _username.value = event.userName
            }
            is HomeEvent.OnAgeChange -> {
                _age.value = event.age
            }

        }

    }



}
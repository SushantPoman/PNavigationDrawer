package com.example.pnavigationdrawer.event

sealed class HomeEvent {

    data class OnUsernameChange(val userName: String): HomeEvent()
    data class OnAgeChange(val age: String): HomeEvent()
}
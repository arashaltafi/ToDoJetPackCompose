package com.arash.altafi.todojetpackcompose.navigation

import androidx.navigation.NavHostController
import com.arash.altafi.todojetpackcompose.utils.Action
import com.arash.altafi.todojetpackcompose.utils.Constants.LIST_SCREEN

class Screens(navController: NavHostController) {
    val list: (Action) -> Unit = { action ->
        navController.navigate("list/${action.name}") {
            popUpTo(LIST_SCREEN) { inclusive = true }
        }
    }

    val task: (Int) -> Unit = { taskId ->
        navController.navigate("task/$taskId")
    }
}
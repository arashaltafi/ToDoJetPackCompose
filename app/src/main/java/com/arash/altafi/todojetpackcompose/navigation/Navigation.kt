package com.arash.altafi.todojetpackcompose.navigation

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.arash.altafi.todojetpackcompose.navigation.destinations.listComposable
import com.arash.altafi.todojetpackcompose.navigation.destinations.taskComposable
import com.arash.altafi.todojetpackcompose.utils.Constants.LIST_SCREEN
import com.arash.altafi.todojetpackcompose.viewmodel.ToDoNotesViewModel

@ExperimentalMaterialApi
@Composable
fun ToDoNotesNavigation(
    navHostController: NavHostController,
    toDoNotesViewModel: ToDoNotesViewModel
) {
    val screen = remember(navHostController) { Screens(navHostController) }

    NavHost(
        navController = navHostController,
        startDestination = LIST_SCREEN
    ) {
        listComposable(
            navigateToTaskScreen = screen.task,
            toDoNotesViewModel = toDoNotesViewModel
        )
        taskComposable(
            toDoNotesViewModel = toDoNotesViewModel,
            navigateToListScreen = screen.list
        )
    }
}



















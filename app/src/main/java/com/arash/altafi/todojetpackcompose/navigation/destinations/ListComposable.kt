package com.arash.altafi.todojetpackcompose.navigation.destinations

import android.annotation.SuppressLint
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateListOf
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.arash.altafi.todojetpackcompose.utils.Constants.LIST_ARGUMENT_KEY
import com.arash.altafi.todojetpackcompose.utils.Constants.LIST_SCREEN
import com.arash.altafi.todojetpackcompose.utils.toAction
import com.arash.altafi.todojetpackcompose.view.ListScreen
import com.arash.altafi.todojetpackcompose.viewmodel.ToDoNotesViewModel

@SuppressLint("UnrememberedMutableState")
@ExperimentalMaterialApi
fun NavGraphBuilder.listComposable(
    navigateToTaskScreen: (taskId: Int) -> Unit,
    toDoNotesViewModel: ToDoNotesViewModel
) {
    composable(
        route = LIST_SCREEN,
        arguments = mutableStateListOf(
            navArgument(LIST_ARGUMENT_KEY) {
                type = NavType.StringType
            }
        )
    ) { navBackStackEntry ->
        val action = navBackStackEntry.arguments?.getString(LIST_ARGUMENT_KEY).toAction()
        LaunchedEffect(key1 = action) {
            toDoNotesViewModel.action.value = action
        }

        ListScreen(
            navigateToTaskScreen = navigateToTaskScreen,
            toDoNotesViewModel = toDoNotesViewModel
        )
    }
}
















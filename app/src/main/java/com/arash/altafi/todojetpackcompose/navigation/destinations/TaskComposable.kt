package com.arash.altafi.todojetpackcompose.navigation.destinations

import android.annotation.SuppressLint
import androidx.compose.runtime.*
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.arash.altafi.todojetpackcompose.utils.Action
import com.arash.altafi.todojetpackcompose.utils.Constants.TASK_ARGUMENT_KEY
import com.arash.altafi.todojetpackcompose.utils.Constants.TASK_SCREEN
import com.arash.altafi.todojetpackcompose.view.task.TaskScreen
import com.arash.altafi.todojetpackcompose.viewmodel.ToDoNotesViewModel

@SuppressLint("UnrememberedMutableState")
fun NavGraphBuilder.taskComposable(
    toDoNotesViewModel: ToDoNotesViewModel,
    navigateToListScreen: (Action) -> Unit
) {
    composable(
        route = TASK_SCREEN,
        arguments = mutableStateListOf(
            navArgument(TASK_ARGUMENT_KEY) {
                type = NavType.IntType
            }
        )
    ) { navBackStackEntry ->
        val taskId = navBackStackEntry.arguments!!.getInt(TASK_ARGUMENT_KEY)
        LaunchedEffect(key1 = taskId) {
            toDoNotesViewModel.getSelectedTask(taskId)
        }
        val selectedTask by toDoNotesViewModel.selectedTask.collectAsState()

        LaunchedEffect(key1 = selectedTask) {
            if (selectedTask != null || taskId == -1) {
                toDoNotesViewModel.updateTaskField(selectedTask)
            }
        }

        TaskScreen(
            selectedTask = selectedTask,
            toDoNotesViewModel = toDoNotesViewModel,
            navigateToListScreen = navigateToListScreen
        )
    }
}


















package com.arash.altafi.todojetpackcompose.view.task

import android.widget.Toast
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import com.arash.altafi.todojetpackcompose.database.model.Priority
import com.arash.altafi.todojetpackcompose.database.model.ToDoTask
import com.arash.altafi.todojetpackcompose.utils.Action
import com.arash.altafi.todojetpackcompose.viewmodel.ToDoNotesViewModel

@Composable
fun TaskScreen(
    selectedTask: ToDoTask?,
    toDoNotesViewModel: ToDoNotesViewModel,
    navigateToListScreen: (Action) -> Unit
) {
    val title: String by toDoNotesViewModel.title
    val description: String by toDoNotesViewModel.description
    val priority: Priority by toDoNotesViewModel.priority
    val context = LocalContext.current

    Scaffold(
        topBar = {
            TaskAppBar(
                selectedTask = selectedTask,
                navigateToListScreen = { action ->
                    if (action == Action.NO_ACTION) {
                        navigateToListScreen(action)
                    } else {
                        if (toDoNotesViewModel.validateFields()) {
                            navigateToListScreen(action)
                        } else {
                            Toast.makeText(context, "Fields Empty", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            )
        },
        content = {
            TaskContent(
                title = title,
                onTitleChange = {
                    toDoNotesViewModel.updateTitle(it)
                },
                description = description,
                onDescriptionChange = {
                    toDoNotesViewModel.description.value = it
                },
                priority = priority,
                onPrioritySelected = {
                    toDoNotesViewModel.priority.value = it
                }
            )
        }
    )
}

















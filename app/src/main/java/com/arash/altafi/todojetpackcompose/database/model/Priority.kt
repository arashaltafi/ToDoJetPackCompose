package com.arash.altafi.todojetpackcompose.database.model

import androidx.compose.ui.graphics.Color
import com.arash.altafi.todojetpackcompose.ui.theme.HighPriorityColor
import com.arash.altafi.todojetpackcompose.ui.theme.LowPriorityColor
import com.arash.altafi.todojetpackcompose.ui.theme.MediumPriorityColor
import com.arash.altafi.todojetpackcompose.ui.theme.NonePriorityColor

enum class Priority(val color: Color) {
    HIGH(HighPriorityColor),
    MEDIUM(MediumPriorityColor),
    LOW(LowPriorityColor),
    NONE(NonePriorityColor)
}
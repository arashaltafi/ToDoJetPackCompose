package com.arash.altafi.todojetpackcompose.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.arash.altafi.todojetpackcompose.database.model.ToDoTask

@Database(entities = [ToDoTask::class], version = 1 , exportSchema = false)
abstract class ToDoDatabase: RoomDatabase() {

    abstract fun toDoDao() : ToDoDao
}
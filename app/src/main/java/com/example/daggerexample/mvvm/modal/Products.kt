package com.example.daggerexample.mvvm.modal

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class Products(

    val completed: Boolean,
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val title: String,
    val userId: Int
)
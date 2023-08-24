package com.example.daggerexample.mvvm.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.daggerexample.mvvm.modal.Products

@Database(entities = [Products::class], version = 1)
abstract class ProductDB : RoomDatabase() {

    abstract fun getDao(): ProductDao
}
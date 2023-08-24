package com.example.daggerexample.mvvm.di

import android.content.Context
import androidx.room.Room
import com.example.daggerexample.mvvm.local.ProductDB
import com.example.daggerexample.mvvm.local.ProductDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {


    @Singleton
    @Provides
    fun provideMovieDB(context: Context): ProductDB {
        return Room.databaseBuilder(context, ProductDB::class.java, "ProductDB").build()
    }

    @Singleton
    @Provides
    fun providesProductDao(productDB: ProductDB): ProductDao {
        return productDB.getDao()
    }
}
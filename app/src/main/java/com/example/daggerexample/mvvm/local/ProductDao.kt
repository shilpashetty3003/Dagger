package com.example.daggerexample.mvvm.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.daggerexample.mvvm.modal.Products

@Dao
interface ProductDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertProducts(product: List<Products>)

    @Query("select * from Products")
    suspend fun getProductsList(): List<Products>
}
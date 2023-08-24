package com.example.daggerexample.mvvm.data

import com.example.daggerexample.mvvm.modal.Products
import retrofit2.Response
import retrofit2.http.GET

interface ProductService {


    @GET("/todos")
    suspend fun getProducts():Response<List<Products>>
}
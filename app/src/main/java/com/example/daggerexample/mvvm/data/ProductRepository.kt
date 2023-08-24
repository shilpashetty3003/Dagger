package com.example.daggerexample.mvvm.data

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.daggerexample.mvvm.local.ProductDao
import com.example.daggerexample.mvvm.modal.Products
import javax.inject.Inject

class ProductRepository @Inject constructor(
    private val productService: ProductService,
    private val productDao: ProductDao
) {

    var products: MutableLiveData<List<Products>> = MutableLiveData<List<Products>>()

    suspend fun getProducts() {
        val result = productService.getProducts()
        if (result.isSuccessful) {
            result.body()?.let { productDao.insertProducts(it) }
            products.value = result.body()

            Log.d("TAG", "getProducts:  ${productDao.getProductsList()}")
        }
    }
}
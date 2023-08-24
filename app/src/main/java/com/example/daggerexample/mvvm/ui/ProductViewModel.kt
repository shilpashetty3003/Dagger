package com.example.daggerexample.mvvm.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.daggerexample.mvvm.data.ProductRepository
import com.example.daggerexample.mvvm.modal.Products
import kotlinx.coroutines.launch
import javax.inject.Inject

class ProductViewModel(val repository: ProductRepository) : ViewModel() {

    val productsItems: LiveData<List<Products>>
        get() = repository.products

    init {
        viewModelScope.launch {
            repository.getProducts()
        }
    }
}
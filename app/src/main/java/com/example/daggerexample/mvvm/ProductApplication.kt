package com.example.daggerexample.mvvm

import android.app.Application
import com.example.daggerexample.mvvm.di.DaggerProductComponent
import com.example.daggerexample.mvvm.di.ProductComponent

class ProductApplication : Application() {

    lateinit var productComponent: ProductComponent
    override fun onCreate() {
        super.onCreate()
        productComponent =DaggerProductComponent.factory().create(this)
    }
}
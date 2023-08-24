package com.example.daggerexample.mvvm.di

import android.content.Context
import com.example.daggerexample.mvvm.ui.ProductApp
import dagger.BindsInstance
import dagger.Component
import dagger.Component.Factory
import dagger.Module
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class, DatabaseModule::class])
interface ProductComponent {

    fun inject(productApp: ProductApp)

    @Component.Factory
    interface Factory {

        fun create(@BindsInstance context: Context): ProductComponent

    }
}
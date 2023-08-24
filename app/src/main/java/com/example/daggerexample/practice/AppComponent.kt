package com.example.daggerexample.practice

import dagger.Component

@Component(modules = [AnalyticalModule::class])
interface AppComponent {
//    fun getAnalyticalService(): AnalyticalService

    fun getUserRegistrationComponent():UserRegistrationComponent.Builder
}
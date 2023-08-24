package com.example.daggerexample.practice

import android.util.Log
import javax.inject.Inject
import javax.inject.Singleton


interface UserRepository {
    fun login()
}


class SQLService @Inject constructor(val analyticalService: AnalyticalService) : UserRepository {
    override fun login() {
        Log.d("TAG", "login: UserSQL Service  ")
        analyticalService.trackEvent("Dance", "Entertainment")
    }
}

class FirebaseService() : UserRepository {
    override fun login() {
        Log.d("TAG", "login: Firebase Service Login ")
    }
}
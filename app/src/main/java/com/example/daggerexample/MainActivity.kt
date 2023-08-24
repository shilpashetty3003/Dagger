package com.example.daggerexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.daggerexample.practice.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() {


    @Inject
    lateinit var userService: SQLService

    @Inject
    lateinit var userService1: SQLService

    @Inject
    lateinit var userRegistrationService: UserRegistrationService
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val appComponent = (application as MyApplication).appComponent
        val userComponent = appComponent.getUserRegistrationComponent().retryCount(66).build()
        userComponent.inject(this)
        userRegistrationService.registerUser()

    }
}
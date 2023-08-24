package com.example.daggerexample.practice

import android.util.Log
import javax.inject.Inject
import javax.inject.Singleton


interface NotificationService {
    fun send(message: String)
}

class EmailService @Inject constructor(val retryCount:Int) : NotificationService {

    override fun send(message: String) {
        Log.d("TAG", "send:EMail Service $message  $retryCount ------------ ")
    }
}

class MessageService @Inject constructor() : NotificationService {
    override fun send(message: String) {
        Log.d("TAG", "send: Message Service $message ")
    }
}
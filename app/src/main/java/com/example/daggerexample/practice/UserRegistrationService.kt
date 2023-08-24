package com.example.daggerexample.practice

import javax.inject.Inject
import javax.inject.Named
import javax.inject.Singleton


class UserRegistrationService @Inject constructor(
    @Named("email") val notificationService: NotificationService,
    val userRepository: UserRepository
) {

    fun registerUser() {
        notificationService.send("HIIII")
        userRepository.login()

    }
}
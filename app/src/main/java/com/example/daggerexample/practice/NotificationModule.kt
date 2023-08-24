package com.example.daggerexample.practice

import android.util.Log
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
class NotificationModule( ) {

    @Named("email")
    @Provides
    fun getEmailService(retryCount:Int):NotificationService{
       return  EmailService(retryCount)
    }

    @MessageQualifier
    @Provides
    fun getMessageService(messageService: MessageService):NotificationService{
        return messageService
    }
}

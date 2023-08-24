package com.example.daggerexample.practice

import com.example.daggerexample.MainActivity
import dagger.BindsInstance
import dagger.Component
import dagger.Subcomponent
import dagger.Subcomponent.Builder
import javax.inject.Singleton



@Subcomponent( modules = [UserRepositoryModule::class, NotificationModule::class,AnalyticalModule::class])
interface UserRegistrationComponent {

    fun inject(mainActivity: MainActivity)

    @Subcomponent.Builder
    interface Builder{

        fun build():UserRegistrationComponent
        fun retryCount(@BindsInstance  retrycount:Int):Builder
    }
}
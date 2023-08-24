package com.example.daggerexample.practice

import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Singleton


@Module
abstract class UserRepositoryModule {


    @Binds
    abstract fun getSQLService(sqlService: SQLService): UserRepository


}
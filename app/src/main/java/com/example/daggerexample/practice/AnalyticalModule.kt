package com.example.daggerexample.practice

import dagger.Module
import dagger.Provides

@Module
class AnalyticalModule {

    @Provides
    fun getMixPanel():AnalyticalService{
        return MixPanel()
    }
}
package com.example.daggerexample.practice

import android.util.Log
import javax.inject.Inject

interface AnalyticalService {
    fun trackEvent(trackName:String, trackType:String)
}

class MixPanel @Inject constructor():AnalyticalService{
    override fun trackEvent(trackName: String, trackType: String) {
        Log.d("TAG", "MixPanel: $trackName ++++ $trackType ")
    }
}

class FirebaseAnalytics():AnalyticalService{
    override fun trackEvent(trackName: String, trackType: String) {
        Log.d("TAG", "FirebaseAnalytics:$trackName ++++ $trackType  ")
    }
}
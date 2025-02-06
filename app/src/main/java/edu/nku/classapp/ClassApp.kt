package edu.nku.classapp

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@HiltAndroidApp
class ClassApp : Application() {
    override fun onCreate() {
        super.onCreate()
        // Any application-wide initialization can go here
    }
} 
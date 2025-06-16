package com.example.photo_lover_app

import android.app.Application
import com.example.photo_lover_app.data.db.container.AppContainer
import com.example.photo_lover_app.data.db.container.AppDataContainer

class PhotoLoverApplication : Application() {

    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()
        container = AppDataContainer(this)
    }

}
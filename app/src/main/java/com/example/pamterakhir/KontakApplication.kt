package com.example.pamterakhir

import android.app.Application
import com.example.pamterakhir.data.AppContainer
import com.example.pamterakhir.data.KontakContainer

class KontakApplication: Application() {
    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()

        container = KontakContainer()
    }
}
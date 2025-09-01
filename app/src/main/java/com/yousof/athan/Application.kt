package com.yousof.athan

import android.app.Application

var context: AthanApplication? = null

// erste klasse in der app die gestartet wird
class AthanApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        context = this
    }
}

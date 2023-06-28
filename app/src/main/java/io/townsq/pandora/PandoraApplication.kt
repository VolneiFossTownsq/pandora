package io.townsq.pandora

import android.app.Application
import io.townsq.pandora.ui.di.recordListModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin

class PandoraApplication() : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@PandoraApplication)
            modules(
                listOf(
                    recordListModule
                )
            )
        }
    }
}
package io.townsq.pandora

import android.app.Application
import io.townsq.pandora.networkModule.networkModule
import io.townsq.pandora.ui.createRecord.di.createRecordModule
import io.townsq.pandora.ui.feed.di.recordListModule
import io.townsq.pandora.ui.login.di.loginModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin

class PandoraApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@PandoraApplication)
            modules(
                listOf(
                    recordListModule,
                    loginModule,
                    createRecordModule,
                    networkModule,
                )
            )
        }
    }
}

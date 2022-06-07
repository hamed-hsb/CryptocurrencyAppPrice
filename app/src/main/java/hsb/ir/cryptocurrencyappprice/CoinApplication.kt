package hsb.ir.cryptocurrencyappprice

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class CoinApplication : Application() {
    override fun onCreate() {
        super.onCreate()
    }
}
package hsb.ir.cryptocurrencyappprice.di

import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import hsb.ir.cryptocurrencyappprice.common.Constants
import hsb.ir.cryptocurrencyappprice.data.remote.CoinPaprikaApi
import hsb.ir.cryptocurrencyappprice.data.repository.CoinRepositoryImpl
import hsb.ir.cryptocurrencyappprice.domain.repository.CoinRepository
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {


    @Provides
    @Singleton

    fun providePaprikaApi(): CoinPaprikaApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CoinPaprikaApi::class.java)
    }


    @Provides
    @Singleton
    fun provideCoinRepository(api: CoinPaprikaApi): CoinRepository{
        return CoinRepositoryImpl(api)
    }
}
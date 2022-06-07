package hsb.ir.cryptocurrencyappprice.data.remote

import hsb.ir.cryptocurrencyappprice.data.remote.dto.CoinDetailDto
import hsb.ir.cryptocurrencyappprice.data.remote.dto.CoinDto
import retrofit2.http.GET
import retrofit2.http.Path

interface CoinPaprikaApi {
    //https://api.coinpaprika.com/v1/coins
    @GET("/v1/coins")
    suspend fun getCoins(): List<CoinDto>

    @GET("/v1/coins/{coinId}")
    suspend fun getCoinById(@Path("coinId") string: String): CoinDetailDto
}
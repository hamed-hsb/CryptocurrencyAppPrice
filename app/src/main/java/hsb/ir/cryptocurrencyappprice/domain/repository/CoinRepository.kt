package hsb.ir.cryptocurrencyappprice.domain.repository

import hsb.ir.cryptocurrencyappprice.data.remote.dto.CoinDetailDto
import hsb.ir.cryptocurrencyappprice.data.remote.dto.CoinDto

interface CoinRepository {
    suspend fun getCoins(): List<CoinDto>
    suspend fun getCoinById(coinId: String): CoinDetailDto
}
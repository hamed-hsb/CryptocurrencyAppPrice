package hsb.ir.cryptocurrencyappprice.data.repository

import hsb.ir.cryptocurrencyappprice.data.remote.CoinPaprikaApi
import hsb.ir.cryptocurrencyappprice.data.remote.dto.CoinDetailDto
import hsb.ir.cryptocurrencyappprice.data.remote.dto.CoinDto
import hsb.ir.cryptocurrencyappprice.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api: CoinPaprikaApi
): CoinRepository {

    override suspend fun getCoins(): List<CoinDto> {
        return api.getCoins()
    }


    override suspend fun getCoinById(coinId: String): CoinDetailDto {
        return api.getCoinById(coinId)
    }
}
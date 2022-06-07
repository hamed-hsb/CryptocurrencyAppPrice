package hsb.ir.cryptocurrencyappprice.domain.use_case.get_coin

import hsb.ir.cryptocurrencyappprice.common.Resource
import hsb.ir.cryptocurrencyappprice.data.remote.dto.toCoinDetail
import hsb.ir.cryptocurrencyappprice.domain.model.Coin
import hsb.ir.cryptocurrencyappprice.domain.model.CoinDetail
import hsb.ir.cryptocurrencyappprice.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(

    private val repository: CoinRepository
) {

    operator fun invoke(coinId: String): Flow<Resource<CoinDetail>> = flow{

        try {
            emit(Resource.Loading())

            val coin = repository.getCoinById(coinId).toCoinDetail()

            emit(Resource.Success(coin))

        }catch (e: HttpException){
            emit(Resource.Error(e.localizedMessage?: " An unexpected error occurred"))
        }catch (e: IOException){
            emit(Resource.Error("Couldn't reach server. Check your internet connecting"))
        }

    }
}
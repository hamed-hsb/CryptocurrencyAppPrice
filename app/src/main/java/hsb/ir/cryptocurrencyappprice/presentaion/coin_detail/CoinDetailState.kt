package hsb.ir.cryptocurrencyappprice.presentaion.coin_detail

import hsb.ir.cryptocurrencyappprice.domain.model.Coin
import hsb.ir.cryptocurrencyappprice.domain.model.CoinDetail

class CoinDetailState (

    val isLoading: Boolean = false,
    val coin: CoinDetail? = null,
    val error: String = ""
)
package hsb.ir.cryptocurrencyappprice.presentaion.coin_list

import hsb.ir.cryptocurrencyappprice.domain.model.Coin

data class CoinListState (

    val isLoading: Boolean = false,
    val coins: List<Coin> = emptyList(),
    val error: String = ""
        )
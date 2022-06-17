package hsb.ir.cryptocurrencyappprice.presentaion.coin_detail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import hsb.ir.cryptocurrencyappprice.common.Constants
import hsb.ir.cryptocurrencyappprice.common.Resource
import hsb.ir.cryptocurrencyappprice.domain.use_case.get_coin.GetCoinUseCase
import hsb.ir.cryptocurrencyappprice.presentaion.coin_list.CoinListState
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CoinDetailViewModel @Inject constructor(
    private val getCoinUseCase: GetCoinUseCase,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {


    private val _state = mutableStateOf(CoinDetailState())
    val state: State<CoinDetailState> = _state

    init {
        savedStateHandle.get<String>(Constants.PARAM_COIN_ID)?.let {
            coinId ->

            getCoins(coinId )
        }

    }


    private fun getCoins(coinId: String) {
        getCoinUseCase.invoke(coinId = coinId).onEach {
                result ->

            when (result) {
                is Resource.Success -> {
                    _state.value = CoinDetailState(coin = result.data ?: result.data)
                }

                is Resource.Error -> {
                    _state.value =
                        CoinDetailState(error = result.message ?: "An unexpected error occurred")
                }

                is Resource.Loading -> {
                    _state.value = CoinDetailState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)


    }

}
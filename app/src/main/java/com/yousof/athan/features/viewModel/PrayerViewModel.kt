package com.yousof.athan.features.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yousof.athan.api.Aladan
import com.yousof.athan.api.RetrofitObject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class PrayerViewModel : ViewModel() {
    private val aladhanApi = RetrofitObject.aladanApi
    val uiState: MutableStateFlow<Aladan?> =

        MutableStateFlow(null)

    init {
        viewModelScope.launch {
            val result = aladhanApi.getPrayerTimes("Amman", "jordan")

            uiState.value = result
        }
    }
}

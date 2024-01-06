package com.example.pamterakhir.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pamterakhir.data.KontakRepository
import com.example.pamterakhir.model.Kontak
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow

sealed class KontakUIState {
    data class Success(val kontak: Flow<List<Kontak>>) : KontakUIState()
    object Error : KontakUIState()
    object Loading : KontakUIState()
}

class HomeViewModel(private val kontakRepository: KontakRepository) : ViewModel() {

    companion object {
        private const val TIMEOUT_MILLIS = 5_000L
    }

    val homeUIState: StateFlow<HomeUIState> = kontakRepository.getAll()
        .filterNotNull()
        .map {
            HomeUIState (listKontak = it.toList(), it.size ) }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(TIMEOUT_MILLIS),
            initialValue = HomeUIState()

        )

}
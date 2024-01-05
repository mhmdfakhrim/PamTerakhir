package com.example.pamterakhir.ui.add

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.pamterakhir.data.KontakRepository
import com.example.pamterakhir.ui.DetailKontak
import com.example.pamterakhir.ui.UIStateKontak
import com.example.pamterakhir.ui.toKontak

class AddViewModel(private val repositoryKontak: KontakRepository): ViewModel() {

    var uiStateKontak by mutableStateOf(UIStateKontak())
        private set



    fun updateUiState(detailKontak: DetailKontak) {
        uiStateKontak =
            UIStateKontak(detailKontak = detailKontak)
    }

    /* Fungsi untuk menyimpan data yang di entry */
    suspend fun saveKontak() {
        repositoryKontak.save(uiStateKontak.detailKontak.toKontak())
    }
}


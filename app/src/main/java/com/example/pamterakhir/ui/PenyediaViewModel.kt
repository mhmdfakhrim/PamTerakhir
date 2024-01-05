package com.example.pamterakhir.ui

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.pamterakhir.KontakApplication
import com.example.pamterakhir.ui.add.AddViewModel

fun CreationExtras.aplikasiKontak(): KontakApplication =
    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as KontakApplication)

class PenyediaViewModel {
    val Factory = viewModelFactory {
        initializer {
            AddViewModel(aplikasiKontak().container.kontakRepository)
        }
    }
}
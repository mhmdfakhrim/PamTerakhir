package com.example.pamterakhir.model

data class Kontak(
    val id: String,
    val nama: String,
    val alamat: String,
    val telepon: String
) {
    constructor(): this("", "", "", "")
}
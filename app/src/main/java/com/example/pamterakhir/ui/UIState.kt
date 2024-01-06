package com.example.pamterakhir.ui

data class UIStateKontak(
    val detailKontak: DetailKontak = DetailKontak()
)

data class DetailKontak(
    val id: String = "",
    val nama: String = "",
    val alamat: String = "",
    val telpon: String = "",
)
/* Fungsi untuk mengkonversi data input ke data dalam tabel sesuai jenis datanya*/
fun DetailKontak.toKontak(): Kontak = Kontak(
    id = id,
    nama = nama,
    alamat = alamat,
    telepon = telpon
)

fun Kontak.toUiState(isEntryValid: Boolean = false): UIStateKontak = UIStateKontak(
    detailKontak = this.toDetailKontak(),

)
fun Kontak.toDetailKontak(): DetailKontak = DetailKontak(
    id = id,
    nama = nama,
    alamat = alamat,
    telpon = telepon
)
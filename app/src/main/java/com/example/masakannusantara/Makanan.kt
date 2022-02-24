package com.example.masakannusantara

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

class Makanan {
    var nama:String? = null
    var deskripsi:String? = null
    var gambar:Int? = null

    constructor(nama:String, deskripsi:String, gambar:Int){
        this.nama = nama
        this.deskripsi = deskripsi
        this.gambar = gambar
    }
}




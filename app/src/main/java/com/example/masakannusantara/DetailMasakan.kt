package com.example.masakannusantara

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_detail_masakan.*
import kotlinx.android.synthetic.main.item_makanan.*

class DetailMasakan : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_masakan)

        val bundle = intent.extras

        detailImage.setImageResource(bundle!!.getInt("gambar"))
        detailNama.text = bundle.getString("nama")
        detailDeskripsi.text = bundle.getString("deskripsi")
    }
}
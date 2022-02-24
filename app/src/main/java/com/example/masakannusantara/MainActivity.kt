package com.example.masakannusantara

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_makanan.view.*

class MainActivity() : AppCompatActivity() {

    var listMakanan = ArrayList<Makanan>()
    var adapter : AdapterMakanan? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listMakanan.add(Makanan("Gudeg", "", R.drawable.gudeg))
        listMakanan.add(Makanan("Mie Ayam", "", R.drawable.mieayam))
        listMakanan.add(Makanan("Pempek", "", R.drawable.pempek))
        listMakanan.add(Makanan("Rendang", "", R.drawable.rendang))
        listMakanan.add(Makanan("Sate", "", R.drawable.sate))
        listMakanan.add(Makanan("Soto", "", R.drawable.soto))

        adapter = AdapterMakanan(this, listMakanan)
        gvListMakanan.adapter = adapter
    }

    inner class AdapterMakanan: BaseAdapter{
        var listMakanan = ArrayList<Makanan>()
        var context:Context? = null
        constructor(context: Context, listOfFood: ArrayList<Makanan>):super(){
            this.context = context
            this.listMakanan = listOfFood
        }

        override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
            val makanan = this.listMakanan[p0]
            var inflator = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            var foodView = inflator.inflate(R.layout.item_makanan, null)
            foodView.ivGambarMakanan.setImageResource(makanan.gambar!!)
            foodView.ivGambarMakanan.setOnClickListener{

                val intent = Intent(context, DetailMasakan::class.java)
                intent.putExtra("nama", makanan.nama!!)
                intent.putExtra("deskripsi", makanan.deskripsi!!)
                intent.putExtra("gambar", makanan.gambar!!)
                context!!.startActivity(intent)
            }
            foodView.tvNamaMakanan.text = makanan.nama!!
            return foodView
        }

        override fun getItem(p0: Int): Any {
            return listMakanan[p0]
        }

        override fun getItemId(p0: Int): Long {
            return p0.toLong()
        }

        override fun getCount(): Int {
            return listMakanan.size
        }
    }

}


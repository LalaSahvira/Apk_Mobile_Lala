package com.example.quis_lala.adapter

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.quis_lala.R
import com.example.quis_lala.model.ObatModel

    class AdapterObat (var activity: Activity, var data: ArrayList<ObatModel>): RecyclerView.Adapter<AdapterObat.Holder>() {
        class Holder(view: View) : RecyclerView.ViewHolder(view) {
            val tvkodeobat = view.findViewById<TextView>(R.id.tvkodeobat)
            val tvjenis = view.findViewById<TextView>(R.id.tvjenis)
            val tvpabrik = view.findViewById<TextView>(R.id.tvpabrik)
            val tvharga = view.findViewById<TextView>(R.id.tvharga)

        }

        lateinit var context: Context
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
            context = parent.context
            val view = LayoutInflater.from(parent.context).inflate(R.layout.obat, parent, false)
            return Holder(view)
        }

        @SuppressLint("SetTextI18n")
        override fun onBindViewHolder(holder: Holder, position: Int) {
            val a = data[position]

            holder.tvkodeobat.text = a.kodeobat
            holder.tvjenis.text = a.jenis
            holder.tvpabrik.text = a.pabrik
            holder.tvharga.text = a.harga


        }

        override fun getItemCount(): Int {
            return data.size
        }
    }

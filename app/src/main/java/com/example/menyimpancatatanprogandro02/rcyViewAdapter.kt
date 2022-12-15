//package com.example.menyimpancatatanprogandro02
//
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.TextView
//import androidx.recyclerview.widget.RecyclerView
//
//class rcyViewAdapter (val daftarcatatan: catatan): RecyclerView.Adapter<rcyViewAdapter.catatanHolder>(){
//    class catatanHolder(val v: View): RecyclerView.ViewHolder(v){
//        fun bindView(catatan: catatan){
//            v.findViewById<TextView>(R.id.tvOutputJudul).text = "${catatan.judul}"
//            v.findViewById<TextView>(R.id.tvOutputTanggal).text = "${catatan.tanggal}"
//            v.findViewById<TextView>(R.id.tvOutputCatatan).text = "${catatan.isi}"
//        }
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): catatanHolder {
//        val v = LayoutInflater.from(parent.context).inflate(R.layout.output_catatan, parent, false)
//        return catatanHolder(v)
//    }
//
//    override fun onBindViewHolder(holder: catatanHolder, position: Int) {
//        holder.bindView(daftarcatatan)
//    }
//
//    override fun getItemCount(): Int = 3
//}
package com.example.menyimpancatatanprogandro02

import android.content.ContentValues.TAG
import android.nfc.Tag
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import kotlin.math.log

class MainActivity : AppCompatActivity() {
    var firestore: FirebaseFirestore? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        firestore = FirebaseFirestore.getInstance()

        val judul = findViewById<EditText>(R.id.edtJudul)
        val tanggal = findViewById<EditText>(R.id.edtTanggal)
        val isi = findViewById<EditText>(R.id.edtIsiCatatan)
        val btnSimpanCatatan = findViewById<Button>(R.id.btnSimpanCatatan)
        val txvoutput = findViewById<TextView>(R.id.tvOutput)

        val judulHapus = findViewById<EditText>(R.id.edtHapusJudul)
        val btnDeleteCatatan = findViewById<Button>(R.id.btnDeleteCatatan)

        btnSimpanCatatan.setOnClickListener{
            val catatan = catatan(isi.text.toString(), tanggal.text.toString(), judul.text.toString())

            firestore!!.collection("catatan").document(judul.text.toString()).set(catatan)
            firestore?.collection("catatan")?.get()?.addOnSuccessListener {data ->
                var output = ""
                for(hasil in data){
                    output += "\n${hasil["judul"]} \n${hasil["tanggal"]} \n${hasil["isi"]} \n ==========="
                }
                Toast.makeText(this, "Berhasil menambah catatan", Toast.LENGTH_SHORT).show()
                txvoutput.text = output
            }
        }

        btnDeleteCatatan.setOnClickListener(){
            val hapus = judulHapus.text.toString()
            firestore?.collection("catatan")?.document(hapus)?.delete()
            firestore?.collection("catatan")?.get()?.addOnSuccessListener { data ->
                var output = ""
                for (hasil in data) {
                    output += "\n${hasil["judul"]} \n${hasil["tanggal"]} \n${hasil["isi"]} \n ==========="
                }
                txvoutput.text = output
            }
        }
    }
}
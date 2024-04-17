package com.belajar.uts_setoran

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.belajar.uts_setoran.recyclerRiwayat.RiwayatAdapter
import com.belajar.uts_setoran.recyclerRiwayat.riwayatrowdata
import com.google.android.material.bottomnavigation.BottomNavigationView

class RiwayatActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_riwayat)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        val riwayat = listOf(
            riwayatrowdata(1, "An-Nisa", "The Women", "1", "10", "Makhrajul Huruf", "Belum Selesai"),
            riwayatrowdata(2, "An-Nisa", "The Women", "1", "20", "-", "Belum Selesai"),
            riwayatrowdata(3, "An-Nisa", "The Women", "1", "30", "Makhrajul Huruf", "Belum Selesai")
        )

        val adapter = RiwayatAdapter(riwayat)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter


        val bottomNavigationView: BottomNavigationView = findViewById(R.id.bottomNavigationView)

        bottomNavigationView.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId){
                R.id.home -> {
                    startActivity(Intent(this, HomeActivity::class.java))
                    true
                }R.id.setoran -> {
                startActivity(Intent(this, SetoranActivity::class.java))
                true
            }
                else -> false
            }
        }

    }

}
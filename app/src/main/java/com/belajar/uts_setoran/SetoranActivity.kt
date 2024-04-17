package com.belajar.uts_setoran

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.belajar.uts_setoran.RecyclerView.TableAdapter
import com.belajar.uts_setoran.RecyclerView.tableData
import com.google.android.material.bottomnavigation.BottomNavigationView

class SetoranActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setoran)

        val downloadBut = findViewById<Button>(R.id.downloadBut)
        downloadBut.setOnClickListener {
            val downloader = AndroidDownloader(this)
            downloader.downloadFile("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSmOvqFmi611OWVgI9VH8A0FB7p85kOqFHNZ_cmGV132OiT3PrzrPrLrWsIYCdCYyEnJXI&usqp=CAU")
            Toast.makeText(this, "Downloading...", Toast.LENGTH_SHORT).show()
        }
        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        val tableData = listOf(
            tableData(1, "Al-Fatihah", "The Opening", "AB"),
            tableData(2, "Al-Baqarah", "The Cow", "CD"),
            tableData(3, "Al-Imran", "The Family of Imran", "EF"),
            tableData(4, "An-Nisa", "The Women", "GH")
        )

        val adapter = TableAdapter(tableData)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter


        val bottomNavigationView: BottomNavigationView = findViewById(R.id.bottomNavigationView)

        bottomNavigationView.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId){
                R.id.home -> {
                    startActivity(Intent(this, HomeActivity::class.java))
                    true
                }R.id.riyawat -> {
                startActivity(Intent(this, RiwayatActivity::class.java))
                true
            }
                else -> false
            }
        }

    }

}
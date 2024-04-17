package com.belajar.uts_setoran

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        val bottomNavigationView: BottomNavigationView = findViewById(R.id.bottomNavigationView)

        bottomNavigationView.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId){
                R.id.setoran -> {
                    startActivity(Intent(this, SetoranActivity::class.java))
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
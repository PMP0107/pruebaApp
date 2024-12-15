package com.example.final_entregau3_pmdm.languages

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.final_entregau3_pmdm.R
import com.example.final_entregau3_pmdm.databinding.ActivityLanguagesBinding

class LanguagesActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLanguagesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityLanguagesBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        var btnMore = binding.btnMore
        btnMore.setOnClickListener {
            var intent = Intent(this, CreateLangActivity::class.java)
            startActivity(intent)
        }
    }
}
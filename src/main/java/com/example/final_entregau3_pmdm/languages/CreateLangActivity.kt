package com.example.final_entregau3_pmdm.languages

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import com.example.final_entregau3_pmdm.R
import com.example.final_entregau3_pmdm.data.ProjectDatabase
import com.example.final_entregau3_pmdm.data.entities.LanguageEntity
import com.example.final_entregau3_pmdm.databinding.ActivityCreateLangBinding
import kotlinx.coroutines.launch

class CreateLangActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCreateLangBinding
    private lateinit var database: ProjectDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityCreateLangBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Inicializar la DB
        database = ProjectDatabase.getInstance(applicationContext)

        binding.btnCreate.setOnClickListener {
            val languageName = binding.etAddL.text.toString()
            if (languageName.isNotBlank()) {
                // Guardar en la base de datos usando corutinas
                lifecycleScope.launch {
                    val newLanguage = LanguageEntity(name = languageName)
                    database.getLanguagesDao().insertLanguage(newLanguage)

                    runOnUiThread {
                        Toast.makeText(
                            this@CreateLangActivity,
                            getString(R.string.language_saved),
                            Toast.LENGTH_SHORT
                        ).show()
                        val intent = Intent(this@CreateLangActivity, LanguagesActivity::class.java)
                        startActivity(intent)
                        finish()
                    }
                }
            }else {
                val errMess = getString(R.string.to_langErr)
                Toast.makeText(this, errMess, Toast.LENGTH_SHORT).show()
            }
        }
    }
}
package com.example.final_entregau3_pmdm.login

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import androidx.lifecycle.lifecycleScope
import com.example.final_entregau3_pmdm.R
import com.example.final_entregau3_pmdm.databinding.ActivityRegisterBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.btnRegist1.setOnClickListener {
            val username = binding.etName1.text.toString().trim()
            val password1 = binding.etpPasswd1.text.toString().trim()
            val password2 = binding.etpPasswd2.text.toString().trim()

            if (username.isBlank() || password1.isBlank() || password2.isBlank()) {
                showToast(getString(R.string.to_blankErr))
            } else if (password1 != password2) {
                showToast(getString(R.string.to_errPasswd))
            } else {
                lifecycleScope.launch(Dispatchers.IO) {
                    DataStore.saveCredentials(this@RegisterActivity, username, password1)
                    withContext(Dispatchers.Main) {
                        showToast(getString(R.string.to_registSuc))
                        startActivity(Intent(this@RegisterActivity, LoginActivity::class.java))
                        finish()
                    }
                }
            }
        }
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
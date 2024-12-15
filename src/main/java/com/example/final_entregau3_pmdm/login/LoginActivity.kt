package com.example.final_entregau3_pmdm.login

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import com.example.final_entregau3_pmdm.languages.LanguagesActivity
import com.example.final_entregau3_pmdm.R
import com.example.final_entregau3_pmdm.databinding.ActivityLoginBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.btnRegist.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }

        binding.btnLogin.setOnClickListener {
            val username = binding.etName.text.toString().trim()
            val password = binding.etpPasswd.text.toString().trim()

            if (username.isBlank() || password.isBlank()) {
                showToast(getString(R.string.to_blankErr))
            } else {
                lifecycleScope.launch(Dispatchers.IO) {
                    val credentials = DataStore.getCredentials(this@LoginActivity).firstOrNull()
                    withContext(Dispatchers.Main) {
                        if (credentials != null && username == credentials.name && password == credentials.passwd) {
                            showToast("Login Successful!")
                            startActivity(Intent(this@LoginActivity, LanguagesActivity::class.java))
                            finish()
                        } else {
                            showToast(getString(R.string.to_loginErr))
                        }
                    }
                }
            }
        }
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
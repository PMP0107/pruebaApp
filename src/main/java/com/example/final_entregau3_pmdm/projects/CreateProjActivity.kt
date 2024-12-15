package com.example.final_entregau3_pmdm.projects

import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.renderscript.RenderScript
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import com.example.final_entregau3_pmdm.R
import com.example.final_entregau3_pmdm.data.ProjectDatabase
import com.example.final_entregau3_pmdm.data.entities.ProjectEntity
import com.example.final_entregau3_pmdm.databinding.ActivityCreateProjBinding
import com.example.final_entregau3_pmdm.languages.LanguagesActivity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.Calendar

class CreateProjActivity : AppCompatActivity() {

    lateinit var binding: ActivityCreateProjBinding
    private lateinit var Db: ProjectDatabase
    var name = ""
    var descript = ""
    var date = ""
    var time = ""
    var language = ""
    var details = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityCreateProjBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        dateOptionConfiguration()

        binding.btnSaveProj.setOnClickListener{
            saveProj()
            val intent = Intent(this, LanguagesActivity::class.java)
            startActivity(intent)
        }
    }

    private fun saveProj(){
        name = binding.etProjName.text.toString()
        descript = binding.etProjDesc.text.toString()
        date = binding.etDates.text.toString()
        time = binding.etHoursTime.text.toString()+"hours"
        //language (spinner)
        details = binding.etProjDetails.text.toString()
        val savedProject= ProjectEntity(
            name = name,
            description = descript,
            initDate = date,
            duration = time,
            language = language,
            projDetail = details
        )
        lifecycleScope.launch(Dispatchers.IO){
            Db.ProjectsDao().insertProject(savedProject)
        }

    }

    private fun dateOptionConfiguration(){
        val datePicker = binding.etDates
        datePicker.setOnClickListener {
            val calendar = Calendar.getInstance()
            val year = calendar.get(Calendar.YEAR)
            val month = calendar.get(Calendar.MONTH)
            val day = calendar.get(Calendar.DAY_OF_MONTH)

            val datePickerDialog = DatePickerDialog(
                this,
                { _, selectedYear, selectedMonth, selectedDay ->
                    val date = "$selectedDay/${selectedMonth + 1}/$selectedYear"
                    datePicker.setText(date)
                },
                year, month, day
            )
            datePickerDialog.show()
        }
    }
}
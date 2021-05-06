package com.example.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Layout
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_registro.*
import kotlinx.android.synthetic.main.activity_transferencia__in_data.*

class Transferencia_InData : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_transferencia__in_data)
        var lista = arrayOf("UTMBank", "BanCoppel", "BBVA Bancomer", "Banamex", "Azteca")
        var arrayAdapter = ArrayAdapter<String>(
            this,
            android.R.layout.simple_spinner_dropdown_item,
            android.R.id.text1,
            lista
        )
        spinner_Bancos.adapter = arrayAdapter
        spinner_Bancos.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                Toast.makeText(applicationContext, "${lista[position]}", Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                //
            }
        }
        Cancelar()
    }
    fun Cancelar(){
        btn_cancelar.setOnClickListener(){
            val Main : Intent = Intent(applicationContext,Transferencia_Principal::class.java)
            startActivity(Main)
        }
    }
}

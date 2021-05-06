package com.example.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_servicios_basicos.*

class servicios_basicos : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_servicios_basicos)
        Atras()
        Inscripcion()
        Mensualidad()
        Extra()
    }
    fun Atras(){
        btn_atras.setOnClickListener(){
            val Main : Intent = Intent(applicationContext,Inicio_DrawMenu::class.java)
            startActivity(Main)
        }
    }
    fun Inscripcion(){
        btn_inscripcion.setOnClickListener(){
            val Main : Intent = Intent(applicationContext,Pago_Inscripcion::class.java)
            startActivity(Main)
        }
    }
    fun Mensualidad(){
        btn_mensualidad.setOnClickListener(){
            val Main : Intent = Intent(applicationContext,Pago_Mensualidad::class.java)
            startActivity(Main)
        }
    }
    fun Extra(){
        btn_extraordinario.setOnClickListener(){
            val Main : Intent = Intent(applicationContext,Pago_Extraordinario::class.java)
            startActivity(Main)
        }
    }
}

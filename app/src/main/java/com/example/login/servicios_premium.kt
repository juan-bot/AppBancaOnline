package com.example.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_servicios_premium.*

class servicios_premium : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_servicios_premium)
        Atras()
        PagoLuz()
        PagoNetflix()
        PagoInscripcion()
        PagoExtraordinario()
        PagoMensualidad()
    }
    fun Atras(){
        btn_atras.setOnClickListener(){
            val Main : Intent = Intent(applicationContext,Inicio_DrawMenu::class.java)
            startActivity(Main)
        }
    }
    fun PagoLuz(){
        btn_luz.setOnClickListener() {
            val Main: Intent = Intent(applicationContext, Pago_Luz::class.java)
            startActivity(Main)
        }
    }
    fun PagoNetflix(){
        btn_netflix.setOnClickListener() {
            val Main: Intent = Intent(applicationContext, Pago_Netflix::class.java)
            startActivity(Main)
        }
    }

    fun PagoInscripcion(){
        button_inscripcion.setOnClickListener(){
            val Main : Intent = Intent(applicationContext,Pago_Inscripcion::class.java)
            startActivity(Main)
        }
    }
    fun PagoExtraordinario(){
        button_extraordinario.setOnClickListener() {
            val Main: Intent = Intent(applicationContext, Pago_Extraordinario::class.java)
            startActivity(Main)
        }
    }
    fun PagoMensualidad(){
        button_mensualidad.setOnClickListener() {
            val Main: Intent = Intent(applicationContext, Pago_Mensualidad::class.java)
            startActivity(Main)
        }
    }
}

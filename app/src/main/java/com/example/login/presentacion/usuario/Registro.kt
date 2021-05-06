package com.example.login.presentacion.usuario

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.login.MainActivity
import com.example.login.R
import com.example.login.R.layout.activity_registro
import com.example.login.negocios.controlusuario.CValidaAlta
import com.example.login.servicios.ControlUsuariosDB

import kotlinx.android.synthetic.main.activity_main.btn_Registro
import kotlinx.android.synthetic.main.activity_registro.*

class Registro : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activity_registro)
        Aceptar()
        Cancelar()

    }
    fun Cancelar(){
        btn_cancel.setOnClickListener(){
            val Main : Intent = Intent(applicationContext, MainActivity::class.java)
            startActivity(Main)
        }
    }
    fun Aceptar(){
        var nombre = findViewById<EditText>(R.id.nNombre).text.toString()
        var nmatri = findViewById<EditText>(R.id.editText5).text.toString()
        var npin = findViewById<EditText>(R.id.editText6).text.toString()
        var npwd = findViewById<EditText>(R.id.editText9).text.toString()

        var validaobj= CValidaAlta(nombre,nmatri,npin,npwd)

        var ctrusrobj= ControlUsuariosDB()

        btn_Registro.setOnClickListener(){
            if (validaobj.validarDatos()){
                if(ctrusrobj.altaUsuarioDB(nombre,nmatri,npin,npwd)){
                    Toast.makeText(this, "Registro exitoso.",Toast.LENGTH_LONG).show()
                }
                else{
                    Toast.makeText(this, "Registro no completado.",Toast.LENGTH_LONG).show()
                }

            }
            val aux : Intent = Intent(applicationContext,MainActivity::class.java)
            startActivity(aux)
        }

    }
}
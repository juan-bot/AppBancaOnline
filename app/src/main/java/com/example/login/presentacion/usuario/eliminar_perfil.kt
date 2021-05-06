package com.example.login.presentacion.usuario

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import com.example.login.Inicio_DrawMenu
import com.example.login.MainActivity
import com.example.login.MainActivity.Companion.currentUser

import com.example.login.R
import com.example.login.negocios.controlusuario.CValidaPin
import com.example.login.negocios.controlusuario.usuario
import com.example.login.servicios.ControlUsuariosDB

import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import kotlinx.android.synthetic.main.activity_eliminar_perfil.*

class eliminar_perfil : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_eliminar_perfil)
        Cancelar()
        Continuar()
    }
    fun Continuar(){
        var recpin=findViewById<EditText>(R.id.pin_text).text.toString()
        var matri=currentUser.matricula
        var objvalpin=CValidaPin(matri,recpin)
        var objctrusr=ControlUsuariosDB()
        if (objvalpin.validaPin()){
            if (objctrusr.bajaUsuarioDB(currentUser.matricula)){
                Toast.makeText(this, "Perfil eliminado con exito", Toast.LENGTH_LONG).show()
                val login:Intent= Intent(applicationContext,MainActivity::class.java)
                startActivity(login)
            }
            else{
                Toast.makeText(this, "Error: Perfil no eliminado", Toast.LENGTH_LONG).show()
            }
        }
        else{
            Toast.makeText(this, "Pin incorrecto", Toast.LENGTH_LONG).show()
        }
    }
    fun Cancelar(){
        btn_cancelar.setOnClickListener(){
            val Main : Intent = Intent(applicationContext,Inicio_DrawMenu::class.java)
            startActivity(Main)
        }
    }
}

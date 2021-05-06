package com.example.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import com.example.login.negocios.controlusuario.CValidaInicioSesion
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    companion object{
        var currentUser=CValidaInicioSesion()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Registro()
        InicioSesion()

    }
    fun Registro(){
        btn_Registro.setOnClickListener(){
            val Registro : Intent= Intent(applicationContext, com.example.login.presentacion.usuario.Registro::class.java)
            startActivity(Registro)
        }
    }
    fun InicioSesion(){
        var recmatri=findViewById<EditText>(R.id.txt_matricula).text.toString()
        var recpwd=findViewById<EditText>(R.id.editText4).text.toString()

        btn_inicioSesion.setOnClickListener(){
            if(currentUser.validaInisioSesion(recmatri,recpwd)){
                val Registro : Intent= Intent(applicationContext, Inicio_DrawMenu::class.java)
                Toast.makeText(this, "Inicio de sesion exitoso, Bienvenido", Toast.LENGTH_LONG).show()
                currentUser.instanciaUsuario()
                startActivity(Registro)
            }
            else{
                Toast.makeText(this, "Matricula o contraseña invalidos", Toast.LENGTH_LONG).show()
            }

        }
    }
}

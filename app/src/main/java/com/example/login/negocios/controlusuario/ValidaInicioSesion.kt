package com.example.login.negocios.controlusuario

import android.content.Intent
import android.util.Log
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import com.example.login.Inicio_DrawMenu
import com.example.login.presentacion.usuario.Registro
import com.google.firebase.firestore.FirebaseFirestore

class CValidaInicioSesion{
    var matricula=""
    var contraseña=""

    var nombre=""
    var pin=""
    var saldo=0

    constructor(){
        this.matricula=""
        this.contraseña=""
    }

    fun validaInisioSesion(recmatri:String, recpwd:String): Boolean{
        this.matricula=recmatri
        this.contraseña=recpwd
        val db = FirebaseFirestore.getInstance()
        var bandera=false

       /* db.collection("usuarios").document(this.matricula).get().addOnSuccessListener { result ->
            if (this.contraseña==result["contraseña"].toString()){
                bandera=true
            }
        }.addOnFailureListener { exception ->
            Log.d("TAG", "Error getting documents: ", exception)
        }*/

        db.collection("usuarios")
            .get()
            .addOnSuccessListener { result ->
                for (document in result) {
                    if(document.id == this.matricula){
                        bandera=true
                        //Toast.makeText(this, "Bienvenido ${document.data}", Toast.LENGTH_LONG).show()
                        //startActivity(Registro)
                        Log.d("jalaaaaaaaaaaa", "existe el doc")
                    }
                }
            }
            .addOnFailureListener { exception ->
                Log.d("TAG", "Error getting documents: ", exception)
            }

        return bandera
    }

    fun instanciaUsuario() {
        var db = FirebaseFirestore.getInstance()

        db.collection("usuarios").document(this.matricula).get().addOnSuccessListener { document ->
            this.nombre = document["nombre"].toString()
            this.saldo = document["saldo"].toString().toInt()
            this.pin = document["pin"].toString()
        }.addOnFailureListener{ exception ->
            Log.d("TAG", "Error getting documents: ",exception)
        }
    }
}
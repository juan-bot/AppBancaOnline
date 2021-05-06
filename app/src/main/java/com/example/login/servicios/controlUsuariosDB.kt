package com.example.login.servicios

import android.content.ContentValues.TAG
import android.util.Log
import android.widget.Toast
import com.google.firebase.firestore.FirebaseFirestore

class ControlUsuariosDB{
    var nombre=""
    var matricula=""
    var pin=""
    var contraseña=""

    constructor(){
       this.nombre=""
       this.matricula=""
       this.pin=""
       this.contraseña=""
    }

    fun altaUsuarioDB(recnombre:String, recmatricula:String, recpin:String, reccontraseña:String): Boolean{
        this.matricula=recmatricula
        this.nombre=recnombre
        this.pin=recpin
        this.contraseña=reccontraseña
        var bandera=false
        val alumno = hashMapOf(
            "nombre" to this.nombre,
            "matricula" to this.matricula,
            "pin" to this.pin,
            "contraseña" to this.contraseña,
            "saldo" to 0
        )
        val db = FirebaseFirestore.getInstance()
        db.collection("usuarios").document(this.matricula).set(alumno).addOnSuccessListener {
            Log.d("exit", "DocumentSnapshot successfully written!")
            bandera=true
        }.addOnFailureListener {
            e -> Log.w("errorDB", "Error writing document", e)
            bandera=false
        }
        return  bandera
    }

    fun bajaUsuarioDB(recmatri:String): Boolean{
        var bandera=false
        val db = FirebaseFirestore.getInstance()
        db.collection("usuarios").document(recmatri).delete().addOnSuccessListener {
            Log.d(TAG, "DocumentSnapshot successfully deleted")
            bandera=true
        }.addOnFailureListener{ e ->
            Log.w(TAG, "Error deleting document",e)
            bandera=false
        }
        return bandera
    }
}
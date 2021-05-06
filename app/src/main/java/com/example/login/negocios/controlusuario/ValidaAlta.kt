package com.example.login.negocios.controlusuario

import android.util.Log
import android.widget.Toast
import com.google.firebase.firestore.FirebaseFirestore


class CValidaAlta{
    var nombre=""
    var matricula=""
    var pin=""
    var contraseña=""

    constructor(recnombre:String, recmatricula:String, recpin:String, reccontraseña:String){
        this.matricula=recmatricula
        this.nombre=recnombre
        this.pin=recpin
        this.contraseña=reccontraseña
    }

    fun validarDatos(): Boolean {
        val db = FirebaseFirestore.getInstance()
        var bandera=true
        val alumno = hashMapOf(
            "nombre" to  this.nombre,
            "matricula" to this.matricula,
            "pin" to  this.pin,
            "contraseña" to this.contraseña
        )
        if (!(this.nombre==null || this.nombre.trim()=="" || this.matricula==null || this.matricula.trim()=="" || this.pin==null || this.pin.trim()=="" || this.contraseña==null || this.contraseña.trim()==null)){
            /*db.collection("usuarios").get().addOnSuccessListener { result ->
                for (document in result) {
                    if (document.id == this.matricula){
                        bandera=false
                    }
                }
            }.addOnFailureListener { exception ->
                Log.d("TAG", "Error getting documents: ", exception)
            }*/
            db.collection("usuarios").document(this.matricula)
                .set(alumno)
                .addOnSuccessListener {
                    Log.d("exit", "DocumentSnapshot successfully written!")
                }
                .addOnFailureListener {
                        e -> Log.w("errorDB", "Error writing document", e)
                }
            return bandera
        }
        else{
            return false
        }
    }
}

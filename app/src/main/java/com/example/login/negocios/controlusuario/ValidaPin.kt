package com.example.login.negocios.controlusuario

import android.util.Log
import com.google.firebase.firestore.FirebaseFirestore

class CValidaPin{
    var matricula=""
    var pin=""
    var bandera=false

    constructor(recmatri:String, recpin:String){
        this.pin=recpin
        this.matricula=recmatri
    }

    fun validaPin(): Boolean{
        val db = FirebaseFirestore.getInstance()
        db.collection("usuarios").document(this.matricula).get().addOnSuccessListener { result ->
            if (this.pin==result["pin"].toString()){
                bandera=true
            }
        }.addOnFailureListener { exception ->
            Log.d("TAG", "Error getting documents: ", exception)
            bandera=false
        }
        return bandera
    }
}
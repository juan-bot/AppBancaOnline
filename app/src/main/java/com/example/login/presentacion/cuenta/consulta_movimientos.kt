package com.example.login.presentacion.cuenta

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.login.Inicio_DrawMenu
import com.example.login.MainActivity.Companion.currentUser
import com.example.login.R
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_consulta_movimientos.*

class consulta_movimientos : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_consulta_movimientos)
        Proyecta()
        Atras()
    }
    fun Proyecta(){
        var db = FirebaseFirestore.getInstance()
        var i=0
        db.collection("movimientos").get().addOnSuccessListener { result ->
            for (document in result) {
                if (document["matricula"].toString() == currentUser.matricula && i<5){
                    when(i){
                        0 ->{
                            textView61.text=document["fecha"].toString()
                            textView58.text=document["concepto"].toString()
                            textView62.text=("$"+document["monto"].toString()+".00")
                        }
                        1 ->{
                            textView55.text=document["fecha"].toString()
                            textView52.text=document["concepto"].toString()
                            textView56.text=("$"+document["monto"].toString()+".00")
                        }
                        2 ->{
                            textView103.text=document["fecha"].toString()
                            textView105.text=document["concepto"].toString()
                            textView68.text=("$"+document["monto"].toString()+".00")
                        }
                        3 ->{
                            textView97.text=document["fecha"].toString()
                            textView30.text=document["concepto"].toString()
                            textView98.text=("$"+document["monto"].toString()+".00")
                        }
                        4 ->{
                            textView35.text=document["fecha"].toString()
                            textView34.text=document["concepto"].toString()
                            textView33.text=("$"+document["monto"].toString()+".00")
                        }
                    }
                    i++
                }
            }
            while (i<5){
                when(i){
                    0 ->{
                        textView61.text="No se encontro movimiento"
                        textView58.text="No se encontro movimiento"
                        textView62.text=("$0.00")
                    }
                    1 ->{
                        textView55.text="No se encontro movimiento"
                        textView52.text="No se encontro movimiento"
                        textView56.text=("$0.00")
                    }
                    2 ->{
                        textView103.text="No se encontro movimiento"
                        textView105.text="No se encontro movimiento"
                        textView68.text=("$0.00")
                    }
                    3 ->{
                        textView97.text="No se encontro movimiento"
                        textView30.text="No se encontro movimiento"
                        textView98.text=("$0.00")
                    }
                    4 ->{
                        textView35.text="No se encontro movimiento"
                        textView34.text="No se encontro movimiento"
                        textView33.text=("$0.00")
                    }
                }
                i++
            }
        }.addOnFailureListener { exception ->
            Log.d("TAG", "Error getting documents: ", exception)
        }
    }
    fun Atras(){
        btn_atras.setOnClickListener(){
            val Main : Intent = Intent(applicationContext,
                Inicio_DrawMenu::class.java)
            startActivity(Main)
        }
    }
}

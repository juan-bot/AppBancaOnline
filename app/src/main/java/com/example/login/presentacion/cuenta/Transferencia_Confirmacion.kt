package com.example.login.presentacion.cuenta
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.login.R
import com.example.login.Transferencia_Principal
import kotlinx.android.synthetic.main.activity_transferencia__principal.*

class Transferencia_Confirmacion : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_transferencia__confirmacion)
        Cancelar()
    }
    fun Cancelar(){
        btn_cancelar.setOnClickListener(){
            val Main : Intent = Intent(applicationContext,
                Transferencia_Principal::class.java)
            startActivity(Main)
        }
    }
}

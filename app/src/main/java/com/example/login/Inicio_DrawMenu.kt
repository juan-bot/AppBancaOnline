package com.example.login
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast

import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.example.login.presentacion.cuenta.consulta_movimientos
import com.example.login.presentacion.usuario.eliminar_perfil
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.content_main.*

class Inicio_DrawMenu : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    lateinit var toolbar: Toolbar
    lateinit var drawerLayout: DrawerLayout
    lateinit var navView: NavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inicio__draw_menu)
        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        drawerLayout = findViewById(R.id.drawer_layout)
        navView = findViewById(R.id.nav_view)
        val toggle = ActionBarDrawerToggle(
            this, drawerLayout, toolbar, 0, 0
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        navView.setNavigationItemSelectedListener(this)
        Tranferencias()
        Movimientos()
        Pagos()
    }
    fun Tranferencias(){
        btn_transferencias.setOnClickListener(){
            val Registro : Intent= Intent(applicationContext, Transferencia_Principal::class.java)
            startActivity(Registro)
        }
    }
    fun Movimientos(){
        btn_movimientos.setOnClickListener(){
            val Registro : Intent = Intent(applicationContext, consulta_movimientos::class.java)
            startActivity(Registro)
        }
    }
    fun Pagos(){
        btn_pagos.setOnClickListener(){
            val Registro : Intent= Intent(applicationContext,servicios_basicos::class.java)
            startActivity(Registro)
        }
    }
    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_profile -> {
                Toast.makeText(this, "Perfil", Toast.LENGTH_SHORT).show()
            }
            R.id.nav_update -> {
                val Registro : Intent = Intent(applicationContext, servicios_premium::class.java)
                startActivity(Registro)
            }
            R.id.nav_edit -> {
                val Registro : Intent = Intent(applicationContext, editar_perfil::class.java)
                startActivity(Registro)
            }
            R.id.nav_delete -> {
                val Registro : Intent = Intent(applicationContext, eliminar_perfil::class.java)
                startActivity(Registro)
            }
            R.id.nav_logout -> {
                val Registro : Intent = Intent(applicationContext, MainActivity::class.java)
                startActivity(Registro)
            }
        }
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }
}

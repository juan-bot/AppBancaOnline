package com.example.login.negocios.controlusuario

class usuario {
    var nombre = ""
    var matricula = 0
    var pin = 0
    var password = ""
    var saldo =0
    var tipoCuenta = 0
    var claveInterbank = 0
    constructor(nombre:String, matricula:Int, pin:Int, password:String){
        this.matricula=matricula
        this.nombre=nombre
        this.pin=pin
        this.password=password
    }
}
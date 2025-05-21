package com.nalvarte.maryurit.laboratoriocalificado02

class Contacto(val nombre: String, val telefono: String, val email: String) {
    override fun toString(): String {
        return "Nombre: $nombre\nTeléfono: $telefono\nEmail: $email"
    }
}
package com.nalvarte.maryurit.laboratoriocalificado02

class Agenda {
    private val contactos = mutableListOf<Contacto>()

    fun agregarContacto(contacto: Contacto) {
        contactos.add(contacto)
    }

    fun listarContactos(): List<Contacto> {
        return contactos.toList()
    }

    fun buscarPorNombre(nombre: String): Contacto? {
        return contactos.find { it.nombre.equals(nombre, ignoreCase = true) }
    }
}
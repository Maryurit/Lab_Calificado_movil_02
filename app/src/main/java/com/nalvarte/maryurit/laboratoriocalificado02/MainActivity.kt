package com.nalvarte.maryurit.laboratoriocalificado02

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.nalvarte.maryurit.laboratoriocalificado02.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Navegación a Ejercicio 1
        binding.btnEjercicio1.setOnClickListener {
            startActivity(Intent(this, Ejercicio01Activity::class.java))
        }

        // Navegación a Ejercicio 2
        binding.btnEjercicio2.setOnClickListener {
            startActivity(Intent(this, Ejercicio02Activity::class.java))
        }

        // Probar Agenda de Contactos
        binding.btnAgendaContactos.setOnClickListener {
            probarAgenda()
        }
    }

    private fun probarAgenda() {
        val agenda = Agenda()
        val resultados = StringBuilder()

        // Agregar contactos
        agenda.agregarContacto(Contacto("Maryurit Nalvarte", "999888777", "mary@unal.edu.pe"))
        agenda.agregarContacto(Contacto("Juan Perez", "111222333", "juan@email.com"))

        // Listar contactos
        resultados.appendLine("=== CONTACTOS ===")
        agenda.listarContactos().forEach { resultados.appendLine(it) }

        // Buscar contacto
        resultados.appendLine("\n=== BUSQUEDA ===")
        val contacto = agenda.buscarPorNombre("Maryurit Nalvarte")
        resultados.appendLine(contacto ?: "Contacto no encontrado")

        binding.tvResultados.text = resultados.toString()
    }
}
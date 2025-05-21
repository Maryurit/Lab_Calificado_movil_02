package com.nalvarte.maryurit.laboratoriocalificado02

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.nalvarte.maryurit.laboratoriocalificado02.databinding.ActivityEjercicio02Binding

class Ejercicio02Activity : AppCompatActivity() {
    private lateinit var binding: ActivityEjercicio02Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEjercicio02Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnRegistrar.setOnClickListener {
            if (validarCampos()) {
                val intent = Intent(this, DetalleActivity::class.java).apply {
                    putExtra("nombre", binding.etNombre.text.toString())
                    putExtra("productos", binding.etProductos.text.toString())
                    putExtra("direccion", binding.etDireccion.text.toString())
                    putExtra("telefono", binding.etTelefono.text.toString())
                }
                startActivity(intent)
            }
        }

        binding.btnLlamar.setOnClickListener {
            if (validarCampos()) {
                Toast.makeText(this, "Llamando a: ${binding.etNombre.text}", Toast.LENGTH_SHORT).show()
            }
        }

        binding.btnWhatsapp.setOnClickListener {
            if (validarCampos()) {
                val mensaje = """
                    Hola ${binding.etNombre.text}!
                    Tus productos: ${binding.etProductos.text}
                    están en camino a: ${binding.etDireccion.text}
                """.trimIndent()
                Toast.makeText(this, mensaje, Toast.LENGTH_LONG).show()
            }
        }

        binding.btnMaps.setOnClickListener {
            if (validarCampos()) {
                Toast.makeText(this, "Mostrando mapa para: ${binding.etDireccion.text}", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun validarCampos(): Boolean {
        var valido = true

        if (binding.etNombre.text.isNullOrEmpty()) {
            binding.etNombre.error = "Ingrese el nombre"
            valido = false
        }

        if (binding.etProductos.text.isNullOrEmpty()) {
            binding.etProductos.error = "Ingrese los productos"
            valido = false
        }

        if (binding.etDireccion.text.isNullOrEmpty()) {
            binding.etDireccion.error = "Ingrese la dirección"
            valido = false
        }

        if (binding.etTelefono.text.isNullOrEmpty()) {
            binding.etTelefono.error = "Ingrese el teléfono"
            valido = false
        }

        return valido
    }
}
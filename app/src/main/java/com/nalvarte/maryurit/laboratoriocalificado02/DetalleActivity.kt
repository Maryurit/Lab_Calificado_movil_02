package com.nalvarte.maryurit.laboratoriocalificado02

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.nalvarte.maryurit.laboratoriocalificado02.databinding.ActivityDetalleBinding

class DetalleActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetalleBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetalleBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val nombre = intent.getStringExtra("nombre") ?: "No definido"
        val productos = intent.getStringExtra("productos") ?: "No definido"
        val direccion = intent.getStringExtra("direccion") ?: "No definido"
        val telefono = intent.getStringExtra("telefono") ?: "No definido"

        binding.tvNombre.text = "Cliente: $nombre"
        binding.tvProductos.text = "Productos: $productos"
        binding.tvDireccion.text = "Dirección: $direccion"
        binding.tvTelefono.text = "Teléfono: $telefono"
    }
}
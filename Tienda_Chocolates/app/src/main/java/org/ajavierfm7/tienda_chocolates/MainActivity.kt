package org.ajavierfm7.tienda_chocolates

import android.os.Bundle
import android.content.Intent
import android.widget.Toast
import org.ajavierfm7.tienda_chocolates.model.CarritoManager
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import org.ajavierfm7.tienda_chocolates.adapter.ProductoAdapter
import org.ajavierfm7.tienda_chocolates.databinding.ActivityMainBinding
import org.ajavierfm7.tienda_chocolates.model.Producto

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        CarritoManager.cargar(this)

        val productos = listOf(
            Producto("Bombones", "Dulces rellenos de chocolate con licor", 2.50, R.drawable.bombones),
            Producto("Paletas", "Paletas de chocolate con forma divertida", 1.75, R.drawable.paletas),
            Producto("Caramelo", "Chocolate con centro de caramelo suave", 1.25, R.drawable.caramelo),
            Producto("Barra", "Barra clásica de chocolate con leche", 3.00, R.drawable.barra)
        )

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = ProductoAdapter(productos) { productoSeleccionado ->
            CarritoManager.agregar(this, productoSeleccionado)
            Toast.makeText(this, "Producto agregado al carrito", Toast.LENGTH_SHORT).show()
        }

        // Evento para abrir el carrito
        binding.btnCarrito.setOnClickListener {
            val intent = Intent(this, CarritoActivity::class.java)
            startActivity(intent)
        }
    }

}

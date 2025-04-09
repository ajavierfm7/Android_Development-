package org.ajavierfm7.tienda_chocolates

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import org.ajavierfm7.tienda_chocolates.databinding.ActivityCarritoBinding
import org.ajavierfm7.tienda_chocolates.adapter.ProductoAdapter
import org.ajavierfm7.tienda_chocolates.model.CarritoManager


class CarritoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCarritoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCarritoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // ✅ Ahora es seguro usar el context
        CarritoManager.cargar(this)

        val productosCarrito = CarritoManager.obtenerCarrito()
        binding.txtTotal.text = "Total: C$${CarritoManager.total()}"


        if (productosCarrito.isEmpty()) {
            Toast.makeText(this, "El carrito está vacío", Toast.LENGTH_SHORT).show()
        }

        binding.recyclerCarrito.layoutManager = LinearLayoutManager(this)
        binding.recyclerCarrito.adapter = ProductoAdapter(productosCarrito) { }

        val total = CarritoManager.total()
        binding.txtTotal.text = "Total: C$%.2f".format(total)

        binding.btnVaciarCarrito.setOnClickListener {
            CarritoManager.limpiar(this)
            Toast.makeText(this, "Carrito vaciado", Toast.LENGTH_SHORT).show()
            recreate() // recargar la actividad para actualizar la vista
        }


        binding.btnVolver.setOnClickListener {
            finish() // Cierra la Activity actual y vuelve a la anterior
        }


    }


}


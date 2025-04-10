package org.ajavierfm7.tienda_chocolates

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import org.ajavierfm7.tienda_chocolates.databinding.ActivityCarritoBinding
import org.ajavierfm7.tienda_chocolates.adapter.ProductoAdapter
import org.ajavierfm7.tienda_chocolates.model.CarritoAdapter
import org.ajavierfm7.tienda_chocolates.model.CarritoManager


class CarritoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCarritoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCarritoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        CarritoManager.cargar(this)
        val productosCarrito = CarritoManager.obtenerCarrito()

        // Configurar RecyclerView con el nuevo adaptador
        binding.recyclerCarrito.layoutManager = LinearLayoutManager(this)
        binding.recyclerCarrito.adapter = CarritoAdapter(productosCarrito)

        // Mostrar el total y cantidad total
        val total = CarritoManager.total()
        val cantidad = CarritoManager.totalCantidad()
        binding.txtTotal.text = "Total: $%.2f | Productos: $cantidad".format(total)

        // Mensaje si está vacío
        if (productosCarrito.isEmpty()) {
            Toast.makeText(this, "El carrito está vacío", Toast.LENGTH_SHORT).show()
        }

        // Vaciar carrito
        binding.btnVaciarCarrito.setOnClickListener {
            CarritoManager.limpiar(this)
            Toast.makeText(this, "Carrito vaciado", Toast.LENGTH_SHORT).show()
            recreate()
        }

        // Pasar a realizar pedido
        binding.btnContinuar.setOnClickListener {
            val intent = Intent(this, PedidoActivity::class.java)
            startActivity(intent)
        }


        // Volver
        binding.btnVolver.setOnClickListener {
            finish()
        }
    }



}


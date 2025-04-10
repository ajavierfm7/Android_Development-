package org.ajavierfm7.tienda_chocolates

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import org.ajavierfm7.tienda_chocolates.databinding.ActivityPedidoBinding
import org.ajavierfm7.tienda_chocolates.model.CarritoManager
import android.content.Intent
import android.net.Uri


class PedidoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPedidoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPedidoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val total = CarritoManager.total()
        val cantidad = CarritoManager.totalCantidad()

        binding.txtResumen.text = "Total: $%.2f | Productos: $cantidad".format(total)

        binding.btnConfirmar.setOnClickListener {
            val nombre = binding.inputNombre.text.toString()
            val telefono = binding.inputTelefono.text.toString()

            if (nombre.isBlank() || telefono.isBlank()) {
                Toast.makeText(this, "Por favor complete todos los campos", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Pedido generado con éxito", Toast.LENGTH_LONG).show()
                // Aquí puedes agregar lógica para guardar el pedido o continuar a la pantalla de pago
                finish() // o startActivity(pantallaPago)
            }
        }

        binding.btnEnviarWhatsapp.setOnClickListener {
            val nombre = binding.inputNombre.text.toString()
            val telefono = binding.inputTelefono.text.toString()
            val productos = CarritoManager.obtenerCarrito()
            val total = CarritoManager.total()

            val detallesProductos = productos.joinToString("\n") {
                "• ${it.nombre} x${it.cantidad} - $${"%.2f".format(it.precio * it.cantidad)}"
            }

            val mensaje = """
        ¡Hola! Soy $nombre.
        Mi número: $telefono
        
        Deseo hacer un pedido de Chocolates Nicarao:

        $detallesProductos

        Total a pagar: $${"%.2f".format(total)}
    """.trimIndent()

            val url = "https://wa.me/50589114744?text=${Uri.encode(mensaje)}"
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(url)

            // Verifica que exista la app de WhatsApp
            if (intent.resolveActivity(packageManager) != null) {
                startActivity(intent)
            } else {
                Toast.makeText(this, "WhatsApp no está instalado", Toast.LENGTH_SHORT).show()
            }
        }

        binding.btnVolver.setOnClickListener {
            finish() // Cierra la pantalla y regresa a la anterior
        }


    }
}

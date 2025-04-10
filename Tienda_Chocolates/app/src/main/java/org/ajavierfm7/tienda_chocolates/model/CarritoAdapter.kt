package org.ajavierfm7.tienda_chocolates.model

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import org.ajavierfm7.tienda_chocolates.R
import org.ajavierfm7.tienda_chocolates.model.Producto

class CarritoAdapter(private val productos: List<Producto>) :
    RecyclerView.Adapter<CarritoAdapter.ViewHolder>() {

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val img = view.findViewById<ImageView>(R.id.imgProducto)
        val nombre = view.findViewById<TextView>(R.id.txtNombre)
        val cantidad = view.findViewById<TextView>(R.id.txtCantidad)
        val subtotal = view.findViewById<TextView>(R.id.txtSubtotal)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_carrito, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = productos.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val producto = productos[position]
        holder.img.setImageResource(producto.imagen)
        holder.nombre.text = producto.nombre
        holder.cantidad.text = "Cantidad: ${producto.cantidad}"
        val subtotal = producto.precio * producto.cantidad
        holder.subtotal.text = "Subtotal: $%.2f".format(subtotal)
    }
}


package org.ajavierfm7.tienda_chocolates.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.ajavierfm7.tienda_chocolates.databinding.ItemProductoBinding
import org.ajavierfm7.tienda_chocolates.model.Producto

class ProductoAdapter(private val lista: List<Producto>) :
    RecyclerView.Adapter<ProductoAdapter.ProductoViewHolder>() {

    inner class ProductoViewHolder(val binding: ItemProductoBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductoViewHolder {
        val binding = ItemProductoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProductoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProductoViewHolder, position: Int) {
        val producto = lista[position]
        holder.binding.apply {
            txtNombre.text = producto.nombre
            txtDescripcion.text = producto.descripcion
            txtPrecio.text = "$${producto.precio}"
            imgProducto.setImageResource(producto.imagenResId)
        }
    }

    override fun getItemCount(): Int = lista.size
}

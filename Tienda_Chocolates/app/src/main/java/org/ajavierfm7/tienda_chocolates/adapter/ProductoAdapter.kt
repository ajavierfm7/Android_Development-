package org.ajavierfm7.tienda_chocolates.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.ajavierfm7.tienda_chocolates.databinding.ItemProductoBinding
import org.ajavierfm7.tienda_chocolates.model.Producto

class ProductoAdapter(
    private val lista: List<Producto>,
    private val onClick: (Producto) -> Unit // <- NUEVO parámetro
) : RecyclerView.Adapter<ProductoAdapter.ProductoViewHolder>() {

    inner class ProductoViewHolder(val binding: ItemProductoBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(producto: Producto) {
            binding.txtNombre.text = producto.nombre
            binding.txtDescripcion.text = producto.descripcion
            binding.txtPrecio.text = "$${producto.precio}"
            binding.imgProducto.setImageResource(producto.imagen)

            binding.root.setOnClickListener {
                onClick(producto) // <- Ejecuta el clic personalizado
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductoViewHolder {
        val binding = ItemProductoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProductoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProductoViewHolder, position: Int) {
        val producto = lista[position]
        holder.bind(producto)
    }

    override fun getItemCount(): Int = lista.size
}


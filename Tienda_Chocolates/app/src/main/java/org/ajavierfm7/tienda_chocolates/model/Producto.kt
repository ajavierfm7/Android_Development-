package org.ajavierfm7.tienda_chocolates.model

data class Producto(
    val nombre: String,
    val descripcion: String,
    val precio: Double,
    val imagen: Int,
    var cantidad: Int = 1
)

package org.ajavierfm7.tienda_chocolates.model

import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

object CarritoManager {
    private const val PREFS_NAME = "CarritoPrefs"
    private const val KEY_CARRITO = "carrito"

    private val carrito = mutableListOf<Producto>()

    fun agregar(context: Context, producto: Producto) {
        carrito.add(producto)
        guardar(context)
    }

    fun eliminar(context: Context, producto: Producto) {
        carrito.remove(producto)
        guardar(context)
    }

    fun obtenerCarrito(): List<Producto> = carrito

    fun limpiar(context: Context) {
        carrito.clear()
        guardar(context)
    }

    fun total(): Double = carrito.sumOf { it.precio }

    fun guardar(context: Context) {
        val prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        val editor = prefs.edit()
        val json = Gson().toJson(carrito)
        editor.putString(KEY_CARRITO, json)
        editor.apply()
    }

    fun cargar(context: Context) {
        val prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        val json = prefs.getString(KEY_CARRITO, null)
        if (json != null) {
            val type = object : TypeToken<MutableList<Producto>>() {}.type
            val listaGuardada: MutableList<Producto> = Gson().fromJson(json, type)
            carrito.clear()
            carrito.addAll(listaGuardada)
        }
    }
}



package org.ajavierfm7.dev

import androidx.activity.enableEdgeToEdge
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Referencias a los elementos de la UI
        val etNombre: EditText = findViewById(R.id.etNombre)
        val etApellido: EditText = findViewById(R.id.etApellido)
        val btnSaludar: Button = findViewById(R.id.btnSaludar)
        val tvSaludo: TextView = findViewById(R.id.tvSaludo)

        // Configurar el botón
        btnSaludar.setOnClickListener {
            val nombre = etNombre.text.toString().trim()
            val apellido = etApellido.text.toString().trim()

            if (nombre.isNotEmpty() && apellido.isNotEmpty()) {
                val saludo = "Hola, $nombre $apellido!"
                tvSaludo.text = saludo
            } else {
                tvSaludo.text = "Por favor, ingresa tu nombre y apellido."
            }
        }
    }
}
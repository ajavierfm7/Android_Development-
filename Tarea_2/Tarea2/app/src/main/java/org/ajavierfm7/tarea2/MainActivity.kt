package org.ajavierfm7.tarea2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnGoAge = findViewById<Button>(R.id.btnGoAge)
        val btnGoNotes = findViewById<Button>(R.id.btnGoNotes)

        // Botón para ir a la pantalla de registrar/evaluar edad
        btnGoAge.setOnClickListener {
            val intent = Intent(this, EdadActivity::class.java)
            startActivity(intent)
        }

        // Botón para ir a la pantalla de calcular promedio de notas
        btnGoNotes.setOnClickListener {
            val intent = Intent(this, NotasActivity::class.java)
            startActivity(intent)
        }
    }
}

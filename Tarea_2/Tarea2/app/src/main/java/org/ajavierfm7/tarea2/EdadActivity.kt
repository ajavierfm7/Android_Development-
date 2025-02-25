package org.ajavierfm7.tarea2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class EdadActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edad)

        val etNameAge = findViewById<EditText>(R.id.etNameAge)
        val etAge = findViewById<EditText>(R.id.etAge)
        val btnEvaluateAge = findViewById<Button>(R.id.btnEvaluateAge)
        val btnGoToNotesFromAge = findViewById<Button>(R.id.btnGoToNotesFromAge)

        btnEvaluateAge.setOnClickListener {
            val name = etNameAge.text.toString()
            val ageText = etAge.text.toString()

            if (name.isNotEmpty() && ageText.isNotEmpty()) {
                val age = ageText.toInt()
                if (age >= 18) {
                    Toast.makeText(this, "$name es mayor de edad", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "$name es menor de edad", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Por favor llena todos los campos", Toast.LENGTH_SHORT).show()
            }
        }

        // Botón para ir a la pantalla de calcular notas
        btnGoToNotesFromAge.setOnClickListener {
            val intent = Intent(this, NotasActivity::class.java)
            startActivity(intent)
        }
    }
}

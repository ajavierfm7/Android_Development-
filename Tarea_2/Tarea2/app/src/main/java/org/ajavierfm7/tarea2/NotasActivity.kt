package org.ajavierfm7.tarea2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class NotasActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notas)

        val etStudentName = findViewById<EditText>(R.id.etStudentName)
        val etNote1 = findViewById<EditText>(R.id.etNote1)
        val etNote2 = findViewById<EditText>(R.id.etNote2)
        val etNote3 = findViewById<EditText>(R.id.etNote3)
        val btnCalculateNotes = findViewById<Button>(R.id.btnCalculateNotes)
        val tvFinalNote = findViewById<TextView>(R.id.tvFinalNote)

        btnCalculateNotes.setOnClickListener {
            val name = etStudentName.text.toString()
            val n1 = etNote1.text.toString()
            val n2 = etNote2.text.toString()
            val n3 = etNote3.text.toString()

            if (name.isNotEmpty() && n1.isNotEmpty() && n2.isNotEmpty() && n3.isNotEmpty()) {
                val note1 = n1.toFloat()
                val note2 = n2.toFloat()
                val note3 = n3.toFloat()

                val average = (note1 + note2 + note3) / 3

                // Muestra el resultado en el TextView
                tvFinalNote.text = average.toString()

                // También un Toast con la información
                Toast.makeText(
                    this,
                    "El estudiante $name tiene un promedio de $average",
                    Toast.LENGTH_LONG
                ).show()
            } else {
                Toast.makeText(this, "Por favor completa todos los campos", Toast.LENGTH_SHORT).show()
            }
        }
    }
}

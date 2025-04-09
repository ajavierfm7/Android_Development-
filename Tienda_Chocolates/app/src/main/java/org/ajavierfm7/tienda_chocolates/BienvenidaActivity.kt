package org.ajavierfm7.tienda_chocolates

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import org.ajavierfm7.tienda_chocolates.databinding.ActivityBienvenidaBinding

class BienvenidaActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBienvenidaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBienvenidaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnEntrar.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish() // Finaliza esta pantalla para que no regrese con el botón de retroceso
        }
    }
}

package org.ajavierfm7.examen1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import org.ajavierfm7.examen1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCalcular.setOnClickListener {
            calcularSalario()
        }
    }

    private fun calcularSalario() {
        println("Función calcularSalario() ejecutada") // Depuración

        val horasText = binding.etHorasTrabajadas.text.toString().trim()
        val tarifaText = binding.etTarifaHora.text.toString().trim()

        // Validar si los campos están vacíos
        if (horasText.isEmpty() || tarifaText.isEmpty()) {
            println("Error: Uno o más campos vacíos") // Depuración
            binding.tvSalarioBruto.text = getString(R.string.error_datos)
            binding.tvDeduccionINSS.text = ""
            binding.tvSalarioNeto.text = ""
            return
        }

        val horasTrabajadas = horasText.toDoubleOrNull()
        val tarifaHora = tarifaText.toDoubleOrNull()

        // Validar si los valores son números válidos
        if (horasTrabajadas == null || tarifaHora == null) {
            println("Error: Valores inválidos") // Depuración
            binding.tvSalarioBruto.text = getString(R.string.error_numeros)
            binding.tvDeduccionINSS.text = ""
            binding.tvSalarioNeto.text = ""
            return
        }

        val salarioBruto = horasTrabajadas * tarifaHora
        val deduccionINSS = salarioBruto * 0.07
        val salarioNeto = salarioBruto - deduccionINSS

        println("Salario calculado: Bruto=$salarioBruto, INSS=$deduccionINSS, Neto=$salarioNeto") // Depuración

        // Corregir el uso de `String.format()` para evitar `UnknownFormatConversionException`
        binding.tvSalarioBruto.text = String.format(getString(R.string.salario_bruto), salarioBruto)
        binding.tvDeduccionINSS.text = String.format(getString(R.string.deduccion_inss), deduccionINSS)
        binding.tvSalarioNeto.text = String.format(getString(R.string.salario_neto), salarioNeto)
    }
}


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
        val horasTrabajadas = binding.etHorasTrabajadas.text.toString().toDoubleOrNull() ?: 0.0
        val tarifaHora = binding.etTarifaHora.text.toString().toDoubleOrNull() ?: 0.0

        val salarioBruto = horasTrabajadas * tarifaHora
        val deduccionINSS = salarioBruto * 0.07
        val salarioNeto = salarioBruto - deduccionINSS

        binding.tvSalarioBruto.text = "Salario Bruto: C$ %.2f".format(salarioBruto)
        binding.tvDeduccionINSS.text = "Deducción INSS (7%): C$ %.2f".format(deduccionINSS)
        binding.tvSalarioNeto.text = "Salario Neto: C$ %.2f".format(salarioNeto)
    }
}
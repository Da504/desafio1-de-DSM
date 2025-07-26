package udb.edu.sv

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class SalarioActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_salario)

        val nombre = findViewById<EditText>(R.id.txtEmpleado)
        val salarioBase = findViewById<EditText>(R.id.txtSalario)
        val btnCalcular = findViewById<Button>(R.id.btnCalcularSalario)
        val resultado = findViewById<TextView>(R.id.txtResultadoSalario)

        btnCalcular.setOnClickListener {
            if (nombre.text.isEmpty()) {
                nombre.error = "Ingrese nombre"
                return@setOnClickListener
            }

            val base = salarioBase.text.toString().toDoubleOrNull()
            if (base == null || base <= 0) {
                salarioBase.error = "Salario inválido"
                return@setOnClickListener
            }

            val afp = base * 0.0725
            val isss = base * 0.03
            val renta = calcularRenta(base)
            val totalDescuento = afp + isss + renta
            val salarioNeto = base - totalDescuento

            resultado.text = "Empleado: ${nombre.text}\nAFP: $afp\nISSS: $isss\nRenta: $renta\nNeto: $salarioNeto"
        }
    }

    private fun calcularRenta(salario: Double): Double {
        return when {
            salario < 472 -> 0.0
            salario < 895.24 -> (salario - 472) * 0.107 + 17.67
            salario < 2038.10 -> (salario - 895.24) * 0.20 + 60.0
            else -> (salario - 2038.10) * 0.30 + 288.57
        }
    }
}

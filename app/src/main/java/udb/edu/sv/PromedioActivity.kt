package udb.edu.sv

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import java.text.DecimalFormat

class PromedioActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_promedio)

        val nombre = findViewById<EditText>(R.id.txtNombre)
        val notas = listOf(
            findViewById<EditText>(R.id.txtNota1),
            findViewById<EditText>(R.id.txtNota2),
            findViewById<EditText>(R.id.txtNota3),
            findViewById<EditText>(R.id.txtNota4),
            findViewById<EditText>(R.id.txtNota5)
        )
        val btnCalcular = findViewById<Button>(R.id.btnCalcularPromedio)
        val resultado = findViewById<TextView>(R.id.txtResultado)

        btnCalcular.setOnClickListener {
            if (nombre.text.isEmpty()) {
                nombre.error = "Ingrese el nombre"
                return@setOnClickListener
            }

            val valores = notas.mapIndexed { index, editText ->
                val texto = editText.text.toString()
                if (texto.isEmpty()) {
                    editText.error = "Requerido"
                    return@setOnClickListener
                }
                val valor = texto.toDouble()
                if (valor !in 0.0..10.0) {
                    editText.error = "Valor fuera de rango"
                    return@setOnClickListener
                }
                valor
            }

            val promedio = valores.average()
            val df = DecimalFormat("0.00")
            val estado = if (promedio >= 6) "Aprobado" else "Reprobado"

            resultado.text = "${nombre.text}, Promedio: ${df.format(promedio)}, Estado: $estado"
        }
    }
}
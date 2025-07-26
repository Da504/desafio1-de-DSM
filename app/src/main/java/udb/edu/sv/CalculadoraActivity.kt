package udb.edu.sv

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.pow
import kotlin.math.sqrt

class CalculadoraActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculadora)

        val n1 = findViewById<EditText>(R.id.txtNum1)
        val n2 = findViewById<EditText>(R.id.txtNum2)
        val res = findViewById<TextView>(R.id.txtResultado)

        val suma = findViewById<Button>(R.id.btnSuma)
        val resta = findViewById<Button>(R.id.btnResta)
        val mult = findViewById<Button>(R.id.btnMultiplicacion)
        val div = findViewById<Button>(R.id.btnDivision)
        val exp = findViewById<Button>(R.id.btnExponente)
        val raiz = findViewById<Button>(R.id.btnRaiz)

        fun leerValores(): Pair<Double, Double?> {
            val a = n1.text.toString().toDoubleOrNull()
            val b = n2.text.toString().toDoubleOrNull()
            if (a == null) {
                n1.error = "Número requerido"
                return Pair(0.0, null)
            }
            return Pair(a, b)
        }

        suma.setOnClickListener {
            val (a, b) = leerValores()
            if (b != null) res.text = "Resultado: ${a + b}"
        }
        resta.setOnClickListener {
            val (a, b) = leerValores()
            if (b != null) res.text = "Resultado: ${a - b}"
        }
        mult.setOnClickListener {
            val (a, b) = leerValores()
            if (b != null) res.text = "Resultado: ${a * b}"
        }
        div.setOnClickListener {
            val (a, b) = leerValores()
            if (b == 0.0) res.text = "División por cero" else if (b != null) res.text = "Resultado: ${a / b}"
        }
        exp.setOnClickListener {
            val (a, b) = leerValores()
            if (b != null) res.text = "Resultado: ${a.pow(b)}"
        }
        raiz.setOnClickListener {
            val (a, _) = leerValores()
            res.text = "Resultado: ${sqrt(a)}"
        }
    }
}

package udb.edu.sv

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.btnPromedio).setOnClickListener {
            startActivity(Intent(this, PromedioActivity::class.java))
        }

        findViewById<Button>(R.id.btnSalario).setOnClickListener {
            startActivity(Intent(this, SalarioActivity::class.java))
        }

        findViewById<Button>(R.id.btnCalculadora).setOnClickListener {
            startActivity(Intent(this, CalculadoraActivity::class.java))
        }
    }
}
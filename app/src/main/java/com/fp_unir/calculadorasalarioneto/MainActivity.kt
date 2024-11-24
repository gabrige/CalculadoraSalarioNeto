package com.fp_unir.calculadorasalarioneto

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Referencias a los elementos de la interfaz
        val salarioBruto = findViewById<EditText>(R.id.salarioBruto)
        val numeroPagas = findViewById<EditText>(R.id.numeroPagas)
        val edad = findViewById<EditText>(R.id.edad)
        val numeroHijos = findViewById<EditText>(R.id.numeroHijos)
        val calcularButton = findViewById<Button>(R.id.calcularButton)

        calcularButton.setOnClickListener {
            // Validar que los campos no estén vacíos
            if (salarioBruto.text.isEmpty() || numeroPagas.text.isEmpty() || edad.text.isEmpty() || numeroHijos.text.isEmpty()) {
                Toast.makeText(this, "Por favor, llena todos los campos.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            try {
                // Obtener los valores ingresados y convertirlos a números
                val salario = salarioBruto.text.toString().toDouble()
                val pagas = numeroPagas.text.toString().toInt()
                val hijos = numeroHijos.text.toString().toInt()

                // Verificación para que el número de pagas sea mayor que 0
                if (pagas <= 0) {
                    Toast.makeText(this, "El número de pagas debe ser mayor que 0.", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }

                // Cálculos ficticios
                val retencionIRPF = salario * 0.15 // 15% de retención ficticia
                val deducciones = hijos * 500.0 // 500€ de deducción por hijo
                val salarioNeto = salario - retencionIRPF - deducciones

                // Pasar los datos a la siguiente actividad
                val intent = Intent(this, ResultActivity::class.java).apply {
                    putExtra("SALARIO_BRUTO", salario)
                    putExtra("SALARIO_NETO", salarioNeto)
                    putExtra("RETENCION_IRPF", retencionIRPF)
                    putExtra("DEDUCCIONES", deducciones)
                }
                startActivity(intent)
            } catch (e: NumberFormatException) {
                // Manejo de errores si no se pueden convertir los valores a números
                Toast.makeText(this, "Por favor, ingresa valores numéricos válidos.", Toast.LENGTH_SHORT).show()
            }
        }
    }
}

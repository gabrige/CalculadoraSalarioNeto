package com.fp_unir.calculadorasalarioneto

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        // Recuperar datos del Intent
        val salarioBruto = intent.getDoubleExtra("SALARIO_BRUTO", 0.0)
        val salarioNeto = intent.getDoubleExtra("SALARIO_NETO", 0.0)
        val retencionIRPF = intent.getDoubleExtra("RETENCION_IRPF", 0.0)
        val deducciones = intent.getDoubleExtra("DEDUCCIONES", 0.0)

        // Mostrar los resultados
        findViewById<TextView>(R.id.salarioBrutoText).text = "Salario Bruto: $salarioBruto €"
        findViewById<TextView>(R.id.salarioNetoText).text = "Salario Neto: $salarioNeto €"
        findViewById<TextView>(R.id.retencionIRPFText).text = "Retención IRPF: $retencionIRPF €"
        findViewById<TextView>(R.id.deduccionesText).text = "Deducciones: $deducciones €"
    }
}

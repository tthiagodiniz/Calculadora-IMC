package com.example.meuprimeiroprojeto_imc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Message
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        val Calcular_IMC: Button = findViewById(R.id.Calcular_IMC)
        val EdtPeso: EditText = findViewById(R.id.edittext_Peso)
        val Edtaltura: EditText = findViewById(R.id.edittext_Altura)


        Calcular_IMC.setOnClickListener {

            val altura_str = Edtaltura.text.toString()
            val peso_str = EdtPeso.text.toString()

            if (altura_str.isNotEmpty() && peso_str.isNotEmpty()) {
                val peso: Float = peso_str.toFloat()
                val altura: Float = altura_str.toFloat()
                val IMC: Float = peso / (altura * altura)

                val intent = Intent(this, ResultActivity::class.java)
                    .apply {
                        putExtra("Extra_Result", IMC)
                    }
                startActivity(intent)
            } else {
                Toast.makeText(this, "Preencher Todos os Campos", Toast.LENGTH_LONG).show()
            }
        }
    }
}

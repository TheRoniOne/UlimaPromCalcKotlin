package com.example.roni.ulimapromcalckotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val etInputTA : EditText = findViewById(R.id.etInputTA)
        val etInputEP : EditText = findViewById(R.id.etInputEP)
        val botonCalc : Button = findViewById(R.id.buttonCalcular)
        val tvResultado : TextView = findViewById(R.id.tvResultado)

        botonCalc.setOnClickListener {
            calcResult()
        }
    }

    private fun calcResult() {
        var notaTA = etInputTA.text.toString().toInt()
        var notaEP = etInputEP.text.toString().toInt()

        if ((notaTA in 0..20) && (notaEP in 0..20)){
            var resultado = (10.5f - ((0.3f * notaTA) + (0.3f * notaEP))) / 0.4f

            if (resultado > 0)
            {
                resultado += 1
            }

            var result : Int = resultado.toInt()

            tvResultado.text = result.toString()
        }

    }

}

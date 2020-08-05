package com.example.roni.ulimapromcalckotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    var eteInputTA : EditText? = null
    var eteInputEP : EditText? = null
    var butCalcular : Button? = null
    var tviResultado : TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        eteInputTA = findViewById(R.id.eteInputTA)
        eteInputEP = findViewById(R.id.eteInputEP)
        butCalcular = findViewById(R.id.butCalcular)
        tviResultado = findViewById(R.id.tvResultado)

    }

    fun calcResult(v : View) {
        try {
            val notaTA = eteInputTA!!.text.toString().toInt()
            val notaEP = eteInputEP!!.text.toString().toInt()

            if ((notaTA in 0..20) and (notaEP in 0..20)){
                var resultado = (10.5f - ((0.3f * notaTA) + (0.3f * notaEP))) / 0.4f

                if (resultado > 0)
                {
                    resultado += 1
                }

                val result : Int = resultado.toInt()
                tviResultado!!.text = result.toString()

            } else {
                val msjError = AlertDialog.Builder(this)

                msjError.setTitle("Ha ocurrido un problema")
                msjError.setMessage("Porfavor ingresa correctamente tu nota de TA y EP")
                msjError.setPositiveButton("Ok", null)
                msjError.show()
            }
        } catch (e : Exception){
            val msjError = AlertDialog.Builder(this)

            msjError.setTitle("Ha ocurrido un problema")
            msjError.setMessage("Porfavor ingresa correctamente tu nota de TA y EP")
            msjError.setPositiveButton("Ok", null)
            msjError.show()
        }

    }

}

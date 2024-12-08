package com.example.evaluable1

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.evaluable1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityMainBinding
    private var resultado: Int = 0
    private var operador: String = ""
    private var operando1: String = ""
    private var operando2: String = ""
    private var operadorSeleccionado: Boolean = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        resultado = savedInstanceState?.getInt("resultado") ?:0
        operando1 = savedInstanceState?.getString("operando1") ?:""
        binding.operandos.text = resultado.toString()
        binding.operandos
        binding.cos?.setOnClickListener(this)
        binding.raiz2?.setOnClickListener(this)
        binding.ac.setOnClickListener(this)
        binding.porcentaje.setOnClickListener(this)
        binding.division.setOnClickListener(this)
        binding.siete.setOnClickListener(this)
        binding.ocho.setOnClickListener(this)
        binding.nueve.setOnClickListener(this)
        binding.multiplicacion.setOnClickListener(this)
        binding.cuatro.setOnClickListener(this)
        binding.cinco.setOnClickListener(this)
        binding.seis.setOnClickListener(this)
        binding.uno.setOnClickListener(this)
        binding.menos.setOnClickListener(this)
        binding.dos.setOnClickListener(this)
        binding.tres.setOnClickListener(this)
        binding.mas.setOnClickListener(this)
        binding.cero.setOnClickListener(this)
        binding.igual.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            binding.raiz2?.id->{
                val numero = operando1.toDouble()
                resultado = calcularRaizCuadrada(numero).toInt()
                operando1 = resultado.toString()
                binding.operandos.text = resultado.toString()
            }

            binding.cos?.id->{
                val numero = operando1.toDouble()
                resultado = calcularCoseno(numero).toInt()
                operando1 = resultado.toString()
                binding.operandos.text = resultado.toString()
            }

            binding.ac.id -> {
                operando1 = ""
                operando2 = ""
                operador = ""
                operadorSeleccionado = false
                binding.operandos.text = "0"
            }

            binding.cero.id, binding.uno.id, binding.dos.id, binding.tres.id,
            binding.cuatro.id, binding.cinco.id, binding.seis.id,
            binding.siete.id, binding.ocho.id, binding.nueve.id -> {
                val numero = (p0 as Button).text.toString()
                if (!operadorSeleccionado) {
                    operando1 += numero
                    binding.operandos.text = operando1
                } else {
                    operando2 += numero
                    binding.operandos.text = operando2
                }
            }

            binding.mas.id, binding.menos.id, binding.division.id, binding.multiplicacion.id -> {
                operador = (p0 as Button).text.toString()
                operadorSeleccionado = true
            }

            binding.igual.id -> {
                resultado = calcular(operando1.toInt(), operando2.toInt(), operador)
                operando1 = resultado.toString()
                operando2 = ""
                binding.operandos.text = resultado.toString()
                operadorSeleccionado = false
            }
        }
    }

    private fun calcular(operando1: Int, operando2: Int, operador: String): Int {
        var resultado: Int = 0
        if (operador == "+") {
            resultado = operando1 + operando2
        }
        if (operador == "-") {
            resultado = operando1 - operando2
        }
        if (operador == "X") {
            resultado = operando1 * operando2
        }
        if (operador == "/") {
            resultado = operando1 / operando2
        }
        return resultado
    }

    fun calcularRaizCuadrada(numero: Double): Double {
        return Math.sqrt(numero)
    }

    fun calcularCoseno(grados: Double): Double {
        val radianes = Math.toRadians(grados)
        return Math.cos(radianes)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("resultado", resultado)
        outState.putString("operando1", operando1)
    }
}

package com.example.pdm123.firstpartial

import android.content.Context
import android.widget.Toast
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class ApplesViewModel : ViewModel() {
    val actualtotal= mutableStateOf(0)
    val actualproduccion = mutableStateOf(0)
    val porcentaje = mutableStateOf(0f)

    val totalProduccion: State<Int> = actualtotal
    val actualProduccion: State<Int> = actualproduccion

    val estado= mutableStateOf<UIState>(UIState.Idle)

    fun add(numero : Int){
        if (estado.value == UIState.Idle) {
            estado.value = UIState.Adding5
            actualproduccion.value += numero
            calculatePercentage(totalProduccion.value, actualproduccion.value)
            estado.value = UIState.Idle
        }
    }

    fun calculatePercentage(total: Int, actual: Int) {
        if (estado.value == UIState.Idle) {
            estado.value = UIState.CalculatingPercentage
            if (total != 0) {
                val calculatedPercentage = (actual.toFloat() / total.toFloat()) * 100
                porcentaje.value = calculatedPercentage
                println("Calculated Percentage: $calculatedPercentage")
            }

            if (porcentaje.value >= 70){

            }
            estado.value = UIState.Idle
        }
    }

    fun calculateTotalProdToast(context: Context) {
        if (estado.value == UIState.Idle) {
            estado.value = UIState.CalculatingTotalProdToast
            val total = totalProduccion.value
            val result = total * 80
            val toastMessage = "$result manzanas"
            Toast.makeText(context, toastMessage, Toast.LENGTH_SHORT).show()
            estado.value = UIState.Idle
        }
    }

    fun calculateActualProdToast(context: Context) {
        if (estado.value == UIState.Idle) {
            estado.value = UIState.CalculatingActualProdToast
            val actual = actualproduccion.value
            val result = actual * 80
            val toastMessage = "$result manzanas"
            Toast.makeText(context, toastMessage, Toast.LENGTH_SHORT).show()
            estado.value = UIState.Idle
        }
    }
}

sealed class UIState {
    object Idle : UIState()
    object Adding5 : UIState()
    object Adding15 : UIState()
    object Adding30 : UIState()
    object Adding50 : UIState()
    object CalculatingPercentage : UIState()
    object CalculatingTotalProdToast : UIState()
    object CalculatingActualProdToast : UIState()
}
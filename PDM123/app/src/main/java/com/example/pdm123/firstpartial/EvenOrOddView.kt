package com.example.pdm123.firstpartial

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.*
import androidx.compose.material.TextField
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.navigation.NavController
import com.example.pdm123.R
import com.example.pdm123.ui.theme.utils.ComposeLottieAnimationEven
import androidx.compose.ui.unit.dp
import com.example.pdm123.ui.theme.utils.ComposeLottieAnimationOdd


@Composable
fun EvenOddView(navController: NavController, viewModel: EvenOddViewModel) {
    // Esta variable va a almacenar el valor de la caja de texto

    var txtNumber by remember { mutableStateOf("") }
    val evenOddState by viewModel.getResultStatus().observeAsState(R.string.number)

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        if (viewModel.getBooleanState().value == true) {
            ComposeLottieAnimationEven(
                modifier = Modifier
                    .width(150.dp)
                    .height(150.dp)
            )
        } else {
            ComposeLottieAnimationOdd(modifier = Modifier
                .width(150.dp)
                .height(150.dp))
        }
        Text(text = stringResource(id = R.string.even_or_odd))

        TextField(
            value = txtNumber,
            onValueChange = {
                txtNumber = it

                // Verificar si el valor es un número entero o no

                if (txtNumber != "") {
                    viewModel.calculateEvenOdd(txtNumber.toInt())
                    viewModel.getBooleanState()
                }
//                else if (newValue.isEmpty()) {
//                    // Mostrar un mensaje si el TextField está vacío
//                    viewModel.calculateEvenOdd()
//                } else {
//                    // Mostrar un mensaje de error si no es un número entero
//                    viewModel.calculateEvenOdd()
//                }
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )

        // Mostrar mensajes en función del estado

        Text(text = stringResource(id = evenOddState))

    }
}
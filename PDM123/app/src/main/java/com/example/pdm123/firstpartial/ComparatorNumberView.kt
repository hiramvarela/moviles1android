package com.example.pdm123.firstpartial


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.navigation.NavController
import com.example.pdm123.R

@Composable
fun NumberComparatorView(viewModel: NumberComparatorViewModel,navController: NavController) {
    var number1 by remember { mutableStateOf("") }
    var number2 by remember { mutableStateOf("") }
    var number3 by remember { mutableStateOf("") }
    val compareState by viewModel.getResult().observeAsState(0)

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = stringResource(id = R.string.typenumbers))
        TextField(
            value = number1,
            onValueChange = { newValue -> number1 = newValue },
            label = { Text(stringResource(id = R.string.num1)) },
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number)
        )

        TextField(
            value = number2,
            onValueChange = { newValue -> number2 = newValue },
            label = { Text(stringResource(id = R.string.num2)) },
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number)
        )

        TextField(
            value = number3,
            onValueChange = { newValue -> number3 = newValue },
            label = { Text(stringResource(id = R.string.num3)) },
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number)
        )

        Button(
            onClick = {
                val num1 = number1.toInt()
                val num2 = number2.toInt()
                val num3 = number3.toInt()
                viewModel.compareNumbers(NumberComparator(num1, num2, num3))
            }
        ) {
            Text(stringResource(id = R.string.comparator))
        }

        Text(text = stringResource(id = R.string.min)+"${compareState}")
    }
}
package com.example.pdm123.firstpartial

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.*
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.pdm123.R
import androidx.compose.runtime.*
import androidx.compose.foundation.background
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController

@Composable
fun ApplesView(navController: NavController, viewModel: ApplesViewModel) {
    val totalproducto by viewModel.totalProduccion
    val actualproducto by viewModel.actualProduccion
    val porcentaje by viewModel.porcentaje
    val contexto = LocalContext.current


    var backgroundColor by remember { mutableStateOf(Color.Transparent) }



    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(50.dp))
        Row(
            horizontalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.rejas_manzanas),
                contentDescription = "Manzanas"
            )

            Spacer(
                modifier = Modifier

                    .height(200.dp)
            )
        }
        Spacer(modifier = Modifier.height(25.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentSize(Alignment.Center),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = stringResource(id = R.string.total_production),
                modifier = Modifier.padding(15.dp)
            )

            TextField(
                value = viewModel.actualtotal.value.toString(),
                onValueChange = { viewModel.actualtotal.value = it.toIntOrNull() ?: 0 },
                keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
                modifier = Modifier
                    .width(100.dp)
                    .height(49.dp)


            )


            Spacer(
                modifier = Modifier.width(15.dp)
            )

            Image(
                painter = painterResource(id = R.drawable.manzanas),
                contentDescription = "Manzana",
                modifier = Modifier
                    .height(50.dp)
                    .width(50.dp)
                    .clickable {
                        viewModel.calculateTotalProdToast(contexto)
                    }
            )

        }
        Spacer(modifier = Modifier.height(25.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentSize(Alignment.Center),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = stringResource(id = R.string.actual_production),
                modifier = Modifier.padding(15.dp)
            )
            TextField(
                value = viewModel.actualproduccion.value.toString(),
                onValueChange = {
                    viewModel.actualproduccion.value = it.toIntOrNull() ?: 0
                },
                modifier = Modifier
                    .width(100.dp)
                    .height(49.dp),
                enabled = false
            )
            Spacer(
                modifier = Modifier.width(20.dp)
            )
            Image(
                painter = painterResource(id = R.drawable.manzanas),
                contentDescription = "Manzana",
                modifier = Modifier
                    .height(50.dp)
                    .width(50.dp)
                    .clickable {
                        viewModel.calculateActualProdToast(contexto)
                    }
            )
        }
        Spacer(modifier = Modifier.height(25.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentSize(Alignment.Center),
            horizontalArrangement = Arrangement.Center
        ) {
            Button(
                onClick = { viewModel.add(5) },
            ) {
                Text(text = "+5")
            }
            Spacer(modifier = Modifier.width(16.dp))
            Button(onClick = { viewModel.add(15) }) {
                Text(text = "+15")
            }
            Spacer(modifier = Modifier.width(16.dp))
            Button(onClick = { viewModel.add(30) }) {
                Text(text = "+30")
            }
            Spacer(modifier = Modifier.width(16.dp))
            Button(onClick = { viewModel.add(50) }) {
                Text(text = "+50")
            }
        }
        Spacer(modifier = Modifier.height(50.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentSize(Alignment.Center),
            horizontalArrangement = Arrangement.Center
        ) {
            Spacer(modifier = Modifier.height(50.dp))
            Text(
                text = stringResource(id = R.string.percetage),
                modifier = Modifier.padding(15.dp)
            )
            Text(text = "${porcentaje}", modifier = Modifier.padding(15.dp))
            Spacer(modifier = Modifier.height(50.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentSize(Alignment.Center),
                horizontalArrangement = Arrangement.Center
            ) {
                Button(onClick = { viewModel.calculatePercentage(totalproducto, actualproducto) }) {
                    Text(text = "Calcular")
                }
                if (porcentaje > 70) {
                    backgroundColor = Color.Red
                }
            }
        }
    }
}
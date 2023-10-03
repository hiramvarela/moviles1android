package com.example.pdm123.secondpartial

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.compose.ui.res.stringResource
import com.example.pdm123.R

@Composable
fun SecondPartialView(navController:NavController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center


    ) {
        Text(
            text = stringResource(id = R.string.second_partial),
            color = MaterialTheme.colorScheme.primary
        )
        Button(onClick = {navController.navigate(route = "Qr")}) {
            Text(text = "QR")
        }
        Button(onClick = {navController.navigate(route = "Lists")}) {
            Text(text = stringResource(id = R.string.lists))
        }

    }
}
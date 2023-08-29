package com.example.pdm123.firstpartial

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import com.example.pdm123.R

@Composable
fun FirstPartialView(navController : NavController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center


        ) {
        Text(
            text = stringResource(id = R.string.first_partial),
            color = MaterialTheme.colorScheme.primary
        )
        Button(onClick = {navController.navigate(route = "PadelScore")}) {
            Text(text = stringResource(id = R.string.padel_score))
        }
        Button(onClick = {navController.navigate(route = "EvenOrOdd")}) {
            Text(text = stringResource(id = R.string.even_or_odd))
        }
    }
}
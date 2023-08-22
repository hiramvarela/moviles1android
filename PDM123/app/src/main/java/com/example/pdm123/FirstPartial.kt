package com.example.pdm123

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun FirstPartial() {
    Box(modifier = Modifier.fillMaxSize()
    ){
        Text(text = "Primer parcial")
    }
}
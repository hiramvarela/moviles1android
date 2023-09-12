package com.example.pdm123.firstpartial


import androidx.compose.foundation.Image
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.pdm123.R
import kotlin.random.Random


@Composable
fun CardsView(navController: NavController, viewModel: CardsViewModel) {
    // Observa el estado del ViewModel
    val showImage by viewModel.showImage.observeAsState(true)


    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        if (showImage) {
            BackImage(viewModel.cardImageResId)
        }

        Row {
            Button(onClick = {
                // Cuando se presiona el botón "Voltear carta", mostramos la imagen
                viewModel.showImage.value = true
                viewModel.cardImageResId = R.drawable.back
            }, modifier = Modifier.padding(8.dp)) {
                Text(text = stringResource(id = R.string.flip))
            }
            Button(onClick = {
                // Cuando se presiona el botón "Carta al azar", mostramos una carta al azar
                val randomNumber = Random.nextInt(1, 14)
                when (randomNumber) {
                    1 -> viewModel.cardImageResId = R.drawable.a
                    2 -> viewModel.cardImageResId = R.drawable.h2
                    3 -> viewModel.cardImageResId = R.drawable.h3
                    4 -> viewModel.cardImageResId = R.drawable.h4
                    5 -> viewModel.cardImageResId = R.drawable.h5
                    6 -> viewModel.cardImageResId = R.drawable.h6
                    7 -> viewModel.cardImageResId = R.drawable.h7
                    8 -> viewModel.cardImageResId = R.drawable.h8
                    9 -> viewModel.cardImageResId = R.drawable.h9
                    10 -> viewModel.cardImageResId = R.drawable.h10
                    11 -> viewModel.cardImageResId = R.drawable.j
                    12 -> viewModel.cardImageResId = R.drawable.q
                    13 -> viewModel.cardImageResId = R.drawable.k


                }
                viewModel.showImage.value = true
            }, modifier = Modifier.padding(8.dp)) {
                Text(text = stringResource(id = R.string.random))
            }
        }
    }
}

@Composable
fun BackImage(imageResId: Int) {
    Image(
        painter = painterResource(id = imageResId),
        contentDescription = "back",
        modifier = Modifier.size(400.dp)
    )
}


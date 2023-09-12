package com.example.pdm123.firstpartial

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.pdm123.R

@Composable
fun SalonView(navController: NavController, viewModel: SalonViewModel) {
//    val total by viewModel.getTotal().observeAsState(0.0)


    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,

        ) {
        Row {
            Button(onClick = {


            }, modifier = Modifier.padding(8.dp)) {
                Image(
                    painter = painterResource(id = R.drawable.barba),
                    contentDescription = "barba",
                    modifier = Modifier
                        .width(70.dp)
                        .height(70.dp)
                )
            }
            Button(onClick = {
            }, modifier = Modifier.padding(8.dp)) {
                Image(
                    painter = painterResource(id = R.drawable.corte),
                    contentDescription = "corte",
                    modifier = Modifier
                        .width(70.dp)
                        .height(70.dp)
                )
            }
            Button(onClick = {
//                viewModel.getBackCards()
            }, modifier = Modifier.padding(8.dp)) {
                Image(
                    painter = painterResource(id = R.drawable.corteybarba),
                    contentDescription = "corte y barba",
                    modifier = Modifier
                        .width(70.dp)
                        .height(70.dp)
                )
            }


        }
        Row {


            Text(text = "0")

            Spacer(modifier = Modifier.width(125.dp))


            Text(text = "0")


            Spacer(modifier = Modifier.width(125.dp))

            Text(text = "0")


        }
        Spacer(modifier = Modifier.height(50.dp))
        Row {
            Text(text = "Total")
        }
        Row {
//            Text(text = total.toString())
        }
    }
}
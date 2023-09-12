package com.example.pdm123.firstpartial


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.pdm123.R
import kotlin.random.Random

class CardsViewModel : ViewModel() {
    // Define dos estados para controlar la visibilidad de la imagen y la imagen de la carta

    val cardImageResId = MutableLiveData(R.drawable.back)

    fun getRandomImage(): MutableLiveData<Int> = cardImageResId
    fun getRandomCards() {
        val randomNumber = (1..13).random()
        when (randomNumber) {
            1 -> cardImageResId.postValue(R.drawable.a)
            2 -> cardImageResId.postValue(R.drawable.h2)
            3 -> cardImageResId.postValue(R.drawable.h3)
            4 -> cardImageResId.postValue(R.drawable.h4)
            5 -> cardImageResId.postValue(R.drawable.h5)
            6 -> cardImageResId.postValue(R.drawable.h6)
            7 -> cardImageResId.postValue(R.drawable.h7)
            8 -> cardImageResId.postValue(R.drawable.h8)
            9 -> cardImageResId.postValue(R.drawable.h9)
            10 -> cardImageResId.postValue(R.drawable.h10)
            11 -> cardImageResId.postValue(R.drawable.j)
            12 -> cardImageResId.postValue(R.drawable.q)
            13 -> cardImageResId.postValue(R.drawable.k)
        }
    }

    fun getBackCards() {
        cardImageResId.postValue(R.drawable.back)
    }


}




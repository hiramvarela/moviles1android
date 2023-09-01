package com.example.pdm123.firstpartial


import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.pdm123.R
class CardsViewModel : ViewModel() {
    // Define dos estados para controlar la visibilidad de la imagen y la imagen de la carta
    var showImage = MutableLiveData<Boolean>()
    var cardImageResId by mutableStateOf(R.drawable.back)


}
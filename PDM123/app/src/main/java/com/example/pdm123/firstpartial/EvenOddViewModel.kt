package com.example.pdm123.firstpartial

import androidx.compose.foundation.layout.width
import androidx.compose.ui.Modifier
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.pdm123.R
import com.example.pdm123.ui.theme.utils.ComposeLottieAnimationEven
import androidx.compose.ui.unit.dp
import com.example.pdm123.ui.theme.utils.ComposeLottieAnimationEven
import com.example.pdm123.ui.theme.utils.ComposeLottieAnimationOdd

class EvenOddViewModel : ViewModel() {
    var evenOrODDStatus = MutableLiveData<Int>()
    var showFirstImage = MutableLiveData<Boolean>(false)
    fun getResultStatus(): MutableLiveData<Int> = evenOrODDStatus
    fun getBooleanState(): MutableLiveData<Boolean> = showFirstImage

    fun calculateEvenOdd(number: Int) {
        if (number != 0) {
            if (number % 2 == 0) {
                evenOrODDStatus.postValue(R.string.even)
                showFirstImage.postValue(true)
            } else if (number % 2 == 1) {
                evenOrODDStatus.postValue(R.string.odd)
                showFirstImage.postValue(false)

            }
        }
        else {
            evenOrODDStatus.postValue(R.string.zero)
        }
    }
}
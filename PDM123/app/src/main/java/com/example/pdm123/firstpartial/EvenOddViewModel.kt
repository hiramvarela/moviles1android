package com.example.pdm123.firstpartial

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.pdm123.R


class EvenOddViewModel : ViewModel() {
    var evenOrODDStatus = MutableLiveData<Int>()
    fun getResultStatus(): MutableLiveData<Int> = evenOrODDStatus

    fun calculateEvenOdd(number: Int) {
        if (number != 0) {
            if (number % 2 == 0) {
                evenOrODDStatus.postValue(R.string.even)
            } else if (number % 2 == 1) {
                evenOrODDStatus.postValue(R.string.odd)
            }
        }
        else {
            evenOrODDStatus.postValue(R.string.zero)
        }
    }
}
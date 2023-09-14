package com.example.pdm123.firstpartial

import androidx.compose.runtime.*
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.pdm123.R

data class NumberComparator(val number1: Int, val number2: Int, val number3: Int)

class NumberComparatorViewModel : ViewModel() {
    var resultMessage = MutableLiveData<Int>()

    fun getResult():LiveData<Int> = resultMessage
    fun compareNumbers(numberComparator: NumberComparator) {
        val number1 = numberComparator.number1
        val number2 = numberComparator.number2
        val number3 = numberComparator.number3
        if (number1 != number2 && number2 != number3 && number1 != number3) {
            val numbers = listOf(number1, number2, number3)
            val sortedNumbers = numbers.sorted()
            resultMessage.postValue(sortedNumbers[0])
        } else {
            resultMessage.postValue(R.string.type3numbers)
        }
    }
}
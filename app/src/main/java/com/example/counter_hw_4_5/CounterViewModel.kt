package com.example.counter_hw_4_5

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CounterViewModel : ViewModel() {
    val counter = MutableLiveData<CounterModel>()

    fun increment() {
        val count = counter.value?.count?: 0
        counter.value = CounterModel(count.plus(1))
    }

    fun decrement() {
        val count = counter.value?.count?: 0
        counter.value = CounterModel(count.minus(1))
    }

    fun reset() {
        counter.value = CounterModel(0)
    }
}
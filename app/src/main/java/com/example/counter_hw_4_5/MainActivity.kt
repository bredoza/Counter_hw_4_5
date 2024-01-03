package com.example.counter_hw_4_5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.counter_hw_4_5.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var counterViewModel: CounterViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        counterViewModel = ViewModelProvider(this)[CounterViewModel::class.java]

        binding.btnIncrement.setOnClickListener {
            counterViewModel.increment()
            updateCounter()
        }

        binding.btnDecrement.setOnClickListener {
            counterViewModel.decrement()
            updateCounter()
        }

        binding.btnReset.setOnClickListener {
            counterViewModel.reset()
            updateCounter()
        }
    }

    private fun updateCounter() {
        binding.tvCount.text = counterViewModel.counter.value?.count.toString()
    }
}
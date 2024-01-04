package com.example.counter_hw_4_5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
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
        }

        binding.btnDecrement.setOnClickListener {
            counterViewModel.decrement()
        }

        binding.btnReset.setOnClickListener {
            counterViewModel.reset()
        }

        counterViewModel.count.observe(this, Observer { count ->
            binding.tvCount.text = count.toString()
        })
    }
}
package com.example.beerlist.views

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.*
import com.example.beerlist.adapter.MainAdapter
import com.example.beerlist.databinding.ActivityMainBinding
import com.example.beerlist.models.MainRepository
import com.example.beerlist.network.ApiInterface
import com.example.beerlist.viewmodels.MainViewModel
import com.example.beerlist.viewmodels.ViewModelFactory

class MainActivity : AppCompatActivity(),LifecycleOwner {
        private lateinit var binding: ActivityMainBinding
        private lateinit var viewModel: MainViewModel
        private val api = ApiInterface.fetchApi()
        private val adapter = MainAdapter()

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            binding = ActivityMainBinding.inflate(layoutInflater)
            setContentView(binding.root)

            viewModel = ViewModelProvider(this, ViewModelFactory(MainRepository(api))).get(MainViewModel::class.java)
            viewModel.getAllBeers()
            binding.recyclerViewMain.adapter = adapter

            viewModel.beerList.observe(this, Observer {
                adapter.setBeerList(it)
            })
            viewModel.errorMessage.observe(this, Observer {})
        }
    }
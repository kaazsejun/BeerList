package com.example.beerlist.views

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.*
import com.example.beerlist.R
import com.example.beerlist.databinding.ActivityMainBinding
import com.example.beerlist.models.MainRepository
import com.example.beerlist.network.ApiInterface
import com.example.beerlist.viewmodels.MainViewModel
import com.example.beerlist.viewmodels.ViewModelFactory
import com.example.productlist.mainAdapter

class MainActivity : AppCompatActivity(),LifecycleOwner {
        private lateinit var binding: ActivityMainBinding

        lateinit var viewModel: MainViewModel

        private val api = ApiInterface.fetchApi()
        private val adapter = mainAdapter()

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
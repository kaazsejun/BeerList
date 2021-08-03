package com.example.beerlist.models
import com.example.beerlist.network.ApiInterface

class MainRepository(private val apiInterface: ApiInterface) {
    fun getBeers() = apiInterface.getBeers()
}
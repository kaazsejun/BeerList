package com.example.beerlist.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.beerlist.models.Beer
import com.example.beerlist.models.MainRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainViewModel constructor(private val repository: MainRepository)  : ViewModel() {

    val beerList = MutableLiveData<List<Beer>>()
    val errorMessage = MutableLiveData<String>()
    fun getAllBeers() {
        val response = repository.getBeers()
        response?.enqueue(object : Callback<List<Beer>> {
            override fun onResponse(call: Call<List<Beer>>, response: Response<List<Beer>>) {
                beerList.postValue(response.body())
            }
            override fun onFailure(call: Call<List<Beer>>, t: Throwable) {
                errorMessage.postValue(t.message)
            }
        })
    }

}
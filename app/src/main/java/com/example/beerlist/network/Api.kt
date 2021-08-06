package com.example.beerlist.network

import com.example.beerlist.models.Beer
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
interface ApiInterface {
    @GET("v2/beers")
    fun getBeers():Call<List<Beer>>

    companion object {
        var baseurl: String = "https://api.punkapi.com/"
        var api: ApiInterface? = null
        fun fetchApi() : ApiInterface {
            if (api == null) {
                val logging = HttpLoggingInterceptor()
                logging.setLevel(HttpLoggingInterceptor.Level.BASIC)
                val httpclient: OkHttpClient = OkHttpClient.Builder()
                    .addInterceptor(logging)
                    .build()
                val retrofit = Retrofit.Builder()
                    .baseUrl(baseurl)
                    .client(httpclient)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                api = retrofit.create(ApiInterface::class.java)
            }
            return api!!
        }
    }
}
package com.example.beerlist.models

import androidx.databinding.BaseObservable

data class Beer(val id: Int?, val name:String?, val tagline:String?, val image_url:String?, val description:String?, val brewers_tips:String?):BaseObservable()


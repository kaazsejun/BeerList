package com.example.beerlist.views

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.beerlist.databinding.ActivityDetailsBinding
import kotlinx.android.synthetic.main.activity_details.*

class DetailsActivity: AppCompatActivity() {
    private lateinit var binding: ActivityDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val beerName= intent.getStringExtra("name")
        val beerImageUrl= intent.getStringExtra("image_url")
        val beerDescription= intent.getStringExtra("description")
        val beerBrewTips= intent.getStringExtra("brew_tips")
        supportActionBar?.title = beerName
        Glide.with(beerImageView.context).load(beerImageUrl).into(beerImageView);
        descriptionView?.text = beerDescription
        tipsView?.text=beerBrewTips
    }
}
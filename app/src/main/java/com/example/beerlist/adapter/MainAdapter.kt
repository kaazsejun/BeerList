package com.example.beerlist.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.children
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.beerlist.R
import com.example.beerlist.models.Beer
import com.example.beerlist.databinding.ProductslayoutBinding
import com.example.beerlist.views.DetailsActivity


class MainAdapter(): RecyclerView.Adapter<CustomViewHolder>() {

    var beers = mutableListOf<Beer>()
    override fun getItemCount(): Int {
        return beers.size
    }
    fun setBeerList(beers: List<Beer>) {
        this.beers = beers.toMutableList()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ProductslayoutBinding.inflate(layoutInflater,parent,false)
        return CustomViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        val beer = beers[position]
        holder.beer = beer
        holder.bind.nameView?.text = beer.name
        holder.bind.tagline.text = beer.tagline
        Glide.with(holder.bind.imageView.context).load(beer.image_url).into(holder.bind.imageView);
    }
}
class CustomViewHolder(val bind: ProductslayoutBinding, var beer: Beer? = null): RecyclerView.ViewHolder(bind.root){
    init {
        bind.root.setOnClickListener{
            val intent= Intent(bind.root.context, DetailsActivity::class.java)
            intent.putExtra("name",beer?.name)
            intent.putExtra("image_url",beer?.image_url)
            intent.putExtra("description",beer?.description)
            intent.putExtra("brew_tips",beer?.brewers_tips)
            bind.root.context.startActivity(intent)
        }
    }
}
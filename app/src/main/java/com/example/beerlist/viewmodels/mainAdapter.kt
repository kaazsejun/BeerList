package com.example.productlist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.beerlist.models.Beer
import com.example.beerlist.databinding.ProductslayoutBinding


class mainAdapter(): RecyclerView.Adapter<CustomViewHolder>() {

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
        holder.view.nameView?.text = beer.name
        holder.view.tagline.text = beer.tagline
        Glide.with(holder.view.imageView.context).load(beer.image_url).into(holder.view.imageView);
        holder.beer = beer
    }
}
class CustomViewHolder(val view: ProductslayoutBinding, var beer: Beer? = null): RecyclerView.ViewHolder(view.root){
    /*init {
        view.root.setOnClickListener{
        val intent= Intent(view.root.context, DetailsActivity::class.java)
         intent.putExtra("name",beer?.name)
            intent.putExtra("image_url",beer?.image_url)
         intent.putExtra("description",beer?.description)
         intent.putExtra("brew_tips",beer?.brewers_tips)
         view.root.context.startActivity(intent)
      }
    }*/
}
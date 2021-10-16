package com.example.pizzaapp.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.pizzaapp.R
import com.smarteist.autoimageslider.SliderViewAdapter

class SliderAdapter(val imageArray:List<String>): SliderViewAdapter<SliderAdapter.SliderViewHolder>() {


    override fun getCount(): Int {
        return imageArray.size
    }

    override fun onCreateViewHolder(parent: ViewGroup?): SliderViewHolder {
        val view: View =
            LayoutInflater.from(parent?.context).inflate(R.layout.image_slider_layout,parent,false)
        return SliderViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: SliderViewHolder?, position: Int) {
        if (viewHolder != null) {
            Glide.with(viewHolder.imageView).load(imageArray[position]).into(viewHolder.imageView)
        }
    }

    class SliderViewHolder(itemView: View): SliderViewAdapter.ViewHolder(itemView){

        val imageView: ImageView =itemView.findViewById(R.id.image_view)

    }

}

package com.example.nasaapp.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.nasaapp.R

class FavoriteMarsPhotoAdapter(
    private val context: Context,
    private val url: String
): RecyclerView.Adapter<FavoriteMarsPhotoAdapter.PhotoHolder>() {

    class PhotoHolder(view: View):RecyclerView.ViewHolder(view) {

        val imageView: ImageView = view.findViewById(R.id.image_view_item)

    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): PhotoHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.horizontal_recycler_view_item, viewGroup, false)

        return PhotoHolder(view)
    }

    override fun onBindViewHolder(holder: PhotoHolder, position: Int) {

       setImage(context, url, holder.imageView)

    }

    override fun getItemCount(): Int {
        return 24
    }

    private fun setImage(context: Context, url: String, imageView: ImageView){
        Glide
            .with(context)
            .load(url)
            .centerCrop()
            .placeholder(R.drawable.ic_launcher_background)
            .into(imageView)
    }



}


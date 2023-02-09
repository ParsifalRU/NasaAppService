package com.example.nasaapp.ui.adapters

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.nasaapp.R
import com.example.nasaapp.network.models.ModelOpportunity

class NewMarsPhotoAdapter(private val context: Context, private val url: ModelOpportunity?):RecyclerView.Adapter<NewMarsPhotoAdapter.PhotoHolder>() {

        class PhotoHolder(view: View): RecyclerView.ViewHolder(view) {

            val imageView: ImageView = view.findViewById(R.id.vert_img_item)

        }

        override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): PhotoHolder {
            val view = LayoutInflater.from(viewGroup.context)
                .inflate(R.layout.vertical_recycler_view_item, viewGroup, false)

            return PhotoHolder(view)
        }

        override fun onBindViewHolder(holder: PhotoHolder, position: Int) {
            Log.d("LOGTAG","onBindViewHolder $position" )
            if (url!=null){
                setImage(context, url.photos[position].img_src.toString(), holder.imageView)
                Log.d("LOGTAG", url.photos[position].img_src.toString())
            }else  setImage(context, "https://apod.nasa.gov/apod/image/2301/C2022E3ZTF_2023_01_23_054036PST_DEBartlett1024.jpg", holder.imageView)


        }

        override fun getItemCount(): Int {
            return 28
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
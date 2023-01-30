package com.example.nasaapp.ui.fragments.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.nasaapp.databinding.FragmentFavoritePhotoBinding
import com.example.nasaapp.ui.adapters.FavoriteMarsPhotoAdapter

class FragmentFavoritePhoto : Fragment() {

    private lateinit var binding: FragmentFavoritePhotoBinding
    private lateinit var adapter: FavoriteMarsPhotoAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d("LOGTAG", "FragmentFavoritePhoto Создался фрагмент")
        binding = FragmentFavoritePhotoBinding.inflate(inflater, container, false)

        setRecyclerView()

        return binding.root

    }

    private fun setRecyclerView(){
        val linearLayoutManager = LinearLayoutManager(activity?.baseContext, LinearLayoutManager.HORIZONTAL, false)
        binding.recyclerViewHorizontal.layoutManager = linearLayoutManager
        adapter = FavoriteMarsPhotoAdapter(
            requireActivity().baseContext,
            "https://apod.nasa.gov/apod/image/2301/crtastro_0172_2194p.jpg"
        )
        binding.recyclerViewHorizontal.adapter = adapter
    }

}
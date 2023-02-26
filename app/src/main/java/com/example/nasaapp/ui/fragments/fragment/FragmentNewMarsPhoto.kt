package com.example.nasaapp.ui.fragments.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.nasaapp.databinding.MarsPhotoNewBinding
import com.example.nasaapp.db.model.MarsPhoto
import com.example.nasaapp.network.api.NasaApp
import com.example.nasaapp.network.models.ModelOpportunity
import com.example.nasaapp.ui.adapters.NewMarsPhotoAdapter
import com.example.nasaapp.ui.fragments.view_model.ViewModelNewMarsPhoto


class FragmentNewMarsPhoto : Fragment() {
    private lateinit var adapter: NewMarsPhotoAdapter
    private lateinit var binding: MarsPhotoNewBinding
    private lateinit var viewModel: ViewModelNewMarsPhoto

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = MarsPhotoNewBinding.inflate(inflater, container, false)
        setVerticalRecyclerView()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        takeViewModel()
        takeResponse()
        setButton()
        super.onViewCreated(view, savedInstanceState)
    }

    private fun setVerticalRecyclerView(){
        val gridLayoutManager = GridLayoutManager(activity?.baseContext, 4, GridLayoutManager.VERTICAL, false)
        binding.vertRecyclerView.layoutManager = gridLayoutManager
        setAdapter(null)
        binding.vertRecyclerView.adapter = adapter
    }

    private fun setAdapter(url:ModelOpportunity?) {
        adapter = NewMarsPhotoAdapter(
            requireActivity().baseContext,
            url
        )
    }

    private fun takeResponse(){
        takeViewModel()
        viewModel.liveDataNewMarsPhoto.observe(viewLifecycleOwner){
            vmData -> setAdapter(vmData)
            binding.vertRecyclerView.adapter = adapter
        }
    }

    private fun setButton(){
        binding.loadBtn.setOnClickListener {
            takeViewModel()
        }
    }

    private fun takeViewModel(){
        viewModel = ViewModelProvider(this)[ViewModelNewMarsPhoto::class.java]
        viewModel.getCuriosityMarsPhotosFromEarthDate((activity?.application as NasaApp).nasaPhotoApi)
    }
}
package com.example.nasaapp.ui.fragments.fragment
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.nasaapp.R
import com.example.nasaapp.databinding.FragmentPictureOfTheDayBinding
import com.example.nasaapp.db.model.PictureOfTheDay
import com.example.nasaapp.network.api.NasaApp
import com.example.nasaapp.network.models.ModelOpportunity
import com.example.nasaapp.network.models.ModelPictOfTheDay
import com.example.nasaapp.ui.fragments.view_model.ViewModelPictureOfTheDay


class FragmentPictureOfTheDay() : Fragment() {

    lateinit var binding: FragmentPictureOfTheDayBinding
    private lateinit var viewModel: ViewModelPictureOfTheDay

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentPictureOfTheDayBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        takeResponse()
        super.onViewCreated(view, savedInstanceState)
    }


    private fun downloadImage(url: String?){
            Glide
                .with(this)
                .load(url)
                .centerCrop()
                .placeholder(R.drawable.ic_launcher_background)
                .into(binding.imageView)
        Log.d("LOGTAG","FragmentPictureOfTheDay $url")
    }

    private fun takeResponse(){
        viewModel = ViewModelProvider(this)[ViewModelPictureOfTheDay::class.java]
        viewModel.getMarsPhotos((activity?.application as NasaApp).nasaPhotoApi)
        viewModel.livedataPictureOfTheDay.observe(viewLifecycleOwner){vmData ->
            downloadImage(vmData[0].url)
            viewModel.insertPicture(transformationModel(vmData))
            viewModel.getAllPictures()
        }
    }

    private fun transformationModel(model1: List<ModelPictOfTheDay>): PictureOfTheDay{
        return PictureOfTheDay(
            1,
            model1[0].date,
            model1[0].explanation,
            model1[0].url,
            model1[0].media_type,
            model1[0].hdurl,
            model1[0].image,
            model1[0].service_version,
            model1[0].title
        )
    }
}
package com.example.nasaapp.ui.fragments.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.nasaapp.databinding.FragmentMainBinding


class FragmentMain : Fragment() {
    private lateinit var binding: FragmentMainBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(inflater, container, false)

/*        childFragmentManager.beginTransaction().add(R.id.imageView, FragmentMain()).commit()
        childFragmentManager.beginTransaction().add(R.id.textView, FragmentMain()).commit()
        childFragmentManager.beginTransaction().add(R.id.recyclerViewHorizontal, FragmentMain()).commit()*/



        return binding.root
    }

}
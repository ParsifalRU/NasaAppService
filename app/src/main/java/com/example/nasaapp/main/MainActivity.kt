package com.example.nasaapp.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.nasaapp.R
import com.example.nasaapp.ui.fragments.fragment.FragmentMain

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        hideActionBar()

        /*setFragment()*/

    }

    private fun setFragment(){
        supportFragmentManager.beginTransaction().replace(R.id.fragment1, FragmentMain()).commit()
    }

    private fun hideActionBar(){
        supportActionBar?.hide()
    }

}
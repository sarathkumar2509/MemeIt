package com.droid.memeit

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.droid.memeit.databinding.ActivityBaseBinding
import dagger.hilt.android.AndroidEntryPoint
import java.lang.Exception

@AndroidEntryPoint
class BaseActivity : AppCompatActivity() {

    private lateinit var binding : ActivityBaseBinding
    private lateinit var sharedPreferences: SharedPreferences


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBaseBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sharedPreferences = getSharedPreferences("data", Context.MODE_PRIVATE)


        //find fragment by Tag
        val navigation = (supportFragmentManager.findFragmentByTag("fragment_sheet_home") as NavHostFragment).findNavController()
        binding.bottomNavigationView.setupWithNavController(navigation)
    }

    override fun onDestroy() {
        sharedPreferences.edit().remove("data").commit()
        super.onDestroy()
    }
}
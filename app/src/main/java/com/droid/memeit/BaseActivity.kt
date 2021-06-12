package com.droid.memeit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.droid.memeit.databinding.ActivityBaseBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BaseActivity : AppCompatActivity() {

    private lateinit var binding : ActivityBaseBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBaseBinding.inflate(layoutInflater)
        setContentView(binding.root)


        //find fragment by Tag
        val navigation = (supportFragmentManager.findFragmentByTag("fragment_sheet_home") as NavHostFragment).findNavController()
        binding.bottomNavigationView.setupWithNavController(navigation)
    }
}
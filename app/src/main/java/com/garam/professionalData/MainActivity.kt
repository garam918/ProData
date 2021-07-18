package com.garam.professionalData

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.garam.professionalData.databinding.ActivityMainBinding
import com.garam.professionalData.viewModel.ProDataViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var proDataViewModel: ProDataViewModel
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        proDataViewModel = ViewModelProvider(this).get(ProDataViewModel::class.java)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.lifecycleOwner = this
        binding.viewModel = proDataViewModel

    }
}
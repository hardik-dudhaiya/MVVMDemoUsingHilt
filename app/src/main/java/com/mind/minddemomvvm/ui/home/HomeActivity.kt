package com.mind.minddemomvvm.ui.home

import android.os.Bundle
import com.mind.minddemomvvm.R
import com.mind.minddemomvvm.databinding.ActivityHomeBinding
import com.mind.minddemomvvm.ui.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : BaseActivity() {

    private val TAG = "HomeActivity"

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}
package com.mind.minddemomvvm.ui.splash

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.Window
import android.view.WindowInsets
import android.view.WindowManager
import com.mind.minddemomvvm.R
import com.mind.minddemomvvm.databinding.ActivitySplashBinding
import com.mind.minddemomvvm.ui.base.BaseActivity
import com.mind.minddemomvvm.ui.home.HomeActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashActivity : BaseActivity() {
    private val DELAY_TIME = 2000
    lateinit var binding: ActivitySplashBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)


        Handler(Looper.getMainLooper()).postDelayed({

                startActivity(Intent(this@SplashActivity, HomeActivity::class.java))
            finish()
        }, DELAY_TIME.toLong())
    }
}
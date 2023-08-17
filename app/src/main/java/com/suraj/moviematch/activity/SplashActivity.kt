package com.suraj.moviematch.activity

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.suraj.moviematch.R
import com.suraj.moviematch.databinding.ActivitySplashBinding
import android.content.Intent
import android.os.Handler
import io.github.inflationx.viewpump.ViewPumpContextWrapper

class SplashActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySplashBinding


    override fun attachBaseContext(newBase: Context?) {
        super.attachBaseContext(newBase?.let { ViewPumpContextWrapper.wrap(it) })
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val fadeInAnimation = android.view.animation.AnimationUtils.loadAnimation(this, R.anim.fade_in)
        binding.imageView.startAnimation(fadeInAnimation)
        binding.textView.startAnimation(fadeInAnimation)

        // Delay and start the main activity
        Handler().postDelayed({
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }, 2000) // 2 seconds delay
    }
}

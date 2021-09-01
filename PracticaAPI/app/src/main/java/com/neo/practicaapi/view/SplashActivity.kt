package com.neo.practicaapi.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.airbnb.lottie.LottieAnimationView
import com.neo.practicaapi.R

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val foto: LottieAnimationView = findViewById(R.id.imageView)
        foto.setAnimation(R.raw.splash)
        foto.playAnimation()
        foto.loop(true)
        Handler().postDelayed({
            startActivity(Intent(this, MainActivity::class.java))
            this.finish()
        },2000)
    }
}
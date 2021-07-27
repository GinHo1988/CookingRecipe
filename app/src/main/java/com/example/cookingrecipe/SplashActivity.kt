package com.example.cookingrecipe

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity

class SplashActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)





        Handler(Looper.getMainLooper()).postDelayed({
            //start main activity
            startActivity(Intent(this@SplashActivity, LoginActivity::class.java))
            //finish this activity
            finish()
        },3000)
    }
}


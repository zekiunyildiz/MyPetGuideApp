package com.example.mypetguideapp

import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import androidx.appcompat.app.AppCompatActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)




    }

    override fun onResume() {

        object : CountDownTimer(4000, 1000){
            override fun onFinish() {

                var intent = Intent(this@SplashActivity, MainActivity::class.java)
                startActivity(intent)

            }

            override fun onTick(p0: Long) {


            }



        }.start()


        super.onResume()
    }

    override fun onBackPressed() {
        System.exit(0)
    }

}
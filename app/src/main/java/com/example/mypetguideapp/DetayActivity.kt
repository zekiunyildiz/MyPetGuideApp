package com.example.mypetguideapp

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.palette.graphics.Palette
import kotlinx.android.synthetic.main.activity_detay.*

class DetayActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detay)

        var position = intent.extras?.get("tiklananOgePosition") as Int
        var tumHayvanBilgileri = intent.extras?.get("tumHayvanBilgileri") as ArrayList<Animal>

        tvHayvanOzellikleri.setText(tumHayvanBilgileri.get(position).animalGenelOzellikleri)
        header.setImageResource(tumHayvanBilgileri.get(position).animalBigPic)

        setSupportActionBar(anim_toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        collapsing_toolbar.title = tumHayvanBilgileri.get(position).AnimalName

        var bitmap = BitmapFactory.decodeResource(resources, tumHayvanBilgileri.get(position).animalBigPic)

        Palette.from(bitmap).generate(object : Palette.PaletteAsyncListener{
            override fun onGenerated(palette: Palette?){

                var color = palette?.getVibrantColor(R.attr.colorAccent)
                collapsing_toolbar.setContentScrimColor(color!!)
                window.statusBarColor=color
            }



        })

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()

        return super.onSupportNavigateUp()
    }

}
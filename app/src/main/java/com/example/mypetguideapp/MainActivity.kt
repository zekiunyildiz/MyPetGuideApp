package com.example.mypetguideapp

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ArrayAdapter
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_detay.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var tumHayvanBilgileri:ArrayList<Animal>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        veriKaynağiniHazirla()

        var myBaseAdapter = AnimalBaseAdapter(this, tumHayvanBilgileri)
        listAnimals.adapter =myBaseAdapter

        listAnimals.setOnItemClickListener { parent, view, position, id ->
            var intent = Intent(this@MainActivity, DetayActivity::class.java)
            intent.putExtra("tiklananOgePosition", position)
            intent.putExtra("tumHayvanBilgileri", tumHayvanBilgileri)
            startActivity(intent)
        }
    }
    private fun veriKaynağiniHazirla() {

        tumHayvanBilgileri = ArrayList<Animal>(14)

        var animals = resources.getStringArray(R.array.animals)
        var animalKinds = resources.getStringArray(R.array.animalKinds)
        var animalSymbol = arrayOf(R.drawable.vet13, R.drawable.barinak14,R.drawable.shih1, R.drawable.sasave2,R.drawable.americo3,R.drawable.papillon4,R.drawable.pug5,R.drawable.beagle6,R.drawable.mavirus7,
            R.drawable.irancat878,R.drawable.siyamcat9,R.drawable.scottish_10,R.drawable.ankarakedisi11,R.drawable.vankedisisisi)

        var animalBigPic = arrayOf(R.drawable.veterinerbig,R.drawable.barinakbig, R.drawable.bgshi, R.drawable.bg2, R.drawable.bg3, R.drawable.bg4, R.drawable.bg5, R.drawable.bg6, R.drawable.bg7, R.drawable.bg8,
            R.drawable.bg9, R.drawable.bg10, R.drawable.bg11, R.drawable.bg12)

        var animalGenelOzellikleri = resources.getStringArray(R.array.animalGenelOzellikleri)

        for (i in 0..13){
            var arraylisteAtanacakHayvanlar = Animal(animals[i], animalKinds[i], animalSymbol[i], animalBigPic[i], animalGenelOzellikleri[i])
            tumHayvanBilgileri.add(arraylisteAtanacakHayvanlar)
        }
    }



}
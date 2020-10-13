package com.example.mypetguideapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.tek_satir.view.*

/**
 * Created by ZekiUnyildiz on 9.10.20
 */

class AnimalArrayAdapter(
    var gelencontext: Context,
    resource: Int,
    textViewResourceId: Int,
    var animalNames: Array<String>,
    var animalKinds: Array<String>,
    var animalSymbol: Array<Int>)
    : ArrayAdapter<String>(gelencontext, resource, textViewResourceId, animalNames) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        var tek_satir_view = convertView
        var viewHolder:ViewHolder? = null

        if (tek_satir_view == null){

            val inflater = LayoutInflater.from(gelencontext)
            tek_satir_view = inflater.inflate(R.layout.tek_satir,parent,false)

            viewHolder = ViewHolder(tek_satir_view)
            tek_satir_view.tag = viewHolder

        }else{
            viewHolder = tek_satir_view.getTag() as ViewHolder

        }





        viewHolder.animalImg.setImageResource(animalSymbol[position])
        viewHolder.animalNames.setText(animalNames[position])
        viewHolder.animalKinds.setText(animalKinds[position])

        return tek_satir_view!!
    }

    class ViewHolder(tek_satir_view:View){

        var animalImg:ImageView
        var animalNames:TextView
        var animalKinds:TextView

        init {
            this.animalImg = tek_satir_view.imgAnimalSymbol
            this.animalNames = tek_satir_view.tvAnimalName
            this.animalKinds = tek_satir_view.tvAnimalKinds
        }


    }


}
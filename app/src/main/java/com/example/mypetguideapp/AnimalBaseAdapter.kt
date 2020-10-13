package com.example.mypetguideapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.tek_satir.view.*

class AnimalBaseAdapter(context: Context, tumHayvanBilgileri:ArrayList<Animal>):BaseAdapter() {

    var tumAnimals:ArrayList<Animal>
    var context:Context

    init {
        this.tumAnimals = tumHayvanBilgileri
        this.context=context


    }

    override fun getCount(): Int {
        return tumAnimals.size
    }

    override fun getItem(position: Int): Any {
        return tumAnimals.get(position)
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View? {
        var tek_satir_view = convertView
        var viewHolder:ViewHolder2

        if (tek_satir_view == null){
            var inflater = LayoutInflater.from(context)
            tek_satir_view = inflater.inflate(R.layout.tek_satir, parent, false)


            viewHolder = ViewHolder2(tek_satir_view)
            tek_satir_view.tag = viewHolder
        }else{
            viewHolder = tek_satir_view.getTag() as ViewHolder2
        }


            viewHolder.animalSymbol.setImageResource(tumAnimals.get(position).AnimalSymbol)
            viewHolder.animalName.setText(tumAnimals.get(position).AnimalName)
            viewHolder.animalKind.setText(tumAnimals.get(position).AnimalKinds)

        return tek_satir_view
    }
}


class ViewHolder2(tek_satir_view:View){

    var animalSymbol:ImageView
    var animalName:TextView
    var animalKind:TextView

    init {
        this.animalSymbol = tek_satir_view.imgAnimalSymbol
        this.animalName = tek_satir_view.tvAnimalName
        this.animalKind = tek_satir_view.tvAnimalKinds

    }
}
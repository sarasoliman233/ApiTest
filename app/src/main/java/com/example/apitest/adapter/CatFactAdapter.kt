package com.example.apitest.adapter

import CatData
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.apitest.R

class CatFactAdapter : RecyclerView.Adapter<CatFactAdapter.CatViewHolder>() {
    private var catData:ArrayList<CatData> = arrayListOf()
    private lateinit var context: Context
    inner class CatViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        var catNameView: TextView?=null
        var catImageView: ImageView?=null


        init {
            catNameView=itemView.findViewById(R.id.catName)
            catImageView=itemView.findViewById(R.id.catImage)

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatViewHolder {
        context=parent.context
        val layoutInflater=context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view =layoutInflater.inflate(R.layout.cat_row,parent,false)
        return CatViewHolder(view)
    }

    override fun getItemCount(): Int =catData.size

    override fun onBindViewHolder(holder: CatViewHolder, position: Int) {


      holder.catNameView?.text=catData[position].fact ?: "No Data found"


    }

    fun setDataSource(foodList: List<CatData>) {
        this.catData.clear()
        this.catData.addAll(foodList)
        notifyDataSetChanged()

    }

}
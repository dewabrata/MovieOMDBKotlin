package com.adl.ujiancrud.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.adl.movieomdb.R
import com.adl.movieomdb.model.OMDBResponse


class OMDBAdapter(val data:ArrayList<OMDBResponse>):RecyclerView.Adapter<OMDBViewHolder>() {
    lateinit var parent:ViewGroup
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OMDBViewHolder {
        this.parent = parent

        return OMDBViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_movie,parent,false))
    }

    override fun onBindViewHolder(holder: OMDBViewHolder, position: Int) {
       holder.bindData(this@OMDBAdapter,position)
    }

    override fun getItemCount(): Int {
      return data.size
    }
}
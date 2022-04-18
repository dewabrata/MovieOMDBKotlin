package com.adl.ujiancrud.adapter

import android.content.Intent
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.item_movie.view.*


class OMDBViewHolder(view:View):RecyclerView.ViewHolder(view) {
    val movieName = view.txtMovieName
    val director = view.txtDirector
    val rating = view.txtRating
    val image = view.photo
    val edit = view.btnSearch


    fun bindData(adapter:OMDBAdapter, position:Int){



    }

}
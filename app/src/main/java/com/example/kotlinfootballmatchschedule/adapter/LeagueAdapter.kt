package com.example.kotlinfootballmatchschedule.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinfootballmatchschedule.ui.LeagueItemUI
import com.example.kotlinfootballmatchschedule.model.League
import kotlinx.android.extensions.LayoutContainer
import org.jetbrains.anko.AnkoContext

class LeagueAdapter(private val context: Context, private val items: MutableList<League>, private val listener:(League) ->Unit )
    : RecyclerView.Adapter<LeagueAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(LeagueItemUI().createView(AnkoContext.create(context,parent)))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(items[position],listener)
    }

    override fun getItemCount(): Int = items.size

    class ViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView),
        LayoutContainer {

        private var tvName: TextView = itemView.findViewById(LeagueItemUI.tvLeagueName)
        //var ivImage: ImageView = itemView.findViewById(LeagueItemUI.ivLeagueImage)

        fun bindItem(items: League, listener: (League) -> Unit) {
            tvName.text = items.strLeague


            /*
            val tempImage:Int = items.image!!
            ivImage.setImageResource(tempImage)
            */


            containerView.setOnClickListener { listener(items) }
        }
    }
}
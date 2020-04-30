package com.example.kotlinfootballmatchschedule.ui

import android.content.Context
import android.view.View
import android.widget.LinearLayout
import android.widget.ProgressBar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinfootballmatchschedule.adapter.EventAdapter
import com.example.kotlinfootballmatchschedule.activity.EventActivity
import com.example.kotlinfootballmatchschedule.model.Event
import com.example.kotlinfootballmatchschedule.view.EventView
import org.jetbrains.anko.*
import org.jetbrains.anko.recyclerview.v7.recyclerView

class EventUI(context:Context) : AnkoComponent<EventActivity>,EventView {

    var context:Context = context
    private lateinit var linearLayout:LinearLayout
    private lateinit var recyclerView:RecyclerView


    var events: MutableList<Event> = mutableListOf()
    private lateinit var progressBar:ProgressBar


    override fun createView(ui: AnkoContext<EventActivity>) = with(ui) {
        verticalLayout {
            padding = dip(16)

            linearLayout = linearLayout {
                lparams(matchParent, wrapContent)
                orientation = LinearLayout.VERTICAL
                progressBar = progressBar {
                }.lparams(matchParent, matchParent)

                recyclerView = recyclerView {
                    lparams(matchParent, matchParent)
                    layoutManager = LinearLayoutManager(context)
                    adapter = EventAdapter(context,events){
                        context.toast("id = "+it.idEvent)
                    }
                }

            }

        }
    }

    override fun showLoading() {
        progressBar.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        progressBar.visibility = View.GONE
    }

    override fun showNoEvent() {
    }

    override fun showNextEvent(data: List<Event>) {
        recyclerView.adapter = EventAdapter(context,data as MutableList<Event>){
            context.toast("id = "+it.idEvent)
        }
    }
}
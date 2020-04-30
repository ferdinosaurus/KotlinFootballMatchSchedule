package com.example.kotlinfootballmatchschedule.ui

import android.content.Context
import android.view.View
import android.widget.*
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinfootballmatchschedule.adapter.EventAdapter
import com.example.kotlinfootballmatchschedule.activity.EventActivity
import com.example.kotlinfootballmatchschedule.activity.EventDetailActivity
import com.example.kotlinfootballmatchschedule.model.Event
import com.example.kotlinfootballmatchschedule.view.EventDetailView
import com.example.kotlinfootballmatchschedule.view.EventView
import org.jetbrains.anko.*
import org.jetbrains.anko.recyclerview.v7.recyclerView
import org.jetbrains.anko.sdk27.coroutines.onQueryTextListener

class EventDetailUI(context:Context) : AnkoComponent<EventDetailActivity>,EventDetailView{

    private var context:Context = context
    lateinit var textView:TextView
    override fun createView(ui: AnkoContext<EventDetailActivity>)= with(ui) {
        linearLayout{
            lparams(matchParent, wrapContent)
            textView=textView {
                text = "test"
            }
        }
    }

    override fun showLoading() {

    }

    override fun hideLoading() {
    }

    override fun showNoEvent() {
    }

    override fun showDetailEvent(data: Event) {
        textView.text = data.idEvent+" - "+data.strEvent+" - "+data.dateEvent
    }


}
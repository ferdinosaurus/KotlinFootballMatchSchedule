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
import com.example.kotlinfootballmatchschedule.view.EventView
import org.jetbrains.anko.*
import org.jetbrains.anko.recyclerview.v7.recyclerView
import org.jetbrains.anko.sdk27.coroutines.onQueryTextListener

class EventUI(context:Context) : AnkoComponent<EventActivity>,EventView {

    private var context:Context = context
    private lateinit var recyclerView:RecyclerView

    lateinit var buttonPrev:Button
    lateinit var buttonNext:Button
    lateinit var searchView:SearchView



    private var events: MutableList<Event> = mutableListOf()
    private lateinit var progressBar:ProgressBar


    override fun createView(ui: AnkoContext<EventActivity>) = with(ui) {
        linearLayout {
            padding = dip(16)

            lparams (width = matchParent, height = matchParent)
            orientation = LinearLayout.VERTICAL

            searchView = searchView {
                onQueryTextListener {

                }

            }.lparams(matchParent, wrapContent)

            linearLayout {
                lparams(matchParent, wrapContent)
                orientation = LinearLayout.HORIZONTAL

                buttonPrev = button {
                    text = "prev"
                }.lparams{
                    width = dip(0)
                    height = matchParent
                    weight = 1F
                }


                buttonNext = button {
                    text = "next"
                }.lparams{
                    width = dip(0)
                    height = matchParent
                    weight = 1F
                }

            }

            progressBar = progressBar {
            }.lparams(matchParent, wrapContent)

            recyclerView = recyclerView {
                lparams(matchParent, wrapContent)

                layoutManager = LinearLayoutManager(context)
                adapter = EventAdapter(context,events){
                    context.toast("id = "+it.idEvent)
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
        recyclerView.visibility = View.GONE
    }

    override fun showEvent(data: List<Event>) {

        recyclerView.visibility = View.VISIBLE
        recyclerView.adapter = EventAdapter(context,data as MutableList<Event>){
            context.startActivity<EventDetailActivity>("extraEventId" to it.idEvent)

        }
    }
}
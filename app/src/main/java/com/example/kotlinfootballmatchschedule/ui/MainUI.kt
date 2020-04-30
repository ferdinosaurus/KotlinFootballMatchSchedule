package com.example.kotlinfootballmatchschedule.ui

import android.content.Context
import android.view.View
import android.widget.ProgressBar
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinfootballleague.LeagueAdapter
import com.example.kotlinfootballmatchschedule.activity.EventActivity
import com.example.kotlinfootballmatchschedule.activity.MainActivity
import com.example.kotlinfootballmatchschedule.model.League
import com.example.kotlinfootballmatchschedule.view.MainView
import org.jetbrains.anko.*
import org.jetbrains.anko.recyclerview.v7.recyclerView

class MainUI (context: Context): AnkoComponent<MainActivity> , MainView {

    val context = context


    var leagues: MutableList<League> = mutableListOf()
    lateinit var rv_league:RecyclerView

    private lateinit var progressBar: ProgressBar

    override fun createView(ui: AnkoContext<MainActivity>) = with(ui) {
        verticalLayout {
            padding = dip(16)

            lparams(matchParent, matchParent)

            relativeLayout {

                lparams(matchParent, matchParent)
                rv_league = recyclerView {

                    lparams(matchParent, matchParent)
                    layoutManager = GridLayoutManager(context, 2)
                    adapter = LeagueAdapter(context, leagues) {
                        startActivity<EventActivity>("leagueExtra" to it)

                        toast("id = "+it.strLeague)
                    }

                }
                progressBar = progressBar {
                }.lparams{
                    centerHorizontally()
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

    override fun showLeagueList(data: List<League>) {
        rv_league.adapter = LeagueAdapter(context, data as MutableList<League>) {
            context.startActivity<EventActivity>("ExtraLeagueId" to it.idLeague)
            context.toast("id = "+it.strLeague)
        }
    }
}
package com.example.kotlinfootballmatchschedule.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SearchView
import com.example.kotlinfootballmatchschedule.ApiRepository
import com.example.kotlinfootballmatchschedule.model.Event
import com.example.kotlinfootballmatchschedule.presenter.EventPresenter
import com.example.kotlinfootballmatchschedule.ui.EventUI
import com.example.kotlinfootballmatchschedule.view.EventView
import com.google.gson.Gson
import org.jetbrains.anko.sdk27.coroutines.onClick
import org.jetbrains.anko.setContentView
import org.jetbrains.anko.toast

class EventActivity : AppCompatActivity(),EventView{

    private lateinit var leagueId: String
    private lateinit var eventUI:EventUI
    private lateinit var eventPresenter:EventPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        leagueId = intent.getStringExtra("ExtraLeagueId")
        eventUI = EventUI(this)
        eventUI.setContentView(this)
        eventPresenter = EventPresenter(this,ApiRepository(),Gson())


        eventPresenter.getPrevEvent(leagueId)
        eventUI.buttonPrev.onClick {
            eventPresenter.getSearchEvent(leagueId)
        }
        eventUI.buttonNext.onClick {
            eventPresenter.getSearchEvent(leagueId)
        }

        eventUI.searchView.setOnQueryTextListener(object:SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                toast(query.toString())
                eventPresenter.getSearchEvent(query.toString())
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                //toast(newText.toString())
                //eventPresenter.getSearchEvent(newText.toString())
                return false
            }
        })

    }

    override fun showLoading() {
        eventUI.showLoading()
    }

    override fun hideLoading() {
        eventUI.hideLoading()
    }

    override fun showNoEvent() {
        eventUI.showNoEvent()
    }

    override fun showNextEvent(data: List<Event>) {
        eventUI.showNextEvent(data)
    }
}

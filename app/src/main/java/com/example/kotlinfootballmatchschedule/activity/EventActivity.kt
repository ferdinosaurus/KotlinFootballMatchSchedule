package com.example.kotlinfootballmatchschedule.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kotlinfootballmatchschedule.ApiRepository
import com.example.kotlinfootballmatchschedule.model.Event
import com.example.kotlinfootballmatchschedule.presenter.EventPresenter
import com.example.kotlinfootballmatchschedule.ui.EventUI
import com.example.kotlinfootballmatchschedule.view.EventView
import com.google.gson.Gson
import org.jetbrains.anko.setContentView

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

        eventPresenter.getNextEvent(leagueId)
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
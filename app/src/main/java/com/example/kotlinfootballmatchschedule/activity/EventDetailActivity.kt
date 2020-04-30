package com.example.kotlinfootballmatchschedule.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kotlinfootballmatchschedule.ApiRepository
import com.example.kotlinfootballmatchschedule.R
import com.example.kotlinfootballmatchschedule.model.Event
import com.example.kotlinfootballmatchschedule.presenter.EventDetailPresenter
import com.example.kotlinfootballmatchschedule.ui.EventDetailUI
import com.example.kotlinfootballmatchschedule.view.EventDetailView
import com.google.gson.Gson
import org.jetbrains.anko.setContentView

class EventDetailActivity : AppCompatActivity(),EventDetailView {

    private lateinit var eventDetailUI:EventDetailUI

    private lateinit var eventDetailPresenter: EventDetailPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val eventId = intent.getStringExtra("extraEventId")
        setContentView(R.layout.activity_event_detail)
        eventDetailUI = EventDetailUI()
        eventDetailUI.setContentView(this)

        eventDetailPresenter = EventDetailPresenter(this,ApiRepository(), Gson())

        eventDetailPresenter.getEventDetail(eventId)

    }

    override fun showLoading() {
        eventDetailUI.showLoading()
    }

    override fun hideLoading() {
        eventDetailUI.hideLoading()
    }

    override fun showNoEvent() {
        eventDetailUI.showNoEvent()
    }

    override fun showDetailEvent(data: Event) {
        eventDetailUI.showDetailEvent(data)
    }
}

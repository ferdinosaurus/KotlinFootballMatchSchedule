package com.example.kotlinfootballmatchschedule.presenter

import com.example.kotlinfootballmatchschedule.ApiRepository
import com.example.kotlinfootballmatchschedule.TheSportDBApi
import com.example.kotlinfootballmatchschedule.model.EventResponse
import com.example.kotlinfootballmatchschedule.view.EventDetailView
import com.google.gson.Gson
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class EventDetailPresenter(private val view: EventDetailView,
                           private val apiRepository: ApiRepository,
                           private val gson: Gson) {
    fun getEventDetail(eventId: String?) {
        view.showLoading()
        doAsync {
            val data = gson.fromJson(apiRepository
                .doRequest(TheSportDBApi.getDetailEvent(eventId)),
                EventResponse::class.java
            )
            uiThread {
                if(data.events!=null){
                    data.events[0]
                    view.showDetailEvent(data.events[0])
                }else{
                    view.showNoEvent()
                }
                view.hideLoading()
            }
        }
    }






}
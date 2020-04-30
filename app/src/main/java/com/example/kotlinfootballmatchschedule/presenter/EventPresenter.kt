package com.example.kotlinfootballmatchschedule.presenter

import com.example.kotlinfootballmatchschedule.ApiRepository
import com.example.kotlinfootballmatchschedule.TheSportDBApi
import com.example.kotlinfootballmatchschedule.model.EventResponse
import com.example.kotlinfootballmatchschedule.view.EventView
import com.google.gson.Gson
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class EventPresenter(private val view: EventView,
                     private val apiRepository: ApiRepository,
                     private val gson: Gson) {
    fun getNextEvent(leagueId: String?) {
        view.showLoading()
        doAsync {
            val data = gson.fromJson(apiRepository
                .doRequest(TheSportDBApi.getNextEvent(leagueId)),
                EventResponse::class.java
            )
            uiThread {
                if(data.events!=null){
                    view.showNextEvent(data.events)
                }else{
                    view.showNoEvent()
                }
                view.hideLoading()
            }
        }
    }

    fun getPrevEvent(leagueId: String?) {
        view.showLoading()
        doAsync {
            val data = gson.fromJson(apiRepository
                .doRequest(TheSportDBApi.getPrevEvent(leagueId)),
                EventResponse::class.java
            )
            uiThread {
                if(data.events!=null){
                    view.showNextEvent(data.events)
                }else{
                    view.showNoEvent()
                }
                view.hideLoading()
            }
        }
    }

    fun getSearchEvent(textSearch: String?) {
        view.showLoading()
        doAsync {
            val data = gson.fromJson(apiRepository
                .doRequest(TheSportDBApi.getSearchEvent(textSearch)),
                EventResponse::class.java
            )
            uiThread {
                if(data.events!=null){
                    view.showNextEvent(data.events)
                }else{
                    view.showNoEvent()
                }
                view.hideLoading()
            }
        }
    }





}
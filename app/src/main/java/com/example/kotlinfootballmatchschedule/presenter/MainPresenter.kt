package com.example.kotlinfootballmatchschedule.presenter

import com.example.kotlinfootballmatchschedule.ApiRepository
import com.example.kotlinfootballmatchschedule.TheSportDBApi
import com.example.kotlinfootballmatchschedule.model.LeagueResponse
import com.example.kotlinfootballmatchschedule.view.MainView
import com.google.gson.Gson
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class MainPresenter(private val view: MainView,
                    private val apiRepository: ApiRepository,
                    private val gson: Gson) {

    fun getAllLeague() {
        view.showLoading()
        doAsync {
            val data = gson.fromJson(apiRepository
                .doRequest(TheSportDBApi.getLeague()),
                LeagueResponse::class.java
            )

            uiThread {
                view.hideLoading()
                view.showLeagueList(data.countrys)
            }
        }
    }

    /*
    fun getTeamList(league: String?) {
        view.showLoading()
        doAsync {
            val data = gson.fromJson(apiRepository
                .doRequest(TheSportDBApi.getTeams(league)),
                TeamResponse::class.java
            )

            uiThread {
                view.hideLoading()
                view.showTeamList(data.teams)
            }
        }
    }
    */
}
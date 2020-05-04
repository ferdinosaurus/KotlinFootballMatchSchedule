package com.example.kotlinfootballmatchschedule.view

import com.example.kotlinfootballmatchschedule.model.LeagueParcelable

interface MainView {
    fun showLoading()
    fun hideLoading()
    fun showLeagueList(data: List<LeagueParcelable>)


}
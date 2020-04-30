package com.example.kotlinfootballmatchschedule.view

import com.example.kotlinfootballmatchschedule.model.League

interface MainView {
    fun showLoading()
    fun hideLoading()
    fun showLeagueList(data: List<League>)


}
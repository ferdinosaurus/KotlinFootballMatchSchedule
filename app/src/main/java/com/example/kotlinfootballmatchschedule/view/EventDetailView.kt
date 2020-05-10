package com.example.kotlinfootballmatchschedule.view

import com.example.kotlinfootballmatchschedule.model.Event
import com.example.kotlinfootballmatchschedule.model.Team

interface EventDetailView{
    fun showLoading()
    fun hideLoading()
    fun showNoEvent()
    fun showDetailEvent(data: Event)
    fun showDetailHome(data: Team)
    fun showDetailAway(data: Team)

}
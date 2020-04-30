package com.example.kotlinfootballmatchschedule.view

import com.example.kotlinfootballmatchschedule.model.Event

interface EventView{
    fun showLoading()
    fun hideLoading()
    fun showNoEvent()
    fun showNextEvent(data: List<Event>)
}
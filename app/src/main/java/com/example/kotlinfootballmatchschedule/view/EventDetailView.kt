package com.example.kotlinfootballmatchschedule.view

import com.example.kotlinfootballmatchschedule.model.Event

interface EventDetailView{
    fun showLoading()
    fun hideLoading()
    fun showNoEvent()
    fun showDetailEvent(data: Event)
}
package com.example.kotlinfootballmatchschedule.ui

import android.content.Context
import android.widget.TextView
import com.example.kotlinfootballmatchschedule.activity.EventActivity
import com.example.kotlinfootballmatchschedule.model.Event
import com.example.kotlinfootballmatchschedule.view.EventView
import org.jetbrains.anko.*

class EventUI(context:Context) : AnkoComponent<EventActivity>,EventView {

    private lateinit var text:TextView

    override fun createView(ui: AnkoContext<EventActivity>) = with(ui) {
        verticalLayout {
            padding = dip(16)
            text = textView {
                text = "test"
            }

        }
    }

    override fun showLoading() {
    }

    override fun hideLoading() {
    }

    override fun showNoEvent() {
        text.text = "no Event"
    }

    override fun showNextEvent(data: List<Event>) {
        text.text = data.get(0).strEvent
    }
}
package com.example.kotlinfootballmatchschedule

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import org.jetbrains.anko.*
import org.jetbrains.anko.support.v4.UI

class EventNextFragment:Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return UI {
            linearLayout{
                lparams(matchParent, matchParent)
                orientation = LinearLayout.VERTICAL

            }
        }.view
    }
}
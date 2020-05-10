package com.example.kotlinfootballmatchschedule.ui

import android.view.Gravity
import android.view.View
import android.widget.*
import com.example.kotlinfootballmatchschedule.activity.EventDetailActivity
import com.example.kotlinfootballmatchschedule.model.Event
import com.example.kotlinfootballmatchschedule.model.Team
import com.example.kotlinfootballmatchschedule.view.EventDetailView
import com.squareup.picasso.Picasso
import org.jetbrains.anko.*

class EventDetailUI: AnkoComponent<EventDetailActivity>,EventDetailView{

    private lateinit var progressBar: ProgressBar
    private lateinit var linearLayout:LinearLayout


    private lateinit var txtStrEvent:TextView

    private lateinit var txtStrHomeTeam:TextView
    private lateinit var txtStrAwayTeam:TextView

    private lateinit var txtStrHomeImage:ImageView
    private lateinit var txtStrAwayImage:ImageView



    private lateinit var txtIntHomeScore:TextView
    private lateinit var txtIntAwayScore:TextView

    private lateinit var txtintHomeShots:TextView
    private lateinit var txtintAwayShots:TextView



    private lateinit var txtStrHomeLineupGoalkeeper:TextView
    private lateinit var txtstrAwayLineupGoalkeeper:TextView

    private lateinit var txtStrHomeLineupDefense:TextView
    private lateinit var txtStrAwayLineupDefense:TextView

    private lateinit var txtStrHomeLineupMidfield:TextView
    private lateinit var txtStrAwayLineupMidfield:TextView





    override fun createView(ui: AnkoContext<EventDetailActivity>)= with(ui) {
        linearLayout{
            lparams(matchParent, wrapContent)

            progressBar = progressBar {
            }.lparams(matchParent, wrapContent)

            linearLayout = linearLayout {
                lparams(matchParent, wrapContent)
                orientation = LinearLayout.VERTICAL

                txtStrEvent = textView {
                    gravity = Gravity.CENTER
                }.lparams{
                    width = matchParent
                    height = wrapContent
                }


                linearLayout {
                    lparams(matchParent, wrapContent)
                    orientation = LinearLayout.HORIZONTAL

                    txtStrHomeImage = imageView {
                    }.lparams{
                        width = dip(0)
                        height = dip(150)
                        weight = 1F
                        gravity = Gravity.CENTER
                    }

                    textView {
                        text = " VS "
                        gravity = Gravity.CENTER
                    }.lparams{
                        width = dip(0)
                        height = matchParent
                        weight = 1F
                    }

                    txtStrAwayImage = imageView {

                    }.lparams{
                        width = dip(0)
                        height = dip(200)
                        weight = 1F
                        gravity = Gravity.CENTER
                    }

                }


                linearLayout {
                    lparams(matchParent, wrapContent)
                    orientation = LinearLayout.HORIZONTAL

                    txtStrHomeTeam = textView {
                        gravity = Gravity.CENTER
                    }.lparams{
                        width = dip(0)
                        height = matchParent
                        weight = 1F
                    }

                    textView {
                        text = " VS "
                        gravity = Gravity.CENTER
                    }.lparams{
                        width = dip(0)
                        height = matchParent
                        weight = 1F
                    }

                    txtStrAwayTeam = textView {
                        gravity = Gravity.CENTER}.lparams{
                        width = dip(0)
                        height = matchParent
                        weight = 1F
                    }

                }

                linearLayout {
                    lparams(matchParent, wrapContent)
                    orientation = LinearLayout.HORIZONTAL

                    txtIntHomeScore = textView {
                        gravity = Gravity.CENTER
                    }.lparams{
                        width = dip(0)
                        height = matchParent
                        weight = 1F
                    }

                    textView {
                        text = " SCORE "
                        gravity = Gravity.CENTER
                    }.lparams{
                        width = dip(0)
                        height = matchParent
                        weight = 1F
                    }

                    txtIntAwayScore = textView {
                        gravity = Gravity.CENTER}.lparams{
                        width = dip(0)
                        height = matchParent
                        weight = 1F
                    }

                }

                linearLayout {
                    lparams(matchParent, wrapContent)
                    orientation = LinearLayout.HORIZONTAL

                    txtintHomeShots = textView {
                        gravity = Gravity.CENTER
                    }.lparams{
                        width = dip(0)
                        height = matchParent
                        weight = 1F
                    }

                    textView {
                        text = " SHOT "
                        gravity = Gravity.CENTER
                    }.lparams{
                        width = dip(0)
                        height = matchParent
                        weight = 1F
                    }

                    txtintAwayShots = textView {
                        gravity = Gravity.CENTER}.lparams{
                        width = dip(0)
                        height = matchParent
                        weight = 1F
                    }

                }



                linearLayout {
                    lparams(matchParent, wrapContent)
                    orientation = LinearLayout.HORIZONTAL

                    txtStrHomeLineupGoalkeeper = textView {
                        gravity = Gravity.CENTER
                    }.lparams{
                        width = dip(0)
                        height = matchParent
                        weight = 1F
                    }

                    textView {
                        text = "Goalkeeper"
                        gravity = Gravity.CENTER
                    }.lparams{
                        width = dip(0)
                        height = matchParent
                        weight = 1F
                    }

                    txtstrAwayLineupGoalkeeper = textView {
                        gravity = Gravity.CENTER}.lparams{
                        width = dip(0)
                        height = matchParent
                        weight = 1F
                    }

                }

                linearLayout {
                    lparams(matchParent, wrapContent)
                    orientation = LinearLayout.HORIZONTAL

                    txtStrHomeLineupDefense = textView {
                        gravity = Gravity.CENTER
                    }.lparams{
                        width = dip(0)
                        height = matchParent
                        weight = 1F
                    }

                    textView {
                        text = "Defense"
                        gravity = Gravity.CENTER
                    }.lparams{
                        width = dip(0)
                        height = matchParent
                        weight = 1F
                    }

                    txtStrAwayLineupDefense = textView {

                        gravity = Gravity.CENTER
                    }.lparams{
                        width = dip(0)
                        height = matchParent
                        weight = 1F
                    }
                }

                linearLayout {
                    lparams(matchParent, wrapContent)
                    orientation = LinearLayout.HORIZONTAL

                    txtStrHomeLineupMidfield = textView {
                        gravity = Gravity.CENTER
                    }.lparams{
                        width = dip(0)
                        height = matchParent
                        weight = 1F
                    }

                    textView {
                        text = "Midfield"
                        gravity = Gravity.CENTER
                    }.lparams{
                        width = dip(0)
                        height = matchParent
                        weight = 1F
                    }

                    txtStrAwayLineupMidfield = textView {

                        gravity = Gravity.CENTER
                    }.lparams{
                        width = dip(0)
                        height = matchParent
                        weight = 1F
                    }
                }

            }
        }
    }

    override fun showLoading() {
        progressBar.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        progressBar.visibility = View.GONE
    }

    override fun showNoEvent() {
    }

    override fun showDetailEvent(data: Event) {
        //TODO detailnya banyak yang null
        txtStrEvent.text = data.strEvent

        txtStrHomeTeam.text = data.strHomeTeam
        txtStrAwayTeam.text = data.strAwayTeam

        txtIntHomeScore.text = data.intHomeScore
        txtIntAwayScore.text = data.intAwayScore

        txtintHomeShots.text = data.intHomeShots
        txtintAwayShots.text = data.intAwayShots

        txtStrHomeLineupGoalkeeper.text = data.strHomeLineupGoalkeeper
        txtstrAwayLineupGoalkeeper.text = data.strAwayLineupGoalkeeper

        txtStrHomeLineupDefense.text = data.strHomeLineupDefense
        txtStrAwayLineupDefense.text = data.strAwayLineupDefense

        txtStrHomeLineupMidfield.text = data.strHomeLineupMidfield
        txtStrAwayLineupMidfield.text = data.strAwayLineupMidfield

    }

    override fun showDetailHome(data: Team) {
        Picasso.get().load(data.strTeamBadge).fit().into(txtStrHomeImage)
    }

    override fun showDetailAway(data: Team) {
        Picasso.get().load(data.strTeamBadge).fit().into(txtStrAwayImage)
    }

}
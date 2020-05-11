package com.example.kotlinfootballmatchschedule.presenter

import android.app.Activity
import com.example.kotlinfootballmatchschedule.R
import com.example.kotlinfootballmatchschedule.model.LeagueParcelable
import com.example.kotlinfootballmatchschedule.view.MainView

class MainPresenter(private val activity: Activity,
                    private val view: MainView
                    ) {

    /*
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
    */

    fun setupData(){
        view.showLoading()

        val leagueParcelables: MutableList<LeagueParcelable> = mutableListOf()



        val leagueId = activity.resources.getStringArray(R.array.league_id)
        val leagueName = activity.resources.getStringArray(R.array.league_name)
        val leagueImage = activity.resources.obtainTypedArray(R.array.league_image)
        val leagueDesc = activity.resources.getStringArray(R.array.league_desc)


        for (i in leagueName.indices){
            leagueParcelables.add(LeagueParcelable(leagueId[i],leagueName[i],leagueImage.getResourceId(i,0),
                leagueDesc[i]
            ))
        }

        view.showLeagueList(leagueParcelables)

        view.hideLoading()
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
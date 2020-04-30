package com.example.kotlinfootballmatchschedule.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ProgressBar
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinfootballleague.LeagueAdapter
import com.example.kotlinfootballmatchschedule.ApiRepository
import com.example.kotlinfootballmatchschedule.model.League
import com.example.kotlinfootballmatchschedule.presenter.MainPresenter
import com.example.kotlinfootballmatchschedule.ui.MainUI
import com.example.kotlinfootballmatchschedule.view.MainView
import com.google.gson.Gson
import org.jetbrains.anko.*
import org.jetbrains.anko.recyclerview.v7.recyclerView

class MainActivity : AppCompatActivity() ,MainView{

    private lateinit var presenter: MainPresenter
    private lateinit var mainUI:MainUI
    private var league: MutableList<League> = mutableListOf()
    private lateinit var rv_league: RecyclerView

    private lateinit var progressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)

        /*
        setupLayout()
        */
        mainUI = MainUI(this)
        mainUI.setContentView(this)
        init()


        /*
        mainUI = MainUI()
        mainUI.setContentView(this)
        */

    }

    private fun init(){
        val request = ApiRepository()
        val gson = Gson()


        presenter = MainPresenter(this,request,gson)
        presenter.getAllLeague()



        /*
        val leagueId = resources.getStringArray(R.array.league_id)
        val leagueName = resources.getStringArray(R.array.league_name)
        val leagueImage = resources.obtainTypedArray(R.array.league_image)

        for (i in leagueName.indices){
            leagueParcelables.add(LeagueParcelable(leagueId.get(i),leagueName.get(i),leagueImage.getResourceId(i,0)))
        }
        mainUI.dataResponse.clear()
        mainUI.dataResponse.addAll(leagueParcelables)
        */

    }

    override fun showLoading() {
        mainUI.showLoading()
    }

    override fun hideLoading() {
        mainUI.hideLoading()
    }

    override fun showLeagueList(data: List<League>) {

        /*
        mainUI.dataResponse.clear()
        mainUI.dataResponse.addAll(data)
        */
        mainUI.showLeagueList(data)

        /*
        rv_league.adapter = LeagueAdapter(this, data as MutableList<League>) {
            startActivity<LeagueActivity>("ExtraLeagueId" to it.idLeague)
            toast("id = " + it.strLeague)
        }
        */

    }


    private fun setupLayout(){

        verticalLayout {
            padding = dip(16)

            lparams(matchParent, matchParent)

            relativeLayout {

                lparams(matchParent, matchParent)
                rv_league = recyclerView {

                    lparams(matchParent, matchParent)
                    layoutManager = GridLayoutManager(context, 2)
                    adapter = LeagueAdapter(context, league) {
                        startActivity<EventActivity>("leagueExtra" to it)

                        toast("id = "+it.strLeague)
                    }

                }
                progressBar = progressBar {
                }.lparams{
                    centerHorizontally()
                }
            }

        }
    }


    /*
    class MainUI : AnkoComponent<MainActivity> {
        var dataResponse: MutableList<League> = mutableListOf()
        override fun createView(ui: AnkoContext<MainActivity>) = with(ui) {
            verticalLayout {
                padding = dip(16)


                lparams(matchParent, matchParent)
                rv_league = recyclerView {

                    lparams(matchParent, matchParent)
                    layoutManager = GridLayoutManager(context, 2)
                    adapter = LeagueAdapter(context, dataResponse) {
                        startActivity<LeagueActivity>("leagueExtra" to it)

                        toast("id = "+it.strLeague)
                    }

                }

            }
        }
    }
    */
}

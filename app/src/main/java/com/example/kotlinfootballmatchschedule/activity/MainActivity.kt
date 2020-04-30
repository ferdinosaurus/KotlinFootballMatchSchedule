package com.example.kotlinfootballmatchschedule.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kotlinfootballmatchschedule.ApiRepository
import com.example.kotlinfootballmatchschedule.model.League
import com.example.kotlinfootballmatchschedule.presenter.MainPresenter
import com.example.kotlinfootballmatchschedule.ui.MainUI
import com.example.kotlinfootballmatchschedule.view.MainView
import com.google.gson.Gson
import org.jetbrains.anko.*

class MainActivity : AppCompatActivity() ,MainView{

    private lateinit var presenter: MainPresenter
    private lateinit var mainUI:MainUI
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        mainUI = MainUI(this)
        mainUI.setContentView(this)
        init()

    }

    private fun init(){
        val request = ApiRepository()
        val gson = Gson()

        presenter = MainPresenter(this,request,gson)
        presenter.getAllLeague()

    }

    override fun showLoading() {
        mainUI.showLoading()
    }

    override fun hideLoading() {
        mainUI.hideLoading()
    }

    override fun showLeagueList(data: List<League>) {
        mainUI.showLeagueList(data)

    }

}

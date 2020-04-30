package com.example.kotlinfootballmatchschedule.model

import com.google.gson.annotations.SerializedName

class League {
    @SerializedName("idLeague")
    var idLeague: String? = null

    @SerializedName("strLeague")
    var strLeague: String? = null

    @SerializedName("strSport")
    var strSport: String? = null

    @SerializedName("strLeagueAlternate")
    var strLeagueAlternate: String? = null

}
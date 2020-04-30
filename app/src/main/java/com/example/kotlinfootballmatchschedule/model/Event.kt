package com.example.kotlinfootballmatchschedule.model

import com.google.gson.annotations.SerializedName

class Event {

    @SerializedName("idEvent")
    var idEvent: String? = null

    @SerializedName("strEvent")
    var strEvent: String? = null

    @SerializedName("dateEvent")
    var dateEvent: String? = null

}
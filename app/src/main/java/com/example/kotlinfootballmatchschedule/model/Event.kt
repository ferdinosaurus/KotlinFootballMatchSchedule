package com.example.kotlinfootballmatchschedule.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
class Event : Parcelable {

    @SerializedName("idEvent")
    var idEvent: String? = null

    @SerializedName("strEvent")
    var strEvent: String? = null

    @SerializedName("dateEvent")
    var dateEvent: String? = null

}
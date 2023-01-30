package com.example.nasaapp.network.models

import android.os.Parcel
import android.os.Parcelable

data class ModelPictOfTheDay(

    val date: String?,
    val explanation: String?,
    val url: String?,
    val media_type: String?,
    val hdurl: String?,
    val image: String?,
    val service_version: String?,
    val title: String?

):Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(parcel: Parcel?, flags: Int) {
        parcel?.writeString(date)
        parcel?.writeString(explanation)
        parcel?.writeString(url)
        parcel?.writeString(media_type)
        parcel?.writeString(hdurl)
        parcel?.writeString(image)
        parcel?.writeString(service_version)
        parcel?.writeString(title)
    }

    companion object CREATOR : Parcelable.Creator<ModelPictOfTheDay> {
        override fun createFromParcel(parcel: Parcel): ModelPictOfTheDay {
            return ModelPictOfTheDay(parcel)
        }

        override fun newArray(size: Int): Array<ModelPictOfTheDay?> {
            return arrayOfNulls(size)
        }
    }
}
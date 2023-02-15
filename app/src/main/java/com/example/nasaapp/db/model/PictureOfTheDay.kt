package com.example.nasaapp.db.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "picture_of_the_day_table")
data class PictureOfTheDay(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val date: String?,
    val explanation: String?,
    val url: String?,
    val media_type: String?,
    val hdurl: String?,
    val image: String?,
    val service_version: String?,
    val title: String?
): Parcelable

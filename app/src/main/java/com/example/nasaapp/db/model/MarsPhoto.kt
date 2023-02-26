package com.example.nasaapp.db.model

import android.os.Parcelable
import android.view.Display.Mode
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.nasaapp.network.models.ModelOpportunity
import com.example.nasaapp.network.models.PhotoVO
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "mars_photo_table")
data class MarsPhoto(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val photoId: Int?,
    val sol: Int?,
    val img_src : String?,
    val earth_date: String?,
    val name: String?,
    val landing_date: String?,
    val launch_date: String?,
    val status: String?
) : Parcelable

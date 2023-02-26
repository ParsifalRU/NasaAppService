package com.example.nasaapp.network.models

import android.os.Parcel
import android.os.Parcelable
import androidx.room.Entity
import com.example.nasaapp.db.model.MarsPhoto
import kotlinx.android.parcel.Parcelize


/*@Parcelize*/

data class ModelOpportunity(
    val photos: List<PhotoVO>
    ) /*: Parcelable {

}*/


data class PhotoVO(

    val id: Int?,
    val sol: Int?,
    val camera: CameraVO?,
    val img_src : String?,
    val earth_date: String?,
    val rover: RoverVO?

)/*: Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readParcelable(CameraVO::class.java.classLoader),
        parcel.readString(),
        parcel.readString(),
        parcel.readParcelable(RoverVO::class.java.classLoader)
    ) {
    }

    override fun writeToParcel(parcel: Parcel?, flags: Int) {
        parcel?.writeValue(id)
        parcel?.writeValue(sol)
        parcel?.writeParcelable(camera, flags)
        parcel?.writeString(img_src)
        parcel?.writeString(earth_date)
        parcel?.writeParcelable(rover, flags)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<PhotoVO> {
        override fun createFromParcel(parcel: Parcel): PhotoVO {
            return PhotoVO(parcel)
        }

        override fun newArray(size: Int): Array<PhotoVO?> {
            return arrayOfNulls(size)
        }
    }


}*/


data class RoverVO(
    val id: Int?,
    val name: String?,
    val landing_date: String? ,
    val launch_date: String? ,
    val status: String?
) /*:Parcelable{
    constructor(parcel: Parcel) : this(
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel?, flags: Int) {
        parcel?.writeValue(id)
        parcel?.writeString(name)
        parcel?.writeString(landing_date)
        parcel?.writeString(launch_date)
        parcel?.writeString(status)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<RoverVO> {
        override fun createFromParcel(parcel: Parcel): RoverVO {
            return RoverVO(parcel)
        }

        override fun newArray(size: Int): Array<RoverVO?> {
            return arrayOfNulls(size)
        }
    }
}
*/
data class CameraVO(
    val id: Int?,
    val name: String? ,
    val full_name: String?
)/*: Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel?, flags: Int) {
        parcel?.writeValue(id)
        parcel?.writeString(name)
        parcel?.writeString(full_name)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<CameraVO> {
        override fun createFromParcel(parcel: Parcel): CameraVO {
            return CameraVO(parcel)
        }

        override fun newArray(size: Int): Array<CameraVO?> {
            return arrayOfNulls(size)
        }
    }
}*/


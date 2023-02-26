package com.example.nasaapp.network.api

import com.example.nasaapp.network.models.ModelOpportunity
import com.example.nasaapp.network.models.ModelPictOfTheDay
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Query
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

private const val API_KEY = "TZIMZYEFae7yfl8BNaoYsogFD8e88WTx0dSaWvxi"
    private const val BASE_ROVER = "mars-photos/api/v1/rovers/"

    private const val PICTURE_OF_DAY = "planetary/apod"

    private const val CURIOSITY_ROVER = BASE_ROVER + "curiosity/photos"
    private const val OPPORTUNITY_ROVER = BASE_ROVER + "opportunity/photos"
    private const val SPIRIT_ROVER = BASE_ROVER + "spirit/photos"


    val currentDate: Date = Date()
    val dateFormat: DateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
    val dateText: String = dateFormat.format(currentDate)


interface NasaPhotoApi {

    @GET(PICTURE_OF_DAY)
    fun getPhotos(

        @Query("api_key")
        ApiKey :String = API_KEY,

        @Query("start_date")
        StartDate : String = dateText

    ) : Single<List<ModelPictOfTheDay>>


    @GET(CURIOSITY_ROVER)
    fun getCuriosityMarsPhotosFromEarthDate(

        @Query("page")
        page: Int = 1,

        @Query("sol")
        sol: Int = 1000,

        @Query("earth_date")
        earthDate: String = dateText,

/*
        @Query("camera")
        camera: String = "FHAZ",
*/

        @Query("api_key")
        APIKey: String = API_KEY

    ): Single<ModelOpportunity>


    @GET(OPPORTUNITY_ROVER)
    fun getOpportunityMarsPhotosFromEarthDate(

        @Query("sol")
        sol: Int = 1000,

        @Query("page")
        page: Int = 1,

        @Query("earth_date")
        earthDate: String = "2015-6-3",

        @Query("camera")
        camera: String = "FHAZ",

        @Query("api_key")
        APIKey: String = API_KEY
    ): Single<ModelOpportunity>

    @GET(SPIRIT_ROVER)
    suspend fun getSpiritMarsPhotosFromMarsSol(
        @Query("page")
        page: Int = 1,

        @Query("sol")
        sol: Int = 1000,

        @Query("camera")
        camera: String = "FHAZ",

        @Query("api_key")
        APIKey: String = API_KEY
    ): Observable<List<ModelOpportunity>>

    @GET(SPIRIT_ROVER)
    suspend fun getSpiritMarsPhotosFromEarthDate(
        @Query("page")
        page: Int = 1,

        @Query("earth_date")
        earthDate: String = "2006-11-17",

        @Query("camera")
        camera: String = "FHAZ",

        @Query("api_key")
        APIKey: String = API_KEY
    ): Observable<List<ModelOpportunity>>

}




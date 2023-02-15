package com.example.nasaapp.db.dao

import androidx.room.*
import com.example.nasaapp.db.model.PictureOfTheDay
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Flowable


@Dao
interface PictureOfTheDayDB {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPicture(picture: PictureOfTheDay):Completable

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPictures(pictures: List<PictureOfTheDay>):Completable

    @Delete
    fun deletePicture(picture: PictureOfTheDay):Completable

    @Query("DELETE FROM $TABLE_NAME")
    fun deleteAllPictures():Completable

    @Query("SELECT * FROM $TABLE_NAME")
    fun getAllPictures(): Flowable<List<PictureOfTheDay>>

    @Query("SELECT * FROM $TABLE_NAME ORDER BY id DESC LIMIT 1")
    fun getLastPicture(): Flowable<PictureOfTheDay>

    @Query("SELECT EXISTS (SELECT explanation FROM $TABLE_NAME WHERE explanation = :explanation)")
    fun isPictureExists(explanation: String): Flowable<Boolean>

    @Query("SELECT * FROM $TABLE_NAME WHERE id = :id")
    fun getPictureOfDay(id: Int):Flowable<PictureOfTheDay>

    companion object {
        private const val TABLE_NAME = "picture_of_the_day_table"
    }



}
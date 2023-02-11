package com.example.nasaapp.db.dao

import androidx.room.*
import com.example.nasaapp.db.model.PictureOfTheDay


@Dao
interface PictureOfTheDayDB {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPicture(picture: PictureOfTheDay)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPictures(pictures: List<PictureOfTheDay>)

    @Delete
    fun deletePicture(picture: PictureOfTheDay)

    @Query("DELETE FROM $TABLE_NAME")
    fun deleteAllPictures()

    @Query("SELECT * FROM $TABLE_NAME")
    fun getAllPictures(): List<PictureOfTheDay>

    @Query("SELECT * FROM $TABLE_NAME ORDER BY id DESC LIMIT 1")
    fun getLastPicture(): PictureOfTheDay

    @Query("SELECT EXISTS (SELECT explanation FROM $TABLE_NAME WHERE explanation = :explanation)")
    fun isPictureExists(explanation: String): Boolean

    @Query("SELECT * FROM $TABLE_NAME WHERE id = :id")
    fun getPictureOfDay(id: Int): PictureOfTheDay

    companion object {
        private const val TABLE_NAME = "picture_of_the_day_table"
    }



}
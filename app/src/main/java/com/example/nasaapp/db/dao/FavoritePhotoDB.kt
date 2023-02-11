package com.example.nasaapp.db.dao

import androidx.room.*
import com.example.nasaapp.db.model.FavoritePhoto

@Dao
interface FavoritePhotoDB {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPhoto(photo: FavoritePhoto)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPhotos(photos: List<FavoritePhoto>)

    @Delete
    fun deletePhoto(photo: FavoritePhoto)

    @Query("DELETE FROM $TABLE_NAME")
    fun deleteAll()

    @Query("SELECT * FROM $TABLE_NAME")
    fun getAllPhotos(): List<FavoritePhoto>

    @Query("SELECT * FROM $TABLE_NAME WHERE id = :id LIMIT 1")
    fun getPhoto(id: Int): FavoritePhoto

    @Query("SELECT EXISTS(SELECT id FROM $TABLE_NAME WHERE id = :id)")
    fun isPhotoExists(id: Int): Boolean

    companion object {
        private const val TABLE_NAME = "favorite_photo_table"
    }

}
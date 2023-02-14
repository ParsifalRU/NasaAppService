package com.example.nasaapp.db.dao

import androidx.room.*
import com.example.nasaapp.db.model.FavoritePhoto
import io.reactivex.rxjava3.core.Flowable

@Dao
interface FavoritePhotoDB {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPhoto(photo: FavoritePhoto):Flowable<FavoritePhoto>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPhotos(photos: List<FavoritePhoto>):Flowable<List<FavoritePhoto>>

    @Delete
    fun deletePhoto(photo: FavoritePhoto):Flowable<FavoritePhoto>

    @Query("DELETE FROM $TABLE_NAME")
    fun deleteAll():Flowable<List<FavoritePhoto>>

    @Query("SELECT * FROM $TABLE_NAME")
    fun getAllPhotos(): Flowable<List<FavoritePhoto>>

    @Query("SELECT * FROM $TABLE_NAME WHERE id = :id LIMIT 1")
    fun getPhoto(id: Int): Flowable<FavoritePhoto>

    @Query("SELECT EXISTS(SELECT id FROM $TABLE_NAME WHERE id = :id)")
    fun isPhotoExists(id: Int): Flowable<Boolean>

    companion object {
        private const val TABLE_NAME = "favorite_photo_table"
    }

}
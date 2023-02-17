package com.example.nasaapp.db.dao

import androidx.room.*
import com.example.nasaapp.db.model.FavoritePhoto
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Flowable

@Dao
interface FavoritePhotoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPhoto(photo: FavoritePhoto): Completable

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPhotos(photos: List<FavoritePhoto>):Completable

    @Delete
    fun deletePhoto(photo: FavoritePhoto): Completable

    @Query("DELETE FROM $TABLE_NAME")
    fun deleteAll():Completable

    @Query("SELECT * FROM $TABLE_NAME")
    fun getAllPhotos():Flowable<List<FavoritePhoto>>

    @Query("SELECT * FROM $TABLE_NAME WHERE id = :id LIMIT 1")
    fun getPhoto(id: Int):Flowable<FavoritePhoto>

    @Query("SELECT EXISTS(SELECT id FROM $TABLE_NAME WHERE id = :id)")
    fun isPhotoExists(id: Int): Flowable<Boolean>

    companion object {
        private const val TABLE_NAME = "favorite_photo_table"
    }

}
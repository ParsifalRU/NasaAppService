package com.example.nasaapp.db.dao

import androidx.room.*
import com.example.nasaapp.db.model.MarsPhoto
import io.reactivex.rxjava3.core.Flowable

@Dao
interface MarsPhotoDB {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPhoto(marsPhotoDB: MarsPhoto):Flowable<MarsPhotoDB>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPhotos(marsPhotosDB: List<MarsPhoto>):Flowable<List<MarsPhotoDB>>

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun updatePhoto(marsPhotoDB: MarsPhoto):Flowable<MarsPhotoDB>

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun updatePhotos(marsPhotos: List<MarsPhoto>):Flowable<List<MarsPhotoDB>>

    @Delete
    fun deletePhoto(marsPhoto: MarsPhoto):Flowable<MarsPhotoDB>

    @Query("DELETE FROM $TABLE_NAME")
    fun deleteAllPhotos():Flowable<List<MarsPhotoDB>>

    @Query("SELECT * FROM $TABLE_NAME")
    fun getAllPhotos(): Flowable<List<MarsPhoto>>

    @Query("SELECT * FROM $TABLE_NAME WHERE id = :id LIMIT 1")
    fun getPhoto(id: Int): Flowable<MarsPhoto>

    @Query("SELECT EXISTS(SELECT id FROM $TABLE_NAME WHERE id = :id)")
    fun isPhotoExists(id: Int): Flowable<Boolean>

    companion object {
        private const val TABLE_NAME = "mars_photo_table"
    }

}
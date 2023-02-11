package com.example.nasaapp.db.dao

import androidx.room.*
import com.example.nasaapp.db.model.MarsPhoto

@Dao
interface MarsPhotoDB {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPhoto(marsPhotoDB: MarsPhoto)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPhotos(marsPhotosDB: List<MarsPhoto>)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun updatePhoto(marsPhotoDB: MarsPhoto)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun updatePhotos(marsPhotos: List<MarsPhoto>)

    @Delete
    fun deletePhoto(marsPhoto: MarsPhoto)

    @Query("DELETE FROM $TABLE_NAME")
    fun deleteAllPhotos()

    @Query("SELECT * FROM $TABLE_NAME")
    fun getAllPhotos(): List<MarsPhoto>

    @Query("SELECT * FROM $TABLE_NAME WHERE id = :id LIMIT 1")
    fun getPhoto(id: Int): MarsPhoto

    @Query("SELECT EXISTS(SELECT id FROM $TABLE_NAME WHERE id = :id)")
    fun isPhotoExists(id: Int): Boolean

    companion object {
        private const val TABLE_NAME = "mars_photo_table"
    }

}
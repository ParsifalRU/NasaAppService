package com.example.nasaapp.db.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.nasaapp.db.dao.FavoritePhotoDao
import com.example.nasaapp.db.dao.MarsPhotoDao
import com.example.nasaapp.db.dao.PictureOfTheDayDao
import com.example.nasaapp.db.model.FavoritePhoto
import com.example.nasaapp.db.model.MarsPhoto
import com.example.nasaapp.db.model.PictureOfTheDay


@Database(
    entities = [MarsPhoto::class, FavoritePhoto::class, PictureOfTheDay::class ],
    version = 1,
    exportSchema = false

)
abstract class NasaAppDatabase : RoomDatabase() {

    abstract fun marsDao(): MarsPhotoDao
    abstract fun favouriteDao(): FavoritePhotoDao
    abstract fun pictureDao(): PictureOfTheDayDao

    companion object {
        @Volatile
        private var INSTANCE: NasaAppDatabase? = null

        fun getDatabase(context: Context): NasaAppDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    NasaAppDatabase::class.java,
                    "Nasa_App.db"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}
package com.example.nasaapp.db.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.nasaapp.db.dao.FavoritePhotoDB
import com.example.nasaapp.db.dao.MarsPhotoDB
import com.example.nasaapp.db.dao.PictureOfTheDayDB
import com.example.nasaapp.db.model.PictureOfTheDay


@Database(
    entities = [MarsPhotoDB::class, FavoritePhotoDB::class,PictureOfTheDayDB::class ],
    version = 1,
    exportSchema = false)

abstract class NasaAppDatabase : RoomDatabase() {

    abstract fun marsDao(): MarsPhotoDB
    abstract fun favouriteDao(): FavoritePhotoDB
    abstract fun pictureDao(): PictureOfTheDay

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
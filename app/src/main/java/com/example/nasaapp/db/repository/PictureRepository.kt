package com.example.nasaapp.db.repository

import com.example.nasaapp.db.dao.PictureOfTheDayDB
import com.example.nasaapp.db.model.PictureOfTheDay
import io.reactivex.rxjava3.core.Flowable

class PictureRepository(private val pictureDao: PictureOfTheDayDB) {

    fun insertPicture(picture: PictureOfTheDay):Flowable<PictureOfTheDay>{
        return pictureDao.insertPicture(picture)
    }

    fun insertPictures(pictures: List<PictureOfTheDay>):Flowable<List<PictureOfTheDay>>{
        return pictureDao.insertPictures(pictures)
    }

    fun deletePicture(picture: PictureOfTheDay):Flowable<PictureOfTheDay>{
        return pictureDao.deletePicture(picture)
    }

    fun deleteAllPictures(): Flowable<List<PictureOfTheDay>> {
        return pictureDao.deleteAllPictures()
    }

    fun getAllPictures(): Flowable<List<PictureOfTheDay>>{
        return pictureDao.getAllPictures()
    }

    fun getLastPicture(): Flowable<PictureOfTheDay>{
        return pictureDao.getLastPicture()
    }

    fun isPictureExists(explanation: String): Flowable<Boolean>{
        return pictureDao.isPictureExists(explanation)
    }

    fun getPictureOfDay(id: Int): Flowable<PictureOfTheDay>{
        return pictureDao.getPictureOfDay(id)
    }

}
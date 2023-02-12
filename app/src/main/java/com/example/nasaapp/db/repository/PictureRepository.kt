package com.example.nasaapp.db.repository

import com.example.nasaapp.db.dao.PictureOfTheDayDB
import com.example.nasaapp.db.model.PictureOfTheDay
import io.reactivex.rxjava3.core.Flowable

class PictureRepository(private val pictureDao: PictureOfTheDayDB) {

    fun insertPicture(picture: PictureOfTheDay){
        pictureDao.insertPicture(picture)
    }

    fun insertPictures(pictures: List<PictureOfTheDay>){
        pictureDao.insertPictures(pictures)
    }

    fun deletePicture(picture: PictureOfTheDay){
        pictureDao.deletePicture(picture)
    }

    fun deleteAllPictures(): Flowable<List<PictureOfTheDay>> {
        return pictureDao.deleteAllPictures()
    }

    fun getAllPictures(): List<PictureOfTheDay>{
        return pictureDao.getAllPictures()
    }

    fun getLastPicture(): PictureOfTheDay{
        return pictureDao.getLastPicture()
    }

    fun isPictureExists(explanation: String): Boolean{
        return pictureDao.isPictureExists(explanation)
    }

    fun getPictureOfDay(id: Int): PictureOfTheDay{
        return pictureDao.getPictureOfDay(id)
    }

}
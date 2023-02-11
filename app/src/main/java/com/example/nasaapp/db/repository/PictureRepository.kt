package com.example.nasaapp.db.repository

import com.example.nasaapp.db.dao.PictureOfTheDayDB
import com.example.nasaapp.db.model.PictureOfTheDay

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

    fun deleteAllPictures(){
        pictureDao.deleteAllPictures()
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
package com.example.nasaapp.db.repository

import com.example.nasaapp.db.dao.PictureOfTheDayDB

class PictureRepository(
    private val pictureDao: PictureOfTheDayDB,
) {

    fun insertPicture(picture: PictureOfTheDayDB){
        pictureDao.insertPicture(picture)
    }

    fun insertPictures(pictures: List<PictureOfTheDayDB>){
        pictureDao.insertPictures(pictures)
    }

    fun deletePicture(picture: PictureOfTheDayDB){
        pictureDao.deletePicture(picture)
    }

    fun deleteAllPictures(){
        pictureDao.deleteAllPictures()
    }

    fun getAllPictures(): List<PictureOfTheDayDB>{
        return pictureDao.getAllPictures()
    }

    fun getLastPicture(): PictureOfTheDayDB{
        return pictureDao.getLastPicture()
    }

    fun isPictureExists(explanation: String): Boolean{
        return pictureDao.isPictureExists(explanation)
    }

    fun getPictureOfDay(id: Int): PictureOfTheDayDB{
        return pictureDao.getPictureOfDay(id)
    }

}
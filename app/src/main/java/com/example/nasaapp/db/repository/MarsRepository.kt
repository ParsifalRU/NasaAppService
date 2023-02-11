package com.example.nasaapp.db.repository

import com.example.nasaapp.db.dao.MarsPhotoDB
import com.example.nasaapp.db.model.MarsPhoto

class MarsRepository(private val marsDao: MarsPhotoDB) {

    fun insertPhoto(marsPhoto: MarsPhoto){
        marsDao.insertPhoto(marsPhoto)
    }

    fun insertPhotos(marsPhotos: List<MarsPhoto>){
        marsDao.insertPhotos(marsPhotos)
    }

    fun updatePhoto(marsPhoto: MarsPhoto){
        marsDao.updatePhoto(marsPhoto)
    }

    fun updatePhotos(marsPhotos: List<MarsPhoto>){
        marsDao.updatePhotos(marsPhotos)
    }

    fun deletePhoto(marsPhoto: MarsPhoto){
        marsDao.deletePhoto(marsPhoto)
    }

    fun deleteAllPhotos(){
        marsDao.deleteAllPhotos()
    }

    fun getAllPhotos(): List<MarsPhoto> {
        return marsDao.getAllPhotos()
    }

    fun getPhoto(id: Int): MarsPhoto {
        return marsDao.getPhoto(id)
    }

    fun isPhotoExists(id: Int): Boolean {
        return marsDao.isPhotoExists(id)
    }
}
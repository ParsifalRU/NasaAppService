package com.example.nasaapp.db.repository

import com.example.nasaapp.db.dao.FavoritePhotoDB
import com.example.nasaapp.db.model.FavoritePhoto

class FavoriteRepository(private val favoriteDao: FavoritePhotoDB) {

    fun insertPhoto(photo: FavoritePhoto){
        favoriteDao.insertPhoto(photo)
    }

    fun insertPhotos(photos: List<FavoritePhoto>) {
        favoriteDao.getAllPhotos()
    }

    fun deletePhoto(photo: FavoritePhoto) {
        favoriteDao.deletePhoto(photo)
    }

    fun deleteAll(){
        favoriteDao.getAllPhotos()
    }

    fun getAllPhotos(): List<FavoritePhoto> {
        return favoriteDao.getAllPhotos()
    }

    fun getPhoto(id: Int): FavoritePhoto {
        return favoriteDao.getPhoto(id)
    }

    fun isPhotoExists(id: Int): Boolean {
        return favoriteDao.isPhotoExists(id)
    }
}
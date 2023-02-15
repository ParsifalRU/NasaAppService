package com.example.nasaapp.db.repository

import com.example.nasaapp.db.dao.FavoritePhotoDB
import com.example.nasaapp.db.model.FavoritePhoto
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Flowable

class FavoriteRepository(private val favoriteDao: FavoritePhotoDB) {

    fun insertPhoto(photo: FavoritePhoto): Completable {
        return favoriteDao.insertPhoto(photo)
    }

    fun insertPhotos(photos: List<FavoritePhoto>): Completable {
        return favoriteDao.insertPhotos(photos)
    }

    fun deletePhoto(photo: FavoritePhoto): Completable {
        return favoriteDao.deletePhoto(photo)
    }

    fun deleteAll(): Completable {
        return favoriteDao.deleteAll()
    }

    fun getAllPhotos(): Flowable<List<FavoritePhoto>> {
        return favoriteDao.getAllPhotos()
    }

    fun getPhoto(id: Int): Flowable<FavoritePhoto> {
        return favoriteDao.getPhoto(id)
    }

    fun isPhotoExists(id: Int): Flowable<Boolean> {
        return favoriteDao.isPhotoExists(id)
    }
}
package com.example.nasaapp.db.repository

import com.example.nasaapp.db.dao.MarsPhotoDao
import com.example.nasaapp.db.model.MarsPhoto
import com.example.nasaapp.network.models.ModelOpportunity
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Flowable

class MarsRepository(private val marsDao: MarsPhotoDao) {

    fun insertPhoto(marsPhoto: MarsPhoto): Completable {
        return marsDao.insertPhoto(marsPhoto)
    }

    fun insertPhotos(marsPhotos: List<MarsPhoto>): Completable {
        return marsDao.insertPhotos(marsPhotos)
    }

    fun updatePhoto(marsPhoto: MarsPhoto): Completable {
        return marsDao.updatePhoto(marsPhoto)
    }

    fun updatePhotos(marsPhotos: List<MarsPhoto>): Completable {
        return marsDao.updatePhotos(marsPhotos)
    }

    fun deletePhoto(marsPhoto: MarsPhoto): Completable {
        return marsDao.deletePhoto(marsPhoto)
    }

    fun deleteAllPhotos(): Completable {
        return marsDao.deleteAllPhotos()
    }

    fun getAllPhotos(): Flowable<List<MarsPhoto>> {
        return marsDao.getAllPhotos()
    }

    fun getPhoto(id: Int): Flowable<MarsPhoto> {
        return marsDao.getPhoto(id)
    }

    fun isPhotoExists(id: Int): Flowable<Boolean> {
        return marsDao.isPhotoExists(id)
    }
}
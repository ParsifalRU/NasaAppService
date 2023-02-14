package com.example.nasaapp.db.repository

import com.example.nasaapp.db.dao.MarsPhotoDB
import com.example.nasaapp.db.model.MarsPhoto
import io.reactivex.rxjava3.core.Flowable

class MarsRepository(private val marsDao: MarsPhotoDB) {

    fun insertPhoto(marsPhoto: MarsPhoto):Flowable<MarsPhotoDB>{
        return marsDao.insertPhoto(marsPhoto)
    }

    fun insertPhotos(marsPhotos: List<MarsPhoto>):Flowable<List<MarsPhotoDB>>{
        return marsDao.insertPhotos(marsPhotos)
    }

    fun updatePhoto(marsPhoto: MarsPhoto):Flowable<MarsPhotoDB>{
        return marsDao.updatePhoto(marsPhoto)
    }

    fun updatePhotos(marsPhotos: List<MarsPhoto>):Flowable<List<MarsPhotoDB>>{
        return marsDao.updatePhotos(marsPhotos)
    }

    fun deletePhoto(marsPhoto: MarsPhoto):Flowable<MarsPhotoDB>{
        return marsDao.deletePhoto(marsPhoto)
    }

    fun deleteAllPhotos():Flowable<List<MarsPhotoDB>>{
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
package com.example.nasaapp.db.repository

import com.example.nasaapp.db.dao.MarsPhotoDB
import com.example.nasaapp.db.model.MarsPhoto
import io.reactivex.rxjava3.core.Flowable

class MarsRepository(private val marsDao: MarsPhotoDB) {

    fun insertPhoto(marsPhoto: MarsPhoto):Flowable<MarsPhoto>{
        return marsDao.insertPhoto(marsPhoto)
    }

    fun insertPhotos(marsPhotos: List<MarsPhoto>):Flowable<List<MarsPhoto>>{
        return marsDao.insertPhotos(marsPhotos)
    }

    fun updatePhoto(marsPhoto: MarsPhoto):Flowable<MarsPhoto>{
        return marsDao.updatePhoto(marsPhoto)
    }

    fun updatePhotos(marsPhotos: List<MarsPhoto>):Flowable<List<MarsPhoto>>{
        return marsDao.updatePhotos(marsPhotos)
    }

    fun deletePhoto(marsPhoto: MarsPhoto):Flowable<MarsPhoto>{
        return marsDao.deletePhoto(marsPhoto)
    }

    fun deleteAllPhotos():Flowable<List<MarsPhoto>>{
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
package com.example.nasaapp.ui.fragments.view_model

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import com.example.nasaapp.db.database.NasaAppDatabase
import com.example.nasaapp.db.model.FavoritePhoto
import com.example.nasaapp.db.repository.FavoriteRepository
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable

class ViewModelFavoritePhoto(application: Application): AndroidViewModel(application) {

    private val compositeDisposable = CompositeDisposable()
    lateinit var repository: FavoriteRepository

    init {
        val favoriteDao = NasaAppDatabase.getDatabase(application).favouriteDao()
        val repository = FavoriteRepository(favoriteDao)
    }

    fun insertPhoto(photo: FavoritePhoto) {
        compositeDisposable.add(
            repository.insertPhoto(photo)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    Log.d("LOGTAG", "insert photo ($photo)") }
        )
    }

    fun insertPhotos(photos: List<FavoritePhoto>) {
        compositeDisposable.add(
            repository.insertPhotos(photos)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    Log.d("LOGTAG", "insert photos ($photos)") }
        )
    }

    fun deletePhoto(photo: FavoritePhoto) {
        compositeDisposable.add(
            repository.deletePhoto(photo)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    Log.d("LOGTAG", "delete photo ($photo)") }
        )
    }

    fun deleteAll(){
        compositeDisposable.add(
            repository.deleteAll()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    Log.d("LOGTAG", "delete all photo") }
        )
    }

    fun getAllPhotos() {
        compositeDisposable.add(
            repository.getAllPhotos()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    Log.d("LOGTAG", "get all photos ") }
        )
    }

    fun getPhoto(id: Int) {
        compositeDisposable.add(
            repository.getPhoto(id)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    Log.d("LOGTAG", "get photo ($id)") }
        )
    }

    fun isPhotoExists(id: Int){
        compositeDisposable.add(
            repository.isPhotoExists(id)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    Log.d("LOGTAG", "is Photo exists ($id)") }
        )
    }

    override fun onCleared() {
        compositeDisposable.clear()
        super.onCleared()
    }

}
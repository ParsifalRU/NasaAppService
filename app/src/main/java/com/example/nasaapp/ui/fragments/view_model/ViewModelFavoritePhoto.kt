package com.example.nasaapp.ui.fragments.view_model

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import com.example.nasaapp.db.database.NasaAppDatabase
import com.example.nasaapp.db.model.FavoritePhoto
import com.example.nasaapp.db.repository.FavoriteRepository
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.observers.DisposableCompletableObserver
import io.reactivex.rxjava3.schedulers.Schedulers

class ViewModelFavoritePhoto(application: Application): AndroidViewModel(application) {

    private val compositeDisposable = CompositeDisposable()
    lateinit var repository: FavoriteRepository

    init {
        val favoriteDao = NasaAppDatabase.getDatabase(application).favouriteDao()
        repository = FavoriteRepository(favoriteDao)
    }

    fun insertPhoto(photo: FavoritePhoto) {
        compositeDisposable.add(
            repository.insertPhoto(photo)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe() {
                    Log.d("LOGTAG", "insert photo ($photo)") }
        )
    }

    fun insertPhotos(photos: List<FavoritePhoto>) {
        compositeDisposable.add(
            repository.insertPhotos(photos)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object: DisposableCompletableObserver(){
                    override fun onComplete() {
                        Log.d("LOGTAG", "insert onComplete ")
                    }

                    override fun onError(e: Throwable) {
                        Log.d("LOGTAG", "insert onError $e")
                    }

                })

        )
    }

    fun deletePhoto(photo: FavoritePhoto) {
        compositeDisposable.add(
            repository.deletePhoto(photo)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object: DisposableCompletableObserver(){
                    override fun onComplete() {
                        Log.d("LOGTAG", "delete onComplete $photo ")
                    }

                    override fun onError(e: Throwable) {
                        Log.d("LOGTAG", "delete onError $e")
                    }

                })
        )
    }

    fun deleteAll(){
        compositeDisposable.add(
            repository.deleteAll()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object: DisposableCompletableObserver(){
                    override fun onComplete() {
                        Log.d("LOGTAG", "delete all onComplete ")
                    }

                    override fun onError(e: Throwable) {
                        Log.d("LOGTAG", "delete all onError $e")
                    }

                })
        )
    }

    fun getAllPhotos() {
        compositeDisposable.add(
            repository.getAllPhotos()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {data ->
                    Log.d("LOGTAG", "get all photos ($data)") }
        )
    }

    fun getPhoto(id: Int) {
        compositeDisposable.add(
            repository.getPhoto(id)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {data ->
                    Log.d("LOGTAG", "get photo ($data)") }
        )
    }

    fun isPhotoExists(id: Int){
        compositeDisposable.add(
            repository.isPhotoExists(id)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {data ->
                    Log.d("LOGTAG", "is Photo exists ($data)") }
        )
    }

    override fun onCleared() {
        compositeDisposable.clear()
        super.onCleared()
    }
}


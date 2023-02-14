package com.example.nasaapp.ui.fragments.view_model

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.nasaapp.db.database.NasaAppDatabase
import com.example.nasaapp.db.model.MarsPhoto
import com.example.nasaapp.db.repository.MarsRepository
import com.example.nasaapp.network.api.NasaPhotoApi
import com.example.nasaapp.network.models.ModelOpportunity
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.observers.DisposableSingleObserver
import io.reactivex.rxjava3.schedulers.Schedulers

class ViewModelNewMarsPhoto(application: Application): AndroidViewModel(application) {

    private val compositeDisposable = CompositeDisposable()
    lateinit var repository: MarsRepository

    init {
        val marsDao = NasaAppDatabase.getDatabase(application).marsDao()
        val repository = MarsRepository(marsDao)
    }

    var liveDataNewMarsPhoto = MutableLiveData<ModelOpportunity>()

    fun getCuriosityMarsPhotosFromEarthDate(nasaPhotoApi: NasaPhotoApi) {

        Log.d("LOGTAG", "getMarsPhoto")
        compositeDisposable.add(nasaPhotoApi.getCuriosityMarsPhotosFromEarthDate()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(object: DisposableSingleObserver<ModelOpportunity>(){
                override fun onSuccess(t: ModelOpportunity) {
                    liveDataNewMarsPhoto.value = t
                    Log.d("LOGTAG", "ViewModel new Mars Photo $t")
                }
                override fun onError(e: Throwable) {
                    Log.d("LOGTAG", "ViewModel new Mars Photo $e")
                }
            })
        )
    }

    fun insertPhoto(marsPhoto: MarsPhoto){
        compositeDisposable.add(
            repository.insertPhoto(marsPhoto)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    Log.d("LOGTAG", "insert photo ($marsPhoto)") }
        )
    }

    fun insertPhotos(marsPhotos: List<MarsPhoto>){
        compositeDisposable.add(
            repository.insertPhotos(marsPhotos)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    Log.d("LOGTAG", "insert photos ($marsPhotos)") }
        )
    }

    fun updatePhoto(marsPhoto: MarsPhoto){
        compositeDisposable.add(
            repository.updatePhoto(marsPhoto)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    Log.d("LOGTAG", "update photo ($marsPhoto)") }
        )
    }

    fun updatePhotos(marsPhotos: List<MarsPhoto>){
        compositeDisposable.add(
            repository.updatePhotos(marsPhotos)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    Log.d("LOGTAG", "update photos ($marsPhotos)") }
        )
    }

    fun deletePhoto(marsPhoto: MarsPhoto){
        compositeDisposable.add(
            repository.deletePhoto(marsPhoto)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    Log.d("LOGTAG", "delete photo ($marsPhoto)") }
        )
    }

    fun deleteAllPhotos(){
        compositeDisposable.add(
            repository.deleteAllPhotos()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    Log.d("LOGTAG", "Delete All Pictures") }
        )
    }

    fun getAllPhotos() {
        compositeDisposable.add(
            repository.getAllPhotos()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    Log.d("LOGTAG", "get all photos") }
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

    fun isPhotoExists(id: Int) {
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

package com.example.nasaapp.ui.fragments.view_model

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.nasaapp.network.api.NasaPhotoApi
import com.example.nasaapp.network.models.ModelOpportunity
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.observers.DisposableSingleObserver
import io.reactivex.rxjava3.schedulers.Schedulers

class ViewModelNewMarsPhoto: ViewModel() {

    private val compositeDisposable = CompositeDisposable()

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

    override fun onCleared() {
        compositeDisposable.clear()
        super.onCleared()
    }







}

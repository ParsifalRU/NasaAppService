package com.example.nasaapp.ui.fragments.view_model

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.nasaapp.network.api.NasaPhotoApi
import com.example.nasaapp.network.models.ModelPictOfTheDay
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.observers.DisposableSingleObserver
import io.reactivex.rxjava3.schedulers.Schedulers

class ViewModelPictureOfTheDay() : ViewModel() {

    private val compositeDisposable = CompositeDisposable()

    var livedataPictureOfTheDay = MutableLiveData<List<ModelPictOfTheDay>>()

    fun getMarsPhotos(nasaPhotoApi: NasaPhotoApi) {

        Log.d("LOGTAG", "getMarsPhoto")
            compositeDisposable.add(nasaPhotoApi.getPhotos()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object: DisposableSingleObserver<List<ModelPictOfTheDay>>(){
                    override fun onSuccess(t: List<ModelPictOfTheDay>) {
                        livedataPictureOfTheDay.value = t
                        Log.d("LOGTAG", "ViewModel $t")
                    }
                    override fun onError(e: Throwable) {
                        Log.d("LOGTAG", "ViewModel $e")
                    }

                })
            )
        }

    override fun onCleared() {
        compositeDisposable.clear()
        super.onCleared()
    }

}

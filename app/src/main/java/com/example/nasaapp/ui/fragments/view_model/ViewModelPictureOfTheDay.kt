package com.example.nasaapp.ui.fragments.view_model

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.nasaapp.db.database.NasaAppDatabase
import com.example.nasaapp.db.model.PictureOfTheDay
import com.example.nasaapp.db.repository.PictureRepository
import com.example.nasaapp.network.api.NasaPhotoApi
import com.example.nasaapp.network.models.ModelPictOfTheDay
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.observers.DisposableSingleObserver
import io.reactivex.rxjava3.schedulers.Schedulers

class ViewModelPictureOfTheDay(application: Application) : AndroidViewModel(application) {

    private val compositeDisposable = CompositeDisposable()
    lateinit var repository: PictureRepository

    init {
        val pictureDao = NasaAppDatabase.getDatabase(application).pictureDao()
        val repository = PictureRepository(pictureDao)
    }

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

    fun insertPicture(picture: PictureOfTheDay){
        compositeDisposable.add(
            repository.insertPicture(picture)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    Log.d("LOGTAG", "insert Picture Complete ($picture)") }
        )
    }

    fun insertPictures(pictures: List<PictureOfTheDay>){
        compositeDisposable.add(
            repository.insertPictures(pictures)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    Log.d("LOGTAG", "insert Pictures Complete ($pictures)") }
        )
    }

    fun deletePicture(picture: PictureOfTheDay){
        compositeDisposable.add(
            repository.deletePicture(picture)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    Log.d("LOGTAG", "delete Picture Complete ($picture)") }
        )
    }

    fun deleteAllPictures(){
        compositeDisposable.add(
            repository.deleteAllPictures()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    Log.d("LOGTAG", "delete All Pictures Complete") }
        )
    }

    fun getAllPictures(){
        compositeDisposable.add(
            repository.getAllPictures()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    Log.d("LOGTAG", "GET All Pictures Complete") }
        )
    }

    fun getLastPicture(){
        compositeDisposable.add(
            repository.getLastPicture()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    Log.d("LOGTAG", "get last picture") }
        )
    }

    fun isPictureExists(explanation: String){
        compositeDisposable.add(
            repository.isPictureExists(explanation)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    Log.d("LOGTAG", "Picture exists ($explanation)") }
        )
    }

    fun getPictureOfDay(id: Int){
        compositeDisposable.add(
            repository.getPictureOfDay(id)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe{
                    Log.d("LOGTAG", "get Picture ($id)") }
        )
    }



    override fun onCleared() {
        compositeDisposable.clear()
        super.onCleared()
    }

}

package sw.sample.designpattern.mvvm.repository

import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

import sw.sample.designpattern.RetrofitManager
import sw.sample.designpattern.mvvm.model.Image


class ImageRepositoryImpl: ImageRepository {
    override fun getRandomImage() = RetrofitManager.imageService.getRandomImageRx()
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .flatMap {
            Single.just(Image(it.urls.regular, it.color))
        }

}




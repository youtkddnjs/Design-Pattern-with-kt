package sw.sample.designpattern.mvvm.repository

import io.reactivex.Single
import sw.sample.designpattern.mvvm.model.Image

interface ImageRepository {

    fun getRandomImage(): Single<Image>
}
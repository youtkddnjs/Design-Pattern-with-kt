package sw.sample.designpattern.mvi.repository

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import sw.sample.designpattern.RetrofitManager
import sw.sample.designpattern.mvi.model.Image

class ImageReposityroyImpl(private val dispatcher: CoroutineDispatcher = Dispatchers.IO) : ImageRepository {
    override suspend fun getRandomImage() = withContext(dispatcher){
        RetrofitManager.imageService.getRandomImageSuspend().let {
            Image(it.urls.regular, it.color)
        }
    }
}
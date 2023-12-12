package sw.sample.designpattern.mvp.repository

import retrofit2.Call
import retrofit2.Response
import sw.sample.designpattern.ImageResponse
import sw.sample.designpattern.RetrofitManager
import sw.sample.designpattern.mvp.MvpPresenter

class ImageRepositoryImpl: ImageRepository {
    override fun getRandomImage(callBack: MvpPresenter) {
        RetrofitManager.imageService.getRandomImage()
            .enqueue(object : retrofit2.Callback<ImageResponse>{
                override fun onResponse(
                    call: Call<ImageResponse>,
                    response: Response<ImageResponse>
                ) {
                    if(response.isSuccessful){
                        response.body()?.let{
                            callBack.loadImage(it.urls.regular, it.color)
                        }
                    }
                }

                override fun onFailure(call: Call<ImageResponse>, t: Throwable) {
                    TODO("Not yet implemented")
                }
            })
    }
}
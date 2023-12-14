package sw.sample.designpattern

import io.reactivex.Single
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

interface ImageService {

    @Headers("Authorization: Client-ID yFq6Ivg0D4Cg-5M8P8W9llQ0wD-N_jTZ4jw2hudwCHk")
    @GET("photos/random")
    fun getRandomImage() : Call<ImageResponse>

    @Headers("Authorization: Client-ID yFq6Ivg0D4Cg-5M8P8W9llQ0wD-N_jTZ4jw2hudwCHk")
    @GET("photos/random")
    fun getRandomImageRx() : Single<ImageResponse>

    @Headers("Authorization: Client-ID yFq6Ivg0D4Cg-5M8P8W9llQ0wD-N_jTZ4jw2hudwCHk")
    @GET("photos/random")
    suspend fun getRandomImageSuspend() : ImageResponse
}
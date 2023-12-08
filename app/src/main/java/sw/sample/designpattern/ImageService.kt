package sw.sample.designpattern

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

interface ImageService {

    @Headers("Authorization: Client-ID yFq6Ivg0D4Cg-5M8P8W9llQ0wD-N_jTZ4jw2hudwCHk")
    @GET("photos/random")
    fun getRandomImage() : Call<ImageResponse>
}
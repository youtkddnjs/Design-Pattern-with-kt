package sw.sample.designpattern.mvi.repository

import sw.sample.designpattern.mvi.model.Image

interface ImageRepository {
    suspend fun getRandomImage() : Image
}
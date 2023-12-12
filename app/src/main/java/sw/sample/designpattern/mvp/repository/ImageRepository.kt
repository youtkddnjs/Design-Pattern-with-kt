package sw.sample.designpattern.mvp.repository

import sw.sample.designpattern.mvp.MvpPresenter

interface ImageRepository {

    fun getRandomImage(callBack: MvpPresenter){

    }

    interface CallBack{
        fun loadImage(url:String, color:String)
    }
}
package sw.sample.designpattern.mvp

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import coil.load
import sw.sample.designpattern.databinding.ActivityMvcBinding
import sw.sample.designpattern.databinding.ActivityMvpBinding
import sw.sample.designpattern.mvp.model.ImageCountModel
import sw.sample.designpattern.mvp.repository.ImageRepositoryImpl

class MvpActivity:AppCompatActivity(),MvpContractor.View {

    private lateinit var binding:ActivityMvpBinding
    private lateinit var presenter: MvpContractor.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMvpBinding.inflate(layoutInflater).also {
            setContentView(it.root)
            it.view = this
        }//binding = ActivityMvpBinding.inflate(layoutInflater).also

        presenter = MvpPresenter(ImageCountModel(), ImageRepositoryImpl())
        presenter.attachView(this)
    }//override fun onCreate(savedInstanceState: Bundle?)

    override fun onDestroy() {
        presenter.detachView()
        super.onDestroy()
    }

    fun loadImage(){
        presenter.loadRandomImage()
    }

    override fun showImaage(url: String, color: String) {
        binding.imageView.run{
            setBackgroundColor(Color.parseColor(color))
            load(url){
                crossfade(300)
            }
        }
    }

    override fun showImageCountText(count: Int) {
        binding.imagecountTV.text = "불러온 이미지 : ${count}"
    }
}
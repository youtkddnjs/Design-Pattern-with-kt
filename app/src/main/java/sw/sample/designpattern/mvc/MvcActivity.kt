package sw.sample.designpattern.mvc

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import coil.load
import sw.sample.designpattern.databinding.ActivityMvcBinding
import sw.sample.designpattern.mvc.provider.ImageProvider

class MvcActivity: AppCompatActivity(), ImageProvider.Callback {//class MvcActivity: AppCompatActivity()
    lateinit var binding: ActivityMvcBinding

    private val model = ImageCountModel()
    private val imageprovider = ImageProvider(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMvcBinding.inflate(layoutInflater).also {
            setContentView(it.root)
            it.view = this
        }//binding = ActivityMvcBinding.inflate(layoutInflater).also
    }//override fun onCreate(savedInstanceState: Bundle?)

    fun loadImage(){
        Log.d("swLog", "mvcActivity loadImage")
        imageprovider.getRandomImage()
    }

    override fun loadImage(url: String, color: String) {
        model.increase()
        with(binding){
            imageView.run {
                setBackgroundColor(Color.parseColor(color))
                load(url)
            }
            imagecountTV.text="불러온 이미지 : ${model.count}"
        }
    }
}
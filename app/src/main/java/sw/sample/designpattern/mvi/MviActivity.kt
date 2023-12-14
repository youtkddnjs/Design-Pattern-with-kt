package sw.sample.designpattern.mvi

import android.graphics.Color
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import coil.load
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import sw.sample.designpattern.databinding.ActivityMainBinding
import sw.sample.designpattern.databinding.ActivityMviBinding
import sw.sample.designpattern.mvi.repository.ImageReposityroyImpl

class MviActivity:AppCompatActivity() {

    private lateinit var binding : ActivityMviBinding

    private val viewModel : MviViewModel by viewModels{
        MviViewModel.MviViewModelFactory(ImageReposityroyImpl())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMviBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.view = this
        observeViewModel()
    }

    fun loadImage(){
        lifecycleScope.launch {
            viewModel.channel.send(MviIntent.LoadImage)
        }
    }

    private fun observeViewModel(){
        lifecycleScope.launch {
            viewModel.state.collectLatest { state ->
                when(state){
                    is MviState.Idle ->{
                        binding.progressView.isVisible = false
                    }
                    is MviState.Loading -> {
                        binding.progressView.isVisible = true
                    }
                    is MviState.LoadedImage -> {
                        binding.progressView.isVisible = false
                        binding.imageView.run{
                            setBackgroundColor(Color.parseColor(state.image.color))
                            load(state.image.url){
                                crossfade(300)
                            }
                        }
                        binding.imagecountTV.text = "불러온 이미지 : ${state.count}"
                    }
                }
            }
        }
    }

}
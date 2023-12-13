package sw.sample.designpattern.mvvm

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import sw.sample.designpattern.databinding.ActivityMvvmBinding
import sw.sample.designpattern.mvvm.repository.ImageRepositoryImpl

class MvvmActivity: AppCompatActivity() {

    private lateinit var binding: ActivityMvvmBinding

    private val viewModel : MvvmViewModel by viewModels{
        MvvmViewModel.MvvmViewModelFactory(ImageRepositoryImpl())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMvvmBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.view = this
        binding.lifecycleOwner = this
        binding.viewModel = viewModel


    }//override fun onCreate(savedInstanceState: Bundle?)


    fun loadImage(){
        viewModel.loadRandomImage()
    }

}//class MvvmActivity: AppCompatActivity()
package sw.sample.designpattern.mvvm

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import sw.sample.designpattern.databinding.ActivityMvvmBinding

class MvvmActivity: AppCompatActivity() {

    private lateinit var binding: ActivityMvvmBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMvvmBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.view = this



    }//override fun onCreate(savedInstanceState: Bundle?)


    fun loadImage(){

    }

}//class MvvmActivity: AppCompatActivity()
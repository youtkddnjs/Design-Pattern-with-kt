package sw.sample.designpattern

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import sw.sample.designpattern.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).apply {
            setContentView(this.root)
            this.view = this@MainActivity
        }



    }//override fun onCreate(savedInstanceState: Bundle?)

    fun openMvc(){}
    fun openMvp(){}
    fun openMvvm(){}
    fun openMvi(){}



}//class MainActivity : AppCompatActivity()
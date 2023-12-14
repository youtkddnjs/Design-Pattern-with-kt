package sw.sample.designpattern

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import sw.sample.designpattern.databinding.ActivityMainBinding
import sw.sample.designpattern.mvc.MvcActivity
import sw.sample.designpattern.mvi.MviActivity
import sw.sample.designpattern.mvp.MvpActivity
import sw.sample.designpattern.mvvm.MvvmActivity

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).apply {
            setContentView(this.root)
            this.view = this@MainActivity
        }



    }//override fun onCreate(savedInstanceState: Bundle?)

    fun openMvc(){
        startActivity(Intent(this, MvcActivity::class.java))
    }
    fun openMvp(){
        startActivity(Intent(this, MvpActivity::class.java))
    }
    fun openMvvm(){
        startActivity(Intent(this, MvvmActivity::class.java))
    }
    fun openMvi(){
        startActivity(Intent(this, MviActivity::class.java))
    }



}//class MainActivity : AppCompatActivity()
package my.edu.tarc.demointent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import my.edu.tarc.demointent.databinding.ActivityMainBinding
import my.edu.tarc.demointent.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivitySecondBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.buttonClose.setOnClickListener {
            finish()
        }

        Log.d("Second", "onCreate")
    }

    override fun onStop() {
        Log.d("Second", "onStop")
        super.onStop()
    }
}
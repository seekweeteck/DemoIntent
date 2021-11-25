package my.edu.tarc.demointent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import my.edu.tarc.demointent.databinding.ActivityThirdBinding

class ThirdActivity : AppCompatActivity() {
    private lateinit var binding : ActivityThirdBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityThirdBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonClose2.setOnClickListener {
            val intent = getIntent() //to get the calling intent
            val name = binding.editTextTextPersonName.text.toString()

            if(name.isNullOrEmpty()){
                setResult(RESULT_CANCELED, intent)
            }else{
                intent.putExtra(MainActivity.EXTRA_NAME, name)
                intent.putExtra("email", "seekt@tarc.edu.my")
                setResult(RESULT_OK, intent)
            }

            finish()
        }
    }
}
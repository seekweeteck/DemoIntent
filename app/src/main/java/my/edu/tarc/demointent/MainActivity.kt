package my.edu.tarc.demointent

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import com.google.android.material.snackbar.Snackbar
import my.edu.tarc.demointent.databinding.ActivityMainBinding
import my.edu.tarc.demointent.databinding.ActivitySecondBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    //Explicit Intent
    private val getExtra = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){ result ->
        if(result.resultCode == RESULT_OK){
            val data = result.data
            val name = data?.getStringExtra(EXTRA_NAME)

            if(name.isNullOrBlank()) {
                binding.textViewResult.text = getString(R.string.no_value)
            }else
                binding.textViewResult.text = name.toString()
        }
    }

    //Implicit Intent
    private val getPhoto = registerForActivityResult(ActivityResultContracts.GetContent()){ uri ->
        if(uri != null){
            binding.imageViewPhoto.setImageURI(uri)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonStartAnActivity.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }

        binding.buttonStartForResult.setOnClickListener {
            val intent = Intent(this, ThirdActivity::class.java)
            getExtra.launch(intent)
        }

        binding.buttonPicture.setOnClickListener {
            getPhoto.launch("image/*")
        }

        binding.buttonWeb.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("https://www.tarc.edu.my")
            startActivity(intent)
            /*if(intent.resolveActivity(packageManager)!= null){
                startActivity(intent)
            }else{
                Snackbar.make(binding.root, R.string.no_app, Snackbar.LENGTH_SHORT).show()
            }*/
        }

        binding.buttonSendText.setOnClickListener {
            //Send a message using an Implicit Intent
            //The ShareActivity has an intent-filter to handle plain text - refer to the manifest file
            val intent = Intent(Intent.ACTION_SEND)
            intent.setType("text/plain")
            intent.putExtra(Intent.EXTRA_TEXT, "My message")
            startActivity(intent)
        }
    }

    companion object{
        //A global variable
        const val EXTRA_NAME = "my.edu.tarc.demointent.NAME"
        const val EXTRA_EMAIL = "my.edu.tarc.demointent.EMAIL"
    }
}
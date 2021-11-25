package my.edu.tarc.demointent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ShareActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_share)

        val message = intent.getStringExtra(Intent.EXTRA_TEXT)
        val textViewMessage = findViewById<TextView>(R.id.textViewSendMessage)
        textViewMessage.text = message
    }
}
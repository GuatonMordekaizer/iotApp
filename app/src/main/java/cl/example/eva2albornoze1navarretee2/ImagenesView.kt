package cl.example.eva2albornoze1navarretee2

import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth

class ImagenesView : AppCompatActivity() {

    private lateinit var mp: MediaPlayer
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_imagenes_view)
        auth = Firebase.auth


        val btnCat = findViewById<ImageButton>(R.id.botonImagen)

        btnCat.setOnClickListener {

            mp = MediaPlayer.create(this, R.raw.sonido1)
            mp.start()
        }

        val btnBt = findViewById<ImageButton>(R.id.botonImagen2)

        findViewById<Button>(R.id.botonImagen2).setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }

    }


}
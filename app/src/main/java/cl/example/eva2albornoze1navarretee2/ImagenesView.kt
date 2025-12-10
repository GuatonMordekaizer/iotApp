package cl.example.eva2albornoze1navarretee2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth

class ImagenesView : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_imagenes_view)
        auth = Firebase.auth
        findViewById<Button>(R.id.btnVolver).setOnClickListener {
            auth.signOut()
            startActivity(Intent(this, LoginView::class.java))
            finish()
        }
    }
}
package cl.example.eva2albornoze1navarretee2

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth

class SplashView : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_splash_view)
        auth = Firebase.auth

        Handler(Looper.getMainLooper()).postDelayed({
            verificarSesion()
        }, 2000)
    }

    private fun verificarSesion() {
        val usuarioActual = auth.currentUser
        if (usuarioActual != null) {
            startActivity(Intent(this, ImagenesView::class.java))
        } else {
            startActivity(Intent(this, LoginView::class.java))
        }
        finish()
    }
}
package cl.example.eva2albornoze1navarretee2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth

class LoginView : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login_view)
        auth = Firebase.auth

        val editUsuario = findViewById<EditText>(R.id.inputUsuario)
        val editClave = findViewById<EditText>(R.id.inputClave)
        val btnIniciarSesion = findViewById<Button>(R.id.botonIniciarSesion)

        btnIniciarSesion.setOnClickListener {
            val usuarioIngresado = editUsuario.text.toString()
            val claveIngresada = editClave.text.toString()

            if (usuarioIngresado.isEmpty() || claveIngresada.isEmpty()) {
                Toast.makeText(this, "Ingrese datos en los dos campos", Toast.LENGTH_SHORT).show()
            } else {
                iniciarSesion(usuarioIngresado, claveIngresada)
            }

            editUsuario.setText("")
            editClave.setText("")
        }
    }

    private fun iniciarSesion(usuario: String, clave: String) {
        auth.signInWithEmailAndPassword(usuario, clave)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    Toast.makeText(this, "Bienvenido", Toast.LENGTH_SHORT).show()
                    startActivity(Intent(this, ImagenesView::class.java))
                    finish()
                } else {
                    Toast.makeText(this, "Credenciales Incorrectas", Toast.LENGTH_SHORT).show()
                }
            }
    }
}
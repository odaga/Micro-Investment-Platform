package com.miroinvest.testproject.ui.auth

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.gms.tasks.Task
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import com.miroinvest.testproject.MainActivity
import com.miroinvest.testproject.R
import com.miroinvest.testproject.core.BaseActivity
import com.miroinvest.testproject.databinding.ActivityLoginBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginActivity : BaseActivity() {
    private val auth = Firebase.auth
    private lateinit var binding: ActivityLoginBinding
    private val viewModel: AuthViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        with(binding) {
            btnSignIn.setOnClickListener {

                if (emailField.text.toString().isBlank()) {
                    emailFieldLayout.error = "Email is required"
                } else if (passwordField.text.toString().isBlank()) {
                    passwordFieldLayout.error = "Password is required."
                } else {
                    startAuthFlow(emailField.text.toString(), passwordField.text.toString())
                }
            }
        }
    }

    private fun startAuthFlow(email: String, password: String) {
        showProgressDialog()
        auth.signInWithEmailAndPassword(email, password).addOnCompleteListener { task ->
            hideProgressDialog()
            if (task.isSuccessful) {
                startActivity(Intent(this@LoginActivity, MainActivity::class.java))
                finish()
            } else {
                task.exception?.localizedMessage?.let { showErrorDialog(it) }
            }
        }
            .addOnFailureListener { exception ->
                hideProgressDialog()
                exception.message?.let { showErrorDialog(it) }
            }
    }

    override fun onStart() {
        super.onStart()
        if (auth.currentUser != null) {
            startActivity(Intent(this@LoginActivity, MainActivity::class.java))
            finish()
        }
    }

}
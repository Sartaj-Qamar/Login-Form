package com.codetech.loginform

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.codetech.loginform.databinding.ActivitySignInBinding
import com.google.firebase.auth.FirebaseAuth

class SignIn : AppCompatActivity() {
    private lateinit var binding: ActivitySignInBinding
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignInBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth = FirebaseAuth.getInstance()
        binding.textView.setOnClickListener {
            val intent = Intent(this,SignUp::class.java)
            startActivity(intent)
        }
         binding.button.setOnClickListener {
             val email = binding.emailEt.text.toString()
             val pass = binding.passET.text.toString()

             if (email.isNotEmpty() && pass.isNotEmpty()) {

                     firebaseAuth.signInWithEmailAndPassword(email,pass).addOnCompleteListener{
                         if (it.isSuccessful){
                             val intent = Intent(this,MainActivity::class.java)
                             startActivity(intent)
                         }

                         else{
                             Toast.makeText(this, it.exception.toString(), Toast.LENGTH_SHORT).show()
                         }
                     }

                 }
                 else
                 {
                     Toast.makeText(this, "Password is not matching", Toast.LENGTH_SHORT).show()
                 }
             }

         }

    }



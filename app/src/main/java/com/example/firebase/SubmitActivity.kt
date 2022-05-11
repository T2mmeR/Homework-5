package com.example.firebase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class SubmitActivity : AppCompatActivity() {

    private lateinit var submitEmail : EditText
    private lateinit var submitPassword : EditText
    private lateinit var submitButton : Button
    private lateinit var submitHome : Button

    private lateinit var mAuth : FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_submit)

        mAuth = FirebaseAuth.getInstance()
        submitEmail = findViewById(R.id.submitEmail)
        submitPassword = findViewById(R.id.submitPassword)
        submitButton =  findViewById(R.id.submitButton)
        submitHome = findViewById(R.id.submitHome)

        submitHome.setOnClickListener{
            startActivity(Intent(this,MainActivity::class.java))
        }





        submitButton.setOnClickListener {

            val email = submitEmail.text.toString()
            val password = submitPassword.text.toString()
            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Wrong Parameters ", Toast.LENGTH_SHORT).show()
            } else {
                mAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            mAuth.signOut()
                            startActivity(Intent(this,SubmitActivity::class.java))
                            finish()
                            Toast.makeText(this, "Account Added", Toast.LENGTH_LONG).show()
                        } else {
                            Toast.makeText(this, "Error ! ", Toast.LENGTH_LONG).show()
                        }


                    }


            }
        }
    }
}
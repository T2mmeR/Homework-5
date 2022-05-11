package com.example.firebase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth

class UserLogin : AppCompatActivity() {

    private lateinit var userText: TextView
    private lateinit var userOut: Button
    private lateinit var userChange : Button
    private lateinit var mAuth : FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_login)
        mAuth = FirebaseAuth.getInstance()

        userText = findViewById(R.id.userTextView)
        userOut = findViewById(R.id.userLogout)
        userChange = findViewById(R.id.userChangePassword)


        userText.text = mAuth.currentUser?.uid


        userOut.setOnClickListener{
            mAuth.signOut()
            startActivity(Intent(this,MainActivity::class.java))
            finish()
        }

        userChange.setOnClickListener{
            startActivity(Intent(this,ChangePassword::class.java))
        }



    }
}
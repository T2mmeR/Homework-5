package com.example.firebase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class LostPassword : AppCompatActivity() {

    private lateinit var recoverEmail : EditText
    private lateinit var recoverButton : Button

    private lateinit var mAuth : FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lost_password)

        mAuth = FirebaseAuth.getInstance()

        recoverEmail = findViewById(R.id.recoverEmail)
        recoverButton = findViewById(R.id.recoverButton)

        recoverButton.setOnClickListener{
            val email = recoverEmail.text.toString()
            if (email.isEmpty()){
                Toast.makeText(this,"Empty ! ",Toast.LENGTH_LONG).show()
            } else {
                mAuth.sendPasswordResetEmail(email).addOnCompleteListener { task ->
                    if (task.isSuccessful){
                        startActivity(Intent(this,MainActivity::class.java))
                        finish()
                    }else {
                        Toast.makeText(this,"Error! ", Toast.LENGTH_LONG).show()
                    }

                }

            }
        }




    }
}
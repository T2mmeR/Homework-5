package com.example.firebase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class ChangePassword : AppCompatActivity() {


    private lateinit var changeEmail : EditText
    private lateinit var changeButton : Button
    private lateinit var mAuth : FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_change_password)
        mAuth = FirebaseAuth.getInstance()


        changeEmail = findViewById(R.id.changeEmail)
        changeButton = findViewById(R.id.changeButton)

        changeButton.setOnClickListener{
            val nPassword = changeEmail.text.toString()
            if (nPassword.isEmpty()){
                Toast.makeText(this,"Empty ! ",Toast.LENGTH_LONG).show()
            } else {
                mAuth.currentUser?.updatePassword(nPassword)?.addOnCompleteListener{ task ->
                    if (task.isSuccessful){
                        startActivity(Intent(this,UserLogin::class.java))
                        finish()
                    } else {
                        Toast.makeText(this,"Sorry Try Again ",Toast.LENGTH_LONG).show()
                    }
                }
            }


        }


    }
}
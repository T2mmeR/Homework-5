package com.example.firebase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class Registration : AppCompatActivity() {

    private lateinit var inputEmail : EditText
    private lateinit var inputPass : EditText
    private lateinit var inputPass1: EditText
    private lateinit var checkBox : CheckBox
    private lateinit var registration : Button

    private lateinit var mAuth : FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)

        mAuth = FirebaseAuth.getInstance()

        inputEmail = findViewById(R.id.inputRegEmail)
        inputPass = findViewById(R.id.inputRegPass)
        inputPass1 = findViewById(R.id.inputRegPass1)
        checkBox = findViewById(R.id.checkBox)
        registration = findViewById(R.id.registration)


        registration.setOnClickListener{
            val email = inputEmail.text.toString()
            val password = inputPass.text.toString()
            val password1 = inputPass1.text.toString()

            if (email.isEmpty() || password.isEmpty() || password1.isEmpty() || password != password1 || !(checkBox.isChecked)){

                Toast.makeText(this,"Error!",Toast.LENGTH_LONG).show()
            } else {
                mAuth.createUserWithEmailAndPassword(email,password1).addOnCompleteListener{ task ->
                    if (task.isSuccessful){
                        startActivity(Intent(this,MainActivity::class.java))
                        finish()
                    } else {
                        Toast.makeText(this,"Error ! ",Toast.LENGTH_LONG).show()
                    }
                }
            }


        }



    }
}
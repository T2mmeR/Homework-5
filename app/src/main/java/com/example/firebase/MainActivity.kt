package com.example.firebase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {

    private lateinit var inputMainEmail:EditText
    private lateinit var inputMainPass: EditText
    private lateinit var mainUserLogin:Button
    private lateinit var mainUserReg : Button
    private lateinit var mainUserRecover : Button
    private lateinit var submit : Button

    private lateinit var mAuth : FirebaseAuth



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mAuth = FirebaseAuth.getInstance()
        if (mAuth.currentUser != null){

            startActivity(Intent(this,UserLogin::class.java))
            finish()
        }


        setContentView(R.layout.activity_main)

        inputMainEmail = findViewById(R.id.inputStartEmail)
        inputMainPass = findViewById(R.id.inputStartPass)
        mainUserLogin = findViewById(R.id.startLogin)
        mainUserReg = findViewById(R.id.startReg)
        mainUserRecover = findViewById(R.id.startRecover)
        submit = findViewById(R.id.submit)




        mainUserLogin.setOnClickListener{
            val email = inputMainEmail.text.toString()
            val password = inputMainPass.text.toString()

            if(email.isEmpty() || password.isEmpty()){
                Toast.makeText(this,"Error!",Toast.LENGTH_LONG).show()

            } else {
                mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener{task->
                    if (task.isSuccessful){
                        startActivity(Intent(this,UserLogin::class.java))
                        finish()
                    } else {
                        Toast.makeText(this,"Error ! ",Toast.LENGTH_LONG).show()
                    }
                }
            }

        }




        mainUserReg.setOnClickListener{
            startActivity(Intent(this,Registration::class.java))

        }

        mainUserRecover.setOnClickListener{
            startActivity(Intent(this,LostPassword::class.java))
        }

        submit.setOnClickListener{
            startActivity(Intent(this,SubmitActivity::class.java))
        }






    }
}
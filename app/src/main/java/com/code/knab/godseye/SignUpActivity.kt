package com.code.knab.godseye

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_sign_up.*

class SignUpActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        val loginEditText = findViewById<EditText>(R.id.login_editText)
        val passwordEditText = findViewById<EditText>(R.id.password_editText)
        val repeatPasswordEditText = findViewById<EditText>(R.id.repeat_password_editText)


        confirm.setOnClickListener{

            if(passwordEditText.text.toString().equals(repeatPasswordEditText.text.toString()))
            {
                val newAccountData = UserData(loginEditText.text.toString(),passwordEditText.text.toString()) //*i don't know how to storage these data and transfer them to LoginActivity
            }
            else{
                Toast.makeText(this, "Podane hasła są różne", Toast.LENGTH_LONG).show()
            }


        }

    }
}

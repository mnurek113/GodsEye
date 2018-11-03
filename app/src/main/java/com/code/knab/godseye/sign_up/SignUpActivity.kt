package com.code.knab.godseye.sign_up

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import com.code.knab.godseye.R
import com.code.knab.godseye.login.LoginActivity
import com.code.knab.godseye.sign_up.mvp.SignUpModel
import com.code.knab.godseye.sign_up.mvp.SignUpPresenter
import com.code.knab.godseye.sign_up.mvp.SignUpMVP
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_sign_up.*

class SignUpActivity : AppCompatActivity(), SignUpMVP.View {

    private lateinit var sharedPrefs: SharedPreferences
    private lateinit var editor: SharedPreferences.Editor

    private var signUpModel: SignUpModel = SignUpModel()
    private var signUpPresenter: SignUpPresenter = SignUpPresenter(signUpModel, this)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        confirm.setOnClickListener{
            signUp()
        }

        sharedPrefs = getSharedPreferences("UserData",Context.MODE_PRIVATE)


    }

    private fun signUp() {
        signUpPresenter.save(loginEditText.text.toString(),passwordEditText.text.toString(),repeatPasswordEditText.text.toString(),sharedPrefs)
        loginEditText.setText("")
        passwordEditText.setText("")
        repeatPasswordEditText.setText("")

    }

    override fun signUpSuccessful() {
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
    }

    override fun signUpFailed() {
        Toast.makeText(applicationContext,"Podane hasła nie są takie same",Toast.LENGTH_SHORT).show()
        passwordEditText.setText("")
        repeatPasswordEditText.setText("")

    }

}




package com.code.knab.godseye.login

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.code.knab.godseye.R
import com.code.knab.godseye.login.mvp.LoginMVP
import com.code.knab.godseye.login.mvp.LoginModel
import com.code.knab.godseye.login.mvp.LoginPresenter
import com.code.knab.godseye.sign_up.SignUpActivity
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_sign_up.*

class LoginActivity : AppCompatActivity(), LoginMVP.View {


    private lateinit var sharedPrefs: SharedPreferences
    private var loginModel: LoginModel = LoginModel()
    private var loginPresenter: LoginPresenter = LoginPresenter(loginModel, this)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        log_in.setOnClickListener {
            login()
        }

        sharedPrefs = getSharedPreferences("UserData",Context.MODE_PRIVATE)
    }

    private fun login() {
        loginPresenter.logIn(loginEditText?.text.toString(), passwordEditText?.text.toString(), sharedPrefs)
    }

    override fun onLoginSuccessful() {
        val intent = Intent(this, SignUpActivity::class.java)
        startActivity(intent)
    }

    override fun onLoginFailed() {

        Toast.makeText(this,"Podane hasło lub login są nieprawidłowe",Toast.LENGTH_SHORT).show()
        password_editText.setText("")
        login_editText.setText("")
    }
}
